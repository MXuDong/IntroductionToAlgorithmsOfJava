package chapter2.part1.insert_sort;

/**
 * Code name : InsertSort
 * 代码段名称  : 插入排序
 *
 * @author Dong
 */
public class InsertSort {

    /* 伪代码
    INSERT-SORT(A)
        for j = 2 to A.length
            key = A[j]
            // Insert A[j] into the sorted sequence A[1..j-1].
            // 翻译 将A[j]插入到已排序序列A[1..j-1]
            i = j - 1
            while i > 0 and A[j] > key
                A[i+1] = A[i]
                i = i - 1
            A[i + 1] = key
     */
    public int[] insertSort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];

            int i = j - 1;
            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }

        return array;
    }
}

