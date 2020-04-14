package com.firechiang.basic_grammar_2

/**
 * Groovy Map相关使用
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/10
 * @deprecated com.firechiang.basic_grammar_2* @version 1.0
 */
// 定义Map
def map = ["nam":"sadas","sadasda":"sda","sdad":12]
println "map的toString结果=${map}"
println "map的nam key的值="+map["nam"]
println "map的nam key的值="+map.nam
// 修改元素nam的值
map.nam = "sdadasda"
// 添加元素（注意：如果fdfdsdf键已存在，则将修改）
map.fdfdsdf = "sadasdasda"
// 添加map元素
map.sdsds = ["asa":"asdas","sada":"sadasd"]
// 注意：获取类型不能用 map.class，因为这样写是取值而不是获取Class
println "map类型="+map.getClass()+"，map的元素="+map

// 定义一个HashMap（注意：如果不指定类型，默认是 LinkedHashMap）
HashMap map2 = ["asda":"sdsdfs","fgdgfd":2];
println "map2的类型="+map2.getClass()+"，map2的值="+map2

// 遍历Map
map2.each {
    m -> println "key=${m.key},value=${m.value}"
}
// 遍历Map（i 表示索引位置（下标））
map2.eachWithIndex {
    def m, int i -> println "index=${i},key=${m.key},value=${m.value}"
}
// 遍历Map（直接遍历key和value）
map2.each {
    key,value -> println "key=${key},value=${value}"
}

// 遍历Map（直接遍历key和value以及下标index）
map2.eachWithIndex {
    key,value,index -> println "key=${key},value=${value},index=${index}"
}

// 查找map里面key包含as的第一个元素
def mm = map.find {
    m -> m.key.indexOf("as") != -1
}
println "map里面key包含as的第一个元素=${mm}"

// 查找map里面key包含da的所有元素
def ms = map.findAll {
    m -> m.key.indexOf("da") != -1
}
println "map里面key包含da的所有元素=${ms}"

// 查找map里面key包含da的所有元素的key
def ms1 = map.findAll {
    m -> m.key.indexOf("da") != -1
}.collect {
    m -> m.key
}
println "map里面key包含da的所有元素的key=${ms1}"


// 查找map里面key包含da的所有元素的key
def ms2 = map.findAll {
    m -> m.key.indexOf("da") != -1
}.collect {
    m -> m.key
}.toListString()
println "map里面key包含da的所有元素的key=${ms2}"

// 统计map里面key包含da的元素个数
def mc = map.count {
    m -> m.key.indexOf("da") != -1
}
println "map里面key包含da的元素个数=${mc}"

// map以value的class类型分组
def mg = map.groupBy {
    m -> m.value.getClass()
}
println "map以value的class类型分组=${mg}"

// map进行排序
def mapmap = map.sort {
    m1,m2 -> m1.value.toString().size().compareTo(m2.value.toString().size())
}
println "map排序后的结果=${mapmap}"