package com.firechiang.basic_grammar_1

/**
 * Groovy基础语法逻辑控制以及循环相关
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/8
 * @deprecated com.firechiang.basic_grammar_1* @version 1.0
 */
//def x = 2.15;
// 匹配 BigDecimal类型
//def x = 3.14
def x = 20
// switch可以匹配很多类型（具体如下）
switch (x) {
    case 2.15 :
        println "等于2.15"
        break
    case 'maomoa':
        println "等于maomoa"
        break
    case [1,2,"3"]:
        println "等于List"
        break
    case BigDecimal:
        println "等于BigDecimal类型"
        break
    case 2..30:
        println "在2-30的范围以内"
        break
    default: println "未匹配到任何值"
}

// 匹配 class
switch (x.class) {
    case [Integer.class,String.class]:
        println "等于Integer或String类型"
        break
    case BigDecimal:
        println "等于BigDecimal类型"
        break
    default: println "未匹配到任何值"
}

// 循环0-9
for(i in 0..9){
    print i+","
}
println ""
// 循环List
for(i in [1,3,5,6]) {
    print i+","
}
println ""

// 循环Map
for(map in ["as":"sda","asa":"sadas","sss":1]) {
    print "key="+map.key+"value="+map.value+","
}