package com.firechiang.basic_grammar_1

/**
 * Groovy基础语法String的定义方式
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/8
 * @deprecated com.firechiang.basic_grammar_1* @version 1.0
 */
// 使用单引号定义String变量（注意：它和双引号的String变量，没有任何区别）
def name1 = 'maomao'
// 打印变量name的值
println name1
println name1.class
// 使用3个单引号定义String变量（注意：它和普通String变量是有区别的，3个单引号定义String变量是有格式的）
def name3 = '''第一行
第二行
第三行'''
// 打印name3的值（注意：name3是有格式的（也就是换行也会打印出来））
println name3


def hello = "1";
// 定义变量hell2（注意：${hello}的意思就是获取hello变量的值，还有这种获取方式必须是双引号的字符串才能使用）
def hell2 = "${hello}2";
// 打印hello2的值
println hell2
println "变量hell2的类型："+hell2.class

// ${2 + 2} 就是 2 + 2 的值（注意：mao这个变量的类型会是GString）
def mao = "hello 2 + 2 = ${2 + 2}"
println mao
// 打印调用函数后的值（注意：这个是为了测试String类型的参数可以直接传GString类型）
println echo(mao)
// 定义一个函数
String echo(String str) {
    return str
}