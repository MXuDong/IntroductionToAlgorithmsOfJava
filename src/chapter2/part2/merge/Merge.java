package chapter2.part2.merge;

/**
 * Code Name : Merge
 * 代码段名称  : 合并（分治)
 *
 * @author Dong
 */
public class Merge {

    /*伪代码
    MERGE(A, p, q, r)
        n1 = q - p + 1
        n2 = r - q
        let L[1..n1 + 1] and R[1..n2 + 1] be new arrays
        for i = 1 to n1
            L[i] = A[p + i - 1]
        for j = 1 to n2
            R[j] = A[q + j]
        L[n1 + 1] = ∞
        R[n2 + 1] = ∞
        i = 1
        j = 1
        for k = p to r
            if L[i] ≤ R[j]
                A[k] = L[i]
                i = i + 1
            else A[k] = R[j]
                j = j + 1
      */

    public int[] merge(int[] array, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            left[i] = array[i + p];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = array[q + j + 1];
        }

        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for(int k = p; k <= r; k++){
            if(left[i] <= right[j]){
                array[k] = left[i];
                i++;
            }else {
                array[k] = right[j];
                j++;
            }
        }
        return array;
    }
}
