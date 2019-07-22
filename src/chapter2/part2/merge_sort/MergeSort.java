package chapter2.part2.merge_sort;

import chapter2.part2.merge.Merge;
import tests.ArrayUtil;

/**
 * Code Name : MergeSort
 * 代码段名称  : 归并排序
 *
 * @author Dong
 */
public class MergeSort {

    /*伪代码
    MERGE-SORT(A, p, r)
        if p < r
            q = [(p + r) / 2]
            MERGE-SORT(A, p, q)
            MERGE-SORT(A, q + 1, r)
            MERGE(A, p, q, r)

     */
    Merge merge = new Merge();

    public int[] mergeSort(int[] array, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(array, p, q);
            mergeSort(array, q + 1, r);

            merge.merge(array, p, q, r);
        }
        return array;
    }
}
