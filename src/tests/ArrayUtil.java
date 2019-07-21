package tests;

import io.github.mxudong.rs.randoms.BaseRandom;

/**
 * 数组测试工具
 *
 * @author Dong
 */
public class ArrayUtil {

    /**
     * 检查数组是否排序
     *
     * @param array            被检查数组
     * @param isAscendingOrder 是否为升序
     * @return is order
     */
    public static boolean isSort(int[] array, boolean isAscendingOrder) {
        if (isAscendingOrder) {
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < array.length; i++) {
                if (array[i] > array[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 生成一个随机数组
     *
     * @param minInteger  最小值
     * @param maxInteger  最大值
     * @param arrayLength 数组长度
     * @return 随机数组
     */
    public static int[] getRandomArray(int minInteger, int maxInteger, int arrayLength) {
        int[] ints = new int[arrayLength];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = BaseRandom.getRandomInt(minInteger, maxInteger);
        }
        return ints;
    }

    /**
     * 打印数组
     *
     * @param array 目标数组
     */
    public static void outputArray(int[] array) {

        final int lineCount = 10;

        for (int i = 0; i < array.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(array[i] + '\t');

        }
    }
}
