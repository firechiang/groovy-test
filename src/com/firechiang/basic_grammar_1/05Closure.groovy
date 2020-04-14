package com.firechiang.basic_grammar_1

/**
 * Groovy闭包相关（就是代码块的使用）
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/8
 * @deprecated com.firechiang.basic_grammar_1* @version 1.0
 */

// 定义一个没有参数的闭包
def clouser = {println "测试打印"}
// 使用call函数调用闭包
clouser.call()
// 直接使用函数的方式调用闭包
clouser()

// 定义一个使用默认参数的闭包（注意：如果闭包没有指定参数，它会有一个默认参数it）
def c2 = {println "获取默认参数it=${it}"}
c2.call()
c2.call("我是默认参数的值")

// 定义一个有参数的闭包（注意：${x} 就是获取x的值）
def c1 = {String x,String y -> println("x=${x},${y}")}
// 调用闭包
def res = c1.call("参数1","参数2")
println "闭包的返回值=${res}"

// 定义一个指定返回值的闭包
def c3 = {String c -> return "参数=${c}"}
def res1 = c3.call("11")
println "闭包的返回值=(${res1})"

// 定义一个需要传入闭包的参数
void test(Closure closure) {
    // 直接调用闭包
    closure.call()
}
// 执行test函数（注意：闭包参数可以写在方法的括号外）
test {
    println "闭包要执行的东西"
}
// 这个写法和上面的写法等同
test() {
    println "闭包要执行的东西"
}