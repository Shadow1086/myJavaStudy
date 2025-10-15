package Class02.Error.Apply01;

import org.junit.Test;

public class FinallyTest02 {
    @Test
    public void test4() {
        FileInputStream fis = null;

        try {
            File file = new File("D:\\hello.txt");

            // 可能报FileNotFoundException
            fis = new FileInputStream(file);

            // 可能报IOException
            int data = fis.read();
            while (data != -1) {
                System.out.print((char) data);
                // 可能报IOException
                data = fis.read();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 重点：将流资源的关闭操作声明在finally中
            try {
                if (fis != null)
                    fis.close();
                // 可能报IOException
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}