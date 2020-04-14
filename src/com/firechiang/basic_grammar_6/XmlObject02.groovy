package com.firechiang.basic_grammar_6

import groovy.xml.MarkupBuilder

/**
 * Xml 生成相关
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/13
 * @deprecated com.firechiang.basic_grammar_6* @version 1.0
 */

/**
 * 生成xml格式数据
 * <langs type='current' count='3' mainstream='true'>
 <language flavor='static' version='1.5'>Java</language>
 <language flavor='dynamic' version='1.6.0'>Groovy</language>
 <language flavor='dynamic' version='1.9'>JavaScript</language>
 </langs>
 */

def sw1 = new StringWriter()
//用来生成xml数据的核心类
def xmlBuilder1 = new MarkupBuilder(sw1)
//根结点langs创建成功
xmlBuilder1.langs(type: 'current', count: '3',mainstream: 'true') {

    //第一个language节点
    language(flavor: 'static', version: '1.5') {
        age('16')
    }
    //第二个language节点
    language(flavor: 'dynamic', version: '1.6') {
        age('10')
    }
    //第三个language节点
    language(flavor: 'dynamic', version: '1.9', 'JavaScript')
    //第四个data节点
    data(sdsds: 'sadasdas')
}

println sw1
println "-------------------------------------------------------------------------"

def langs = new Langs()
//用来生成xml数据的核心类
def sw = new StringWriter()
def xmlBuilder = new MarkupBuilder(sw)
xmlBuilder.langs(type: langs.type, count: langs.count,mainstream: langs.mainstream) {
    //遍历所有的子结点
    langs.languages.each { lang ->
        language(flavor: lang.flavor,version: lang.version, lang.value)
    }
}
println sw
//对应xml中的langs结点
class Langs {
    String type = 'current'
    int count = 3
    boolean mainstream = true
    def languages = [
            new Language(flavor: 'static',version: '1.5', value: 'Java'),
            new Language(flavor: 'dynamic',version: '1.3', value: 'Groovy'),
            new Language(flavor: 'dynamic',version: '1.6', value: 'JavaScript')
    ]
}
//对应xml中的languang结点
class Language {
    String flavor
    String version
    String value
}