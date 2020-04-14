package com.firechiang.basic_grammar_7

import com.firechiang.basic_grammar_4.Person

/**
 * 对象读写相关
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/14
 * @deprecated com.firechiang.basic_grammar_7* @version 1.0
 */

/**
 * 将对象写入文件
 * @param object     对象
 * @param targetPath 目标文件
 */
def saveObject(Object object,String targetPath) {
    def targetFile = new File(targetPath)
    if(!targetFile.exists()){
        targetFile.createNewFile()
    }
    // 将对象写入文件
    targetFile.withObjectOutputStream {
        out -> out.writeObject(object)
    }
}

def readObject(String sourcePath) {
    def file = new File(sourcePath)
    if(null == file || !file.exists()){
        return null
    }
    // 读取对象
    def object = file.withObjectInputStream {
        input -> input.readObject()
    }
    return object
}
def person = new Person("sadasda",1212)
// 保存对象
//saveObject(person,"../../../../data/object_file.txt")

def aaa = readObject("../../../../data/object_file.txt")
println "从文件里面读取到的Object="+aaa

