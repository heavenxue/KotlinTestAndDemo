package net.println.kotlin.dslDemo

/**
 * Created by Administrator on 2017/9/19.
 */

fun html(block: Tag.() -> Unit): Tag{
    return Tag("html").apply(block)
}

class StringNode(val content: String): Node{
    override fun render() = content
}

class Head: Tag("head")
class Body: Tag("body"){
    var id by MapDelegate(properties)
    var `class` by MapDelegate(properties)
}

fun Tag.body(block: Body.() -> Unit){
    this@body + Body().apply(block)
}

fun Tag.head(block: Head.() -> Unit){
    this@head + Head().apply(block)
}