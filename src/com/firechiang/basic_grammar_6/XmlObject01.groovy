package com.firechiang.basic_grammar_6

import groovy.xml.XmlSlurper

/**
 * XML 解析相关
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/13
 * @deprecated com.firechiang.basic_grammar_6* @version 1.0
 */

final String xml = '''
    <response version-api="2.0">
        <value>
            <books id="1" classification="android">
                <book available="20" id="1">
                    <title>疯狂Android讲义</title>
                    <author id="1">李刚</author>
                </book>
                <book available="14" id="2">
                   <title>第一行代码</title>
                   <author id="2">郭林</author>
               </book>
               <book available="13" id="3">
                   <title>Android开发艺术探索</title>
                   <author id="3">任玉刚</author>
               </book>
               <book available="5" id="4">
                   <title>Android源码设计模式</title>
                   <author id="4">何红辉</author>
               </book>
           </books>
           <books id="2" classification="web">
               <book available="10" id="1">
                   <title>Vue从入门到精通</title>
                   <author id="4">李刚</author>
               </book>
           </books>
       </value>
    </response>
'''

// Xml解析器（注意：xml解析从父节点以下开始，不包括父节点）
def xmlP = new XmlSlurper()
def xmlObject = xmlP.parseText(xml)

// 打印xml文件里面value节点下，第0个books里面的第0个book节点下title标签的值
println xmlObject.value.books[0].book[0].title.text()
// 打印xml文件里面value节点下，第0个books里面的第0个book节点的available属性的值
println xmlObject.value.books[0].book[0].@available

// 遍历Xml里面的每一个books节点
xmlObject.value.books.each { books ->
    // 遍历books下的每一book节点
    books.book.each {
        book -> println book.author.text()
    }
}

// 查找Xml里面所有符合条件的节点
def aaa = xmlObject.depthFirst().findAll {
    // 查找book节点下author值等于李刚
    book -> return book.author.text() == "李刚"
}
// 这个写法和上面的等同
def bbb = xmlObject.'**'.findAll {
        // 查找book节点下author值等于李刚
    book -> return book.author.text() == "李刚"
}
println "查找到的Xml节点=${aaa}"


// 遍历Xml某一个节点下的所有节点（注意：这个是通过children函数）
def ccc = xmlObject.value.books.children().findAll {
        // 查找节点名称等于title并且节点的ID等于2的所有节点
    node -> node.name() == "title" && node.@id == "2"
// 过滤（相当于JAVA的Stream）
}.collect {
    // 只要title的值
    node -> node.title.text()
}
println "查找到的Xml下value节点的books节点下=${aaa}"