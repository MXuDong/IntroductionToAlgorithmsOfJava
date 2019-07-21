package tests;

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
     */
    public boolean isSort(int[] array, boolean isAscendingOrder) {
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

    public int [] getRandomArray(int minInteger, int maxInteger, int arrayLength){

    }
}
