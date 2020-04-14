package com.firechiang.basic_grammar_1

/**
 * 闭包自带的三个重要关键字: this,owner,delegate 的用法
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/8
 * @deprecated com.firechiang.basic_grammar_1* @version 1.0
 */
/**
 * 闭包自带的三个重要关键字: this,owner,delegate
 * this     变量代表最外层闭包定义处的类或对象（就是闭包所在类或对象）
 * owner    变量代表闭包定义处的类或对象（就是闭包所在类或对象）（注意：不是最外层的，就是上层闭包）
 * delegate 变量代表任意对象（默认等于owner相同），该变量的值可以修改（推荐用法就是修改这个变量的值来配合逻辑实现）
 */
def test_con = {
    println "this变量="+this
    println "owner变量="+owner
    println "delegate变量="+delegate
}
// 调用闭包
test_con.call()
println "-----------------------------------------------------------------------------"
/**
 * 定义一个类
 */
class TestTest {
    // 定义一个静态的闭包（注意：静态闭包这三个变量所指向的是TestTest类）
    def static stat_clouser = {
        println "TestTest类里面的stat_clouser闭包的this变量="+this
        println "TestTest类里面的stat_clouser闭包的owner变量="+owner
        println "TestTest类里面的stat_clouser闭包的delegate变量="+delegate
    }

    // 定义成员闭包（注意：非静态闭包这三个变量所指向的是TestTest类对象）
    def object_clouser = {
        println "TestTest类里面的stat_clouser闭包的this变量="+this
        println "TestTest类里面的stat_clouser闭包的owner变量="+owner
        println "TestTest类里面的stat_clouser闭包的delegate变量="+delegate
    }

    /**
     * 定义一个函数（注意：静态函数里面的闭包这三个变量所指向的是TestTest类）
     */
    def static sav() {
        // 定义一个闭包
        def sav_clouser = {
            println "TestTest类里面sav函数里面的sav_clouser闭包的this变量="+this
            println "TestTest类里面sav函数里面的sav_clouser闭包的owner变量="+owner
            println "TestTest类里面sav函数里面的sav_clouser闭包的delegate变量="+delegate
        }
        // 调用闭包
        sav_clouser.call()
    }
}
// 调用类里面的静态闭包
TestTest.stat_clouser.call()
println "-----------------------------------------------------------------------------"
new TestTest().object_clouser.call()
println "-----------------------------------------------------------------------------"
// 调用类里面的静态函数
TestTest.sav()
println "-----------------------------------------------------------------------------"

def nets_clouser = {
    /**
     * 注意：
     * 闭包里面的闭包的this还是指向最外层闭包所在类或对象
     */
    def ners_clouser = {
        println "闭包里面的闭包的this变量="+this
        println "闭包里面的闭包的owner变量="+owner
        println "闭包里面的闭包的delegate变量="+delegate
    }
    ners_clouser.call()
}
nets_clouser.call()
println "-----------------------------------------------------------------------------"

/**
 * 闭包的委托策略
 */
class Student {

    String name

    Student(String name){
        this.name = name
    }
    // 闭包（注意：这个默认就是返回这个字符串；还有 delegate 是闭包里面的关键字（默认指向当前闭包的对象或类））
    def pattenyy = { "my name is ${delegate.name}" }

    String toString() {
        //（注意：这个默认就是返回这个调用结果）
        pattenyy.call()
    }
}

class Teacere {
    String name

    Teacere(String name) {
        this.name = name
    }
}

def student = new Student("毛同学")
def teacere = new Teacere("毛老师")
// 改变 student 对象里面的 pattenyy 闭包的默认关键字 delegate 的值（注意：在上面的代码里面有获取delegate.name的值）
student.pattenyy.delegate = teacere
// 修改闭包的委托策略（这个策略就是：如果在委托的对象里面没有找到name属性，就从闭包所在类里面寻找）（注意：这个解释是错误的）
//student.pattenyy.resolveStrategy = Closure.DELEGATE_FIRST
println student.toString()
println teacere.toString()