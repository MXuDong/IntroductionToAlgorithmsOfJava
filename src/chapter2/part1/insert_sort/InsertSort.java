package chapter2.part1.insert_sort;

import tests.ArrayUtil;
import tests.TargetMethodParamCreater;
import tests.TestAble;
import tests.UtilTest;

/**
 * Code name : InsertSort
 * 代码段名称  : 插入排序
 *
 * @author Dong
 */
public class InsertSort implements TestAble {

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

    public static void main(String... args) {
        UtilTest<InsertSort> utilTest = new UtilTest<>();
        utilTest.start(InsertSort.class, "insertSort");
    }

//    @TargetMethodParamCreater
//    public int[] test1() {
//        return new int[]{4, 5, 1, 2, 3, 7, 9, 6, 8, 4, 1, 2, 3, 4, 5, 6, 7, 8, 7, 6, 5, 4, 4, 3, 2, 1};
//    }
//
//    @TargetMethodParamCreater
//    public int[] test2(){
//        return new int[]{9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,
//                9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,
//                9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,
//                9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,
//                9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,
//                9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1,0,};
//    }
//
//    @TargetMethodParamCreater(methodInvokeCount = 5)
//    public int[] test3(){
//        return ArrayUtil.getRandomArray(0, 100000, 1000);
//    }
//
//    @TargetMethodParamCreater
//    public int[] test4(){
//        return ArrayUtil.getRandomArray(0, 100000, BaseRandom.getRandomInt(1000,10000));
//    }

    @TargetMethodParamCreater(methodInvokeCount = 10)
    public int[] test5(){
        return ArrayUtil.getRandomArray(1,100000,100000);
    }

    @Override

    public String getParamFormat(Object... objects) {
        int [] params = (int[]) objects[0];
        if(params.length > 100){
            return "...";
        }
        return ArrayUtil.outputArray((int[]) objects[0]);
    }

    @Override
    public String getResultFormat(Object... objects) {
        return ArrayUtil.outputArray((int[]) objects[0]);
    }

    @Override
    public boolean checkResult(Object... objects) {
        return ArrayUtil.isSort((int[]) objects[0], true);
    }
}

