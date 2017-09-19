package net.println.kotlin.dslDemo

/**
 * Created by Administrator on 2017/9/19.
 */

fun main(args: Array<String>){
    html {
        "id"("htmlId")
//        properties["id"] = "htmlId"
//        children.add(Tag("head"))
        "head"{
            "id"("headId")
        }
//        "body"{
//            "a"{
//                "href"("http://wwww.kotliner.cn")
//                + "Kotlin 中文博客"
//            }
//        }
        //修改后的body可以这么写
        body{
            id = "bodyId"
            `class` = "bodyClass"
            "a"{
                "href"("http://wwww.kotliner.cn")
                + "Kotlin 中文博客"
            }
        }

    }.render().let(::println)
}