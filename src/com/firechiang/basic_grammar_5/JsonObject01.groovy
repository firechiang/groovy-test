package com.firechiang.basic_grammar_5

import com.firechiang.basic_grammar_4.Person
import groovy.json.JsonOutput
import groovy.json.JsonParser
import groovy.json.JsonSlurper

/**
 * JSON 相关操作
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/13
 * @deprecated com.firechiang.basic_grammar_5* @version 1.0
 */
// 定义一个List
def lists = [new Person("毛毛",23),new Person("天天",11)]
// 将对象转换为json字符串
def jsonStr = JsonOutput.toJson(lists)
println "json字符串=${jsonStr}"
println "带格式的json字符串="+JsonOutput.prettyPrint(jsonStr)

// json对象转换工具
def jsonP = new JsonSlurper()
println "将json字符串转换为对象="+jsonP.parseText(jsonStr)


