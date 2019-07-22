package chapter2.part2.merge_sort;

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
    public static void main(String[] args) {
        UtilTest<Test> utilTest = new UtilTest<>();
        utilTest.start(Test.class, "mergeSort", MergeSort.class);
    }

//    @TargetMethodParamCreater
//    public Object[] test01(){
//        int [] a = new int[]{1,2,3,9,8,7};
//        return new Object[]{a, 0, a.length - 1};
//    }

    @TargetMethodParamCreater(methodInvokeCount = 10)
    public Object[] test02(){
            int [] a =  ArrayUtil.getRandomArray(1, 100, 10000000);
            return new Object[]{a, 0, a.length - 1};

    }

    @Override
    public String getParamFormat(Object... objects) {
        return "p = " + ((Object[]) (objects[0]))[1] +
                " r = " + ((Object[]) (objects[0]))[2] +
                "\n" + ArrayUtil.outputArray((int[]) ((Object[]) (objects[0]))[0]);
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
