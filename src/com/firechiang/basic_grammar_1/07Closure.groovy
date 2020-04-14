package com.firechiang.basic_grammar_1

/**
 * 字符串结合闭包用法
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/8
 * @deprecated com.firechiang.basic_grammar_1* @version 1.0
 */

def name = "asdasssdldsfs"
// 使用字符串的 each 函数遍历字符（注意：闭包可以写在函数括号的外面（也建议写在括号函数的外面））
name.each {
    str -> print str+","
}
println ""
// 这个写法和上面的写法等同
name.each ({
    // multiply()函数是将每个字符扩充2次（就是打印两次）
    str -> print str.multiply(2)+","
})
println ""

def str = name.find {
    // find的闭包必须返回一个boolean类型返回值（就是指定是否找到了字符串）
    str -> str == "a"
}
println "name.find的返回值=${str}"

// findAll会找到所有符合条件的字符，最后返回一个List集合
def str2 = name.findAll {
    // findAll的闭包必须返回一个boolean类型返回值（就是指定符合条件的字符）
    aa -> aa == "a"
}
println "name.findAll的返回值=${str2}"

// any 函数判断是否包含某个字符
def str3 = name.any {
    bb -> bb == "a"
}
println "any函数判断字符串name的值是否包含 a 字符：${str3}"

// every 判断字符串里面的每一个字符是否符合某一个判断
def str4 = name.every {
    aa -> aa.isNumber()
}
println "every函数判断字符串name的值是否都是数字：${str4}"

// collect处理完每一个字符并返回List集合
def str5 = name.collect {
    aa -> aa.toUpperCase()
}
println "collect函数处理完每一个字符后的结果是：${str5}"