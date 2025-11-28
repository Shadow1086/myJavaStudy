package com.myjavastudy.g_File.File;

import org.junit.Test;

import java.io.File;

/**
 * 类名: FileMethodTest
 * 创建时间: 2025/11/23 19:44
 * 项目描述:
 *
 * @author htLiang
 */
public class FileMethodTest {
    /*
     * 获取文件和目录基本信息
     * public String getName() ：获取名称
     * public String getPath() ：获取路径
     * public String getAbsolutePath()`：获取绝对路径
     * public File getAbsoluteFile()：获取绝对路径表示的文件
     * public String getParent()`：获取上层文件目录路径。若无，返回null
     * public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
     * public long lastModified() ：获取最后一次的修改时间，毫秒值
     * */
    @Test
    public void test01() {
        File file1 = new File("/Volumes/study/02-java/myJavaStudy/src/main/java/com/myjavastudy/i_File");
        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsolutePath());
        System.out.println("获取绝对路径代表的文件：" + file1.getAbsoluteFile());
        System.out.println("父目录：" + file1.getParent());
        System.out.println("获取文件长度：" + file1.length());
        System.out.println("最后一次修改的时间（时间戳）：" + file1.lastModified());
    }
    /*
     * 列出目录的下一级
     * public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
     * public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。
     * */
    @Test
    public void test02() {
        File file = new File("/Volumes/study/02-java/myJavaStudy/src/main/java/com/myjavastudy/i_File");
        String[] str1 = file.list();
        System.out.println("list(),获取file目录下的所有子文件");
        for(String str:str1){
            System.out.println(str);
        }
        File[] fileArr = file.listFiles();
        System.out.println("listFiles(),返回File类型的数组，获取file目录下的所有子文件");
        for(File file1:fileArr){
            System.out.println(file1.getName());
        }
    }
    /*
    File类的重命名功能
    - public boolean renameTo(File dest):把文件重命名为指定的文件路径。

    举例：
    file1.renameTo(file2):要想此方法执行完，返回true。要求：
       file1必须存在，且file2必须不存在，且file2所在的文件目录需要存在。
    * */
    /*
    判断功能的方法
    - `public boolean exists()` ：此File表示的文件或目录是否实际存在。
    - `public boolean isDirectory()` ：此File表示的是否为目录。
    - `public boolean isFile()` ：此File表示的是否为文件。
    - public boolean canRead() ：判断是否可读
    - public boolean canWrite() ：判断是否可写
    - public boolean isHidden() ：判断是否隐藏
    * */
   /*
    创建、删除功能
    - `public boolean createNewFile()` ：创建文件。若文件存在，则不创建，返回false。
    - `public boolean mkdir()` ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
    - `public boolean mkdirs()` ：创建文件目录。如果上层文件目录不存在，一并创建。
    - `public boolean delete()` ：删除文件或者文件夹
      删除注意事项：① Java中的删除不走回收站。② 要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录。
    * */
}
