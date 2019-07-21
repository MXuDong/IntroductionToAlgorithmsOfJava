package chapter2.part2.merge;

import tests.ArrayUtil;
import tests.TargetMethodParamCreater;
import tests.TestAble;
import tests.UtilTest;

/**
 * Code Name : Test
 * 代码段名称  :
 *
 * @author Dong
 */
public class Test implements TestAble {

    public static void main(String[] args) {
        UtilTest<Test> utilTest = new UtilTest<>();
        utilTest.start(Test.class, "merge", Merge.class);
    }

    @TargetMethodParamCreater
    public Object[] test1(){
        return new Object[]{new int[] {1,2,3,0,1,2}, 0, 2, 5};
    }

    @Override
    public String getParamFormat(Object... objects) {
        return "p = " + ((Object[])(objects[0]))[1]    +
                " q = " + ((Object[])(objects[0]))[2] +
                " r = " + ((Object[])(objects[0]))[3] +
                "\n" + ArrayUtil.outputArray((int[])((Object[])(objects[0]))[0]);
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
