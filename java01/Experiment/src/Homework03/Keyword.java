package Homework03;

/**
 * ClassName: Keyword
 * Description:
 * 
 * 将Java语言的所有关键字保存在一个字符串数组中，
 * 对其按升序排序，再采用顺序查找或二分法查找，判断一个字符串是否是Java语言的关键字。按照模板撰写实验报告。
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-10-29 12:26:55
 */

public class Keyword {

    // Java 所有关键字（50个关键字 + 3个保留字）
    private static String[] keywords = {
            "abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else",
            "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import",
            "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this", "throw", "throws",
            "transient", "try", "void", "volatile", "while",
            "true", "false", "null"
    };

    /**
     * 排序
     */
    public static void sort() {
        for (int i = 0; i < keywords.length - 1; i++) {
            for (int j = 0; j < keywords.length - 1; j++) {
                if (keywords[j].compareTo(keywords[j + 1]) > 0) {
                    String temp = keywords[j];
                    keywords[j] = keywords[j + 1];
                    keywords[j + 1] = temp;
                }
            }
        }
    }


/**
 * 二分查找字符串
 * @param str 目标字符串
 * @return 返回索引值，若没有的话，返回-1
 */
    public static int find(String str) {
        Keyword.sort();
        int left = 0;
        int right = keywords.length - 1;
        int mid = (left + right) / 2;

        int num = str.compareTo(keywords[mid]);
        while (left <= right) {
            if (num == 0) {
                return mid;
            } else if (num > 0) {
                left = mid - 1;
            } else if (num < 0) {
                right = mid + 1;
            }
            mid = (left + right) / 2;
            num = str.compareTo(keywords[mid]);
        }
        return -1;
    }
}
