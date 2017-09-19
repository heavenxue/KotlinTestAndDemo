package net.println.kotlin.dslDemo

import java.lang.StringBuilder

/**
 * Created by Administrator on 2017/9/19.
 */
open class Tag(val name: String): Node{
    //子节点，比如<head>这样的子节点
    val children = ArrayList<Node>()
    //属性 比如 style这样的属性
    val properties = HashMap<String,String>()

    operator fun String.invoke(value: String){
        properties[this] = value
    }

    operator fun String.invoke(block: Tag.() -> Unit){
//        children.add(Tag(this).apply(block)) 两者写法都可以
        this@Tag.children.add(Tag(this).apply(block))
    }

    operator fun String.unaryPlus(){
        children.add(StringNode(this))
    }

    operator fun plus(node: Node){
        children.add(node)
    }


    //可以渲染成一个这样的html片段<html id="htmlid" style=""><head></head><body></body></html>
    override fun render(): String {
        return StringBuilder().append("<")
                .append(name)
                .let {
                    stringBuilder ->
                    if (this.properties.isNotEmpty()){
                        stringBuilder.append(" ")
                        this.properties.forEach{
                            stringBuilder.append(it.key)
                                    .append(" =\"")
                                    .append(it.value)
                                    .append("\"")
                        }
                    }
                    stringBuilder
                }
                .append(">")
                .let {
                    stringBuilder ->
//                    children.map{
//                        node ->
//                        node.render()
//                    }.map {
//                        stringBuilder.append(it)
//                    }
                    //还可以简化成这样，跟上面注释掉的一样的效果
                    children.map(Node::render).map(stringBuilder::append)
                    stringBuilder
                }
                .append("</$name>")
                .toString()
    }
}