package com.firechiang.basic_grammar_1

/**
 * Groovy基础语法String相关操作符（String相关操作函数），Groovy的String支持Java String的所有方法还有很多新增特性
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/8
 * @deprecated com.firechiang.basic_grammar_1* @version 1.0
 */
def name = "maomoa"
println "变量name的长度: "+name.length()
// 将name的值扩充到10位，用a填充（如果a没传，默认空格填充）（注意：两边都会填充）
println name.center(10,"a")
// 将name的值扩充到8位，用a在左边填充填充
println name.padLeft(8,"a")
// 将name的值扩充到8位，用a在右边填充填充
println name.padRight(8,"a")

println "字符串name的值倒叙="+name.reverse()
println "字符串name的值，首字母大写="+name.capitalize()
println "判断字符串name的值是否是数字: "+name.isNumber()
println "将字符串转换为数字:"+("12".toInteger())

//--------------------------字符串比较------------------------//
def mao = 'maomoa';
// 比较字符串的大小
println name.compareTo(mao)
// name是否大于mao（注意：Groovy程序可以直接使用比较符进行比较）
println name > mao

//-------------------------获取字符串中的某个字符---------------//
println "字符串name的值的第一个字符="+name[0]
println "字符串name的值的第一到第3个字符="+name[0..2]

//-------------------------字符串的减法使用--------------------//
println "变量name的值减去oa后="+name.minus("oa")+" 注意：这个其实就是将oa替换成空串了"
def name2 = "oa";
// 直接使用减号
println "变量name的值减去oa后="+(name - name2)+" 注意：这个其实就是将oa替换成空串了"