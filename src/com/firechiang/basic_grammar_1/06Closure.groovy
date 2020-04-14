package com.firechiang.basic_grammar_1

/**
 * 数字结合闭包用法
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/8
 * @deprecated com.firechiang.basic_grammar_1* @version 1.0
 */
// upto函数简单使用（）
void uptoInfo(int num) {
    // 1.upto 就是要从1增加到num，闭包里面就是每次增加要做的操作
    1.upto(num,{n -> print n+","})
}
uptoInfo(10)
println ""

// 定义一个使用递增算阶乘的函数
int fab(int num) {
    int res = 1
    // 1.upto 就是要从1递增到num，闭包里面就是每次递增要做的操作（res *= n 表示 res乘等于n（就是res=res*n））
    1.upto(num,{n -> res *= n })
    return res
}
println "10的阶乘="+fab(10)

// 定义一个使用递减算阶乘的函数
int fab2(int num) {
    res = 1
    // num.downto 就是要从num递减到1，闭包里面就是每次递减要做的操作（res *= n 表示 res乘等于n（就是res=res*n））
    num.downto(1,{n-> res *= n})
    return res
}
println "10的阶乘="+fab2(10)

int cal(int num) {
    int res = 0
    // 从0开始一直递增1，直到 num - 1
    num.times {
        n -> print n+","
    }
    return res
}
println cal(10)