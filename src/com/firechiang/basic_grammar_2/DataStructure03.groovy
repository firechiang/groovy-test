package com.firechiang.basic_grammar_2

/**
 * Groovy Range（范围）相关使用
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/10
 * @deprecated com.firechiang.basic_grammar_2* @version 1.0
 */
// 定义一个范围
def range = 1..10
println "范围=${range}"
println "范围的第一个值=${range[0]}"
println "范围的第一个值=${range.from}"
println "范围的最后一个值=${range.to}"
println "范围里面是否包含0: ${range.contains(0)}"

// 遍历范围
range.each {
    r -> print r+","
}
println ""
for(r in range){
    print r+","
}
println ""

def num = 10

switch (num) {
    // 1到小于60的范围（1 到 59）
    case 1..<60:
        println "不及格"
        break
    case 60..<70:
        println "及格"
        break
    case 70..80:
        println "良好"
        break
    case 80..100:
        println "优秀"
        break
}