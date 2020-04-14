package com.firechiang.basic_grammar_5

import groovy.json.JsonSlurper

/**
 * 使用网络请求获取JSON字符串，在转换成JSON对象，简单使用
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/13
 * @deprecated com.firechiang.basic_grammar_5* @version 1.0
 */

/**
 * 定义一个获取JSON字符串的函数
 * @param url
 */
def getNetwordData(String url) {
    def conn = new URL(url).openConnection()
    //conn.setRequestProperty("Request Method","GET")
    conn.connect()
    return conn.content.text
}

def json = getNetwordData("https://movie.douban.com/j/search_tags?type=tv")
println "获取的JSON="+json

def jsonP = new JsonSlurper()
println "json字符串转换为对象="+jsonP.parseText(json)