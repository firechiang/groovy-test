package com.firechiang.basic_grammar_2

import javafx.collections.transformation.SortedList

/**
 * Groovy 数组和List相关使用
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/10
 * @deprecated com.firechiang.basic_grammar_2* @version 1.0
 */

// 定义一个数组（注意：如果使用了 def 关键字，那么最后一定要用 as 进行转换，否则就成了List）
String[] array1 = ["121","2312"]
def array = ["23","ss","sdfs"] as String[]

// 定义一个List（注意：List 使用 def 关键字定义）
def list = [1,3,2]
list.add(0)
// 打印List
println "list的类型="+list.class+"，list的元素="+list
// 定义一个排序规则的闭包
def c = {
    a,b -> a == b ? 0 : Math.abs(a) > Math.abs(b) ? 1 : -1
}
// Java方式的排序
//Collections.sort(list,c)

// Groovy方式排序（注意：这个其实就是直接调用 sort 函数，再传一个排序规则的闭包即可）
list.sort(c)

// 这个写法和上面的一样
/*list.sort() {
 *   a,b -> a == b ? 0 : Math.abs(a) > Math.abs(b) ? 1 : -1
}*/

// 打印List
println "list的类型="+list.class+"，list的元素="+list


def list2 = ["pffs","bsf","td","qdsfsdfs"]
// 排序规则（注意：List的排序规则如果只使用一个参数，那么默认就按照返回值的大小进行排序）
list2.sort(){
    str -> str.size()
}
println "List2里面的元素根据长度排序后的结果"+list2


def list3 = [1,3,4,5,6,7,7,0]
println "list3里面的最大值="+list3.max()+"，list里面的最小值="+list3.min()
// 对每个元素取绝对值以后，返回最大或最小
println "list3里面的最大值="+list3.max(){m -> Math.abs(m)}+"，list里面的最小值="+list3.min(){cc -> Math.abs(cc)}
// 查找List里面所有元素中第一个是偶数的元素
def v = list3.find {
    val -> val % 2 == 0
}
println "第一个偶数="+v

// 查找List里面所有元素中所有是偶数的元素
def v2 = list3.findAll {
    val -> val % 2 == 0
}
println "所有的偶数="+v2
// 查找元素里面是否有偶数
def v4 = list3.any{
    val -> val % 2 == 0
}
println "list3里面是否包含偶数"+v4
// 其实遇到能匹配的就加1
println "list3里面有多少个偶数="+list3.count {val -> val % 2 == 0}