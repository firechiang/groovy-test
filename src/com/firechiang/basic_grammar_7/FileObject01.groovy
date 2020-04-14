package com.firechiang.basic_grammar_7

/**
 * 文件操作相关
 * 注意：这个文件使用 Groovy Scrip 模板创建而不是 Groovy Class模板
 * @author JIANG* @date 2020/4/14
 * @deprecated com.firechiang.basic_grammar_7* @version 1.0
 */
def file = new File("../../../../data/test.xml")

// 遍历文件里面的每一行数据
file.eachLine {
    line -> println line
}
println "----------------------------------------------------------"
println "文件里面的所有内容"+file.getText()
// 读取文件里面的每一行
def list = file.readLines()
println "----------------------------------------------------------"
println list
println "----------------------------------------------------------"
// 读取前100个字符
def wr = file.withReader {
    reader ->
        char[] c = new char[100]
        reader.read(c)
        return c
}
println wr
println "----------------------------------------------------------"

// 拷贝文件
copy("../../../../data/test.xml","../../../../data/test.xml1")

/**
 * 拷贝文件函数
 * @param sourcePath  源文件
 * @param targetPath  目标文件
 * @return
 */
def copy(String sourcePath,String targetPath) {
    try {
        def targetFile = new File(targetPath)
        if(!targetFile.exists()){
            targetFile.createNewFile()
        }
        // 开始拷贝
        new File(sourcePath).withReader {
            reader ->
                // 获取文件里面的每一行
                def lines = reader.readLines()
                // 写入文件
                targetFile.withWriter {
                    write ->
                        // 遍历源文件里面的每一行，将每一行写入目标文件
                        lines.each {
                            line ->
                                write.write(line+"\r\n")
                        }
                }
        }
    } catch(Exception e){
        e.printStackTrace()
    }
}