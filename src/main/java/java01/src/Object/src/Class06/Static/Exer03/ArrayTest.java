//package Class06.Static.Exer03;
//
//import org.testng.annotations.Test;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
//import static org.junit.Assert.*;
//
//public class ArrayTest {
//    @Test
//    public void testSort() {
//        int[] arr = {5, 2, 9, 1, 5, 6};
//        int[] expected = {9, 6, 5, 5, 2, 1};
//        int[] result = Array.sort(arr.clone());
//        assertArrayEquals(expected, result);
//    }
//
//    @Test
//    public void testMaxArr() {
//        int[] arr = {5, 2, 9, 1, 5, 6};
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(out));
//        Array.maxArr(arr);
//        System.setOut(System.out);
//        String output = out.toString();
//        assertTrue(output.contains("最大值为：9"));
//        assertTrue(output.contains("最大值索引：2"));
//    }
//
//    @Test
//    public void testMinArr() {
//        int[] arr = {5, 2, 9, 1, 5, 6};
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(out));
//        Array.minArr(arr);
//        System.setOut(System.out);
//        String output = out.toString();
//        assertTrue(output.contains("最小值为：1"));
//        assertTrue(output.contains("最小值索引：3"));
//    }
//
//    @Test
//    public void testSumArr() {
//        int[] arr = {5, 2, 9, 1, 5, 6};
//        assertEquals(28, Array.sumArr(arr));
//        assertEquals(0, Array.sumArr(new int[]{}));
//    }
//
//    @Test
//    public void testAverageArr() {
//        int[] arr = {5, 2, 9, 1, 5, 6};
//        assertEquals(28.0/6, Array.averageArr(arr), 1e-6);
//        int[] arr2 = {10};
//        assertEquals(10.0, Array.averageArr(arr2), 1e-6);
//    }
//
//    @Test
//    public void testInversionArr() {
//        int[] arr = {1, 2, 3, 4, 5};
//        int[] expected = {5, 4, 3, 2, 1};
//        int[] result = Array.inversionArr(arr.clone());
//        assertArrayEquals(expected, result);
//        int[] single = {42};
//        assertArrayEquals(new int[]{42}, Array.inversionArr(single.clone()));
//    }
//
//    @Test
//    public void testFindArr() {
//        int[] arr = {5, 2, 9, 1, 5, 6};
//        assertEquals(0, Array.findArr(9, arr.clone())); // 9在排序后索引0
//        assertEquals(-1, Array.findArr(100, arr.clone()));
//        assertEquals(5, Array.findArr(1, arr.clone())); // 1在排序后索引5
//    }
//
//    @Test
//    public void testEdgeCases() {
//        int[] empty = {};
//        int[] single = {42};
//        // maxArr/minArr on empty array will throw exception
//        try {
//            Array.maxArr(empty);
//            fail("Should throw exception");
//        } catch (Exception e) {
//            // expected
//        }
//        try {
//            Array.minArr(empty);
//            fail("Should throw exception");
//        } catch (Exception e) {
//            // expected
//        }
//        // single element
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(out));
//        Array.maxArr(single);
//        Array.minArr(single);
//        System.setOut(System.out);
//        String output = out.toString();
//        assertTrue(output.contains("最大值为：42"));
//        assertTrue(output.contains("最小值为：42"));
//        assertEquals(42, Array.sumArr(single));
//        assertEquals(42.0, Array.averageArr(single), 1e-6);
//        assertArrayEquals(new int[]{42}, Array.inversionArr(single.clone()));
//        assertEquals(0, Array.findArr(42, single.clone()));
//        assertEquals(-1, Array.findArr(100, single.clone()));
//    }
//}
//
