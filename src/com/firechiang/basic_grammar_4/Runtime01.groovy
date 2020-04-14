package com.firechiang.basic_grammar_4

/**
 * 运行时相关使用（注意：所有类默认继承了GroovyObject类）
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/10
 * @deprecated com.firechiang.basic_grammar_4* @version 1.0
 */

/**
 * 定义一个类（默认都是public）
 */
class Person implements Serializable {
    String name
    Integer age

    Person(){}

    Person(String name,Integer age) {
        this.name = name
        this.age = age
    }

    /**
     * 注意：这个其实是重写父类里面的函数了，如果调用该类里面没有的函数就会走这个函数的逻辑（优先级低于 methodMissing 函数
     * 默认优先调用 methodMissing 函数，如果 methodMissing 函数没有，就调用 invokeMethod 函数
     * @param name
     * @param args
     * @return
     */
    def invokeMethod(String name,Object args) {
        "调用invokeMethod方法，名称:${},参数:${args}"
    }

    /**
     * 注意：这个其实是重写父类里面的函数了，如果调用该类里面没有的函数就会走这个函数的逻辑（优先级高于 invokeMethod 函数）
     * 默认优先调用 methodMissing 函数，如果 methodMissing 函数没有，就调用 invokeMethod 函数
     * @param name
     * @param args
     */
    def methodMissing(String name,Object args) {
        "调用methodMissing方法，名称:${},参数:${args}"
    }
}
def person = new Person("毛毛",4111)
println "person.name的结果:"+person.getName()
println "调用类里面没有的函数返回结果:"+person.asasa()