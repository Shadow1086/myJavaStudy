package com.myjavastudy.g_File.a_File;

import org.junit.Test;

import java.io.File;

/**
 * 类名: FileTest01
 * 创建时间: 2025/11/23 19:33
 * 项目描述:
 *
 * File对象的初始化
 *
 * @author htLiang
 */
public class FileTest01 {
    /*
     * `public File(String pathname) ` ：以pathname为路径创建File对象，可以是绝对路径或者相对路径，
     *          如果pathname是相对路径，则默认的当前路径在系统属性user.dir中存储。
     * `public File(String parent, String child) ` ：以parent为父路径，child为子路径创建File对象。
     * `public File(File parent, String child)` ：根据一个父File对象和子文件路径创建File对象
     *
     * 文件的路径表示方式：
     * 方式1：绝对路径：以windows操作系统为例，包括盘符在内的文件或文件目录的完整路径。
     *               以Mac操作系统为例：/Volumes/study/02-java/myJavaStudy/src/main/java
     * 方式2：相对路径：相对于某一个文件目录来讲的相对的位置。
     *          在IDEA中，如果使用单元测试方法：相对于当前的module来讲
     *                   如果使用main()方法：相对于当前的project来讲
     * */

    @Test
    public void test01() {
        File file1 = new File("/Volumes/study/02-java/myJavaStudy/src/main/java");
        System.out.println(file1.getName());
    }
}
