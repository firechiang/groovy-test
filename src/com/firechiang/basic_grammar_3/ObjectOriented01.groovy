package com.firechiang.basic_grammar_3

/**
 * 面向对象相关（注意：所有类默认继承了GroovyObject类）
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/10
 * @deprecated com.firechiang.basic_grammar_3* @version 1.0
 */


/**
 * 定义一个接口（注意：默认public的，而且不允许定义非public的函数）
 */
interface Action {

    def getA();

    String getName()
}

/**
 * 定义个抽象类，并实现接口（注意：默认是票public的函数也是）
 */
trait ImplAction implements Action {
    // 定义一个抽象函数
    abstract void aaa()
}

/**
 * 注意：默认class和属性都是public的
 * 人员类
 */
class Person implements Action {

    String name

    Integer age

    Person() {}

    Person(String name,Integer age) {
        this.name = name
        this.age = age
    }

    def increasAge (Integer years) {
        this.age += years
    }

    def getA() {
        this.age
    }
}
// 为Person类动态添加属性（注意：如果不是在main函数里面动态添加的属性和函数就只能在当前脚本里面使用，所以建议在main函数初始化动态添加属性和函数）
Person.metaClass.sex = "sdfsdf"
// 为Person类动态添加方法（注意：如果不是在main函数里面动态添加的属性和函数就只能在当前脚本里面使用，所以建议在main函数初始化动态添加属性和函数）
Person.metaClass.UpName = {
    def nae -> nae+=name+=sex
}

// 为Person类动态添加静态属性（注意：如果不是在main函数里面动态添加的属性和函数就只能在当前脚本里面使用，所以建议在main函数初始化动态添加属性和函数）
Person.metaClass.static.sesss = "44445"

// 为Person类动态添加静态方法（注意：如果不是在main函数里面动态添加的属性和函数就只能在当前脚本里面使用，所以建议在main函数初始化动态添加属性和函数）
Person.metaClass.static.UpNamesds = {
    def nae -> nae+=name+=sex
}

// 创建对象
def person = new Person("maomao",1212)
println "person=${person}"
// 注意：person.name实际上调用的是setName()函数
person.name = "maomoa"
// 注意：person.name实际上调用的是getName()函数
println "person.name=${person.name}"
println "person.age=${person.age}"

println "调用动态添加的函数UpName的结果="+person.UpName("AAAAA")