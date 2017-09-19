package net.println.kotlin.DslDemo

/**
 * 创建一节点的接口，有一个渲染的方法，返回一个String
 * Created by Administrator on 2017/9/19.
 */
interface Node{
    fun render(): String
}