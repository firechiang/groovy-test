package com.firechiang.basic_grammar_1

/**
 * Groovy基础语法
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/8
 * @deprecated com.firechiang.basic_grammar_1* @version 1.0
 */
// 指定变量类型定义变量
int x = 10;
// 打印变量类型（注意：基础类型在Groovy里面会包装成对象类型）
println(x.class);
// 打印x的值
println x;

// 使用 def 关键字定义变量（自动推断变量类型）
def y = 10;
// 打印y变量的类型
println y.class
def q = "我是String";
// 打印q变量的类型
println q.class;
def f = 3.14;
// 打印f变量的类型
println "变量f的类型是："+f.class
// 使用def关键字定义的变量，可以直接改变类型和值
f = "改变变量的类型";
// 打印f变量的类型
println "变量f的类型变成了："+f.class

// 定义Map
def map = ["as":"sda","asa":"sadas","sss":1]
// 定义List
def list = [1,"3","asda"]