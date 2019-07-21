package chapter2.part1.insert_sort;

import io.github.mxudong.rs.randoms.BaseRandom;
import tests.ArrayUtil;
import tests.TargetMethodParamCreater;
import tests.TestAble;
import tests.UtilTest;

/**
 * Code Name : Test
 * 代码段名称  : 测试
 *
 * @author Dong
 */
public class Test implements TestAble {

    public static void main(String... args) {
        UtilTest<Test> utilTest = new UtilTest<>();
        utilTest.start(Test.class, "insertSort", InsertSort.class);
    }


    @TargetMethodParamCreater
    public int[] test1() {
        return new int[]{4, 5, 1, 2, 3, 7, 9, 6, 8, 4, 1, 2, 3, 4, 5, 6, 7, 8, 7, 6, 5, 4, 4, 3, 2, 1};
    }

    @TargetMethodParamCreater
    public int[] test2() {
        return new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0,
                9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0,
                9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0,
                9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0,
                9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0,
                9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0,};
    }

    @TargetMethodParamCreater(methodInvokeCount = 5)
    public int[] test3() {
        return ArrayUtil.getRandomArray(0, 100000, 1000);
    }

    @TargetMethodParamCreater
    public int[] test4() {
        return ArrayUtil.getRandomArray(0, 100000, BaseRandom.getRandomInt(1000, 10000));
    }

    @TargetMethodParamCreater(methodInvokeCount = 10)
    public int[] test5() {
        return ArrayUtil.getRandomArray(1, 100000, 100000);
    }

    @Override

    public String getParamFormat(Object... objects) {
        int[] params = (int[]) objects[0];
        if (params.length > 100) {
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
