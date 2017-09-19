package net.println.kotlin.DslDemo

import java.lang.StringBuilder

/**
 * Created by Administrator on 2017/9/19.
 */
class Tag(val name: String): Node{
    //子节点，比如<head>这样的子节点
    val children = ArrayList<Node>()
    //属性 比如 style这样的属性
    val properties = HashMap<String,String>()
    //可以渲染成一个这样的html片段<html id="htmlid" style=""><head></head><body></body></html>
    override fun render(): String {
        return StringBuilder().append("<")
                .append(name)
                .toString()
    }
}