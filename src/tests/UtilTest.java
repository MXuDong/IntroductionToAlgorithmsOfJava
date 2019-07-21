package tests;

import io.github.mxudong.rs.Reflector;
import io.github.mxudong.rs.packings.methods.CommonMethod;
import io.github.mxudong.rs.packings.methods.Invoker;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试工具
 *
 * @author Dong
 */
public class UtilTest<T extends TestAble> {

    /**
     * 需要测试数据集的方法
     */
    private List<CommonMethod> targetParamInvokers;

    /**
     * 被测试的目标方法
     */
    private List<CommonMethod> targetMethods;


    private long startTime;
    private long stopTime;

    /**
     * 执行方法
     *
     * @param tClass           目标类
     * @param targetMethodName 目标方法名
     */
    public void start(Class<T> tClass, String targetMethodName) {

        System.out.println("测试开始");
        System.out.println("开始构建测试");

        this.startTime = TimeUtil.getCurrentTime();

        int testCount;
        double[] testTime;
        int faildTestCount;
        int successTestCount;
        int invokeFaildCount;
        int minTimeTestIndex;
        int maxTimeTestIndex;
        int totalTestCount;
        targetParamInvokers = new ArrayList<>();
        targetMethods = new ArrayList<>();

        Reflector<TestAble> reflector = new Reflector(tClass);
        Invoker[] methods = reflector.getClassObject().getMethods();

        for (Invoker invoker : methods) {
            if (invoker.getMethodName().equals(targetMethodName)) {
                targetMethods.add((CommonMethod) invoker);
                continue;
            }

            CommonMethod commonMethod = (CommonMethod) invoker;
            if (commonMethod.getAnnotation(TargetMethodParamCreater.class) != null) {
                targetParamInvokers.add(commonMethod);
            }
        }

        testCount = targetParamInvokers.size();
        testTime = new double[testCount];
        faildTestCount = 0;
        successTestCount = 0;
        minTimeTestIndex = 0;
        maxTimeTestIndex = 0;
        invokeFaildCount = 0;
        totalTestCount = 0;

        long buildEndTime = TimeUtil.getCurrentTime();

        System.out.println("测试构建完成");
        System.out.println("共查询到被测试方法" + targetMethods.size() + "个,测试量共" + targetParamInvokers.size() + "个");
        System.out.println("测试构建用时：" + (buildEndTime - startTime) + "ms");
        System.out.println("开始执行测试");

        long startTestTime = TimeUtil.getCurrentTime();


        for (int i = 0; i < testCount; i++) {
            System.out.println("===================================================");
            System.out.println("现在执行第" + (i + 1) + "个测试（共" + testCount + "个）");
            CommonMethod commonMethod = targetParamInvokers.get(i);
            int innerTestCount = (int) commonMethod.getAnnotation(TargetMethodParamCreater.class).getInfo("methodInvokeCount");
            long[] innerTestTimes = new long[innerTestCount];
            int innerMinIndex = 0;
            int innerMaxIndex = 0;
            for (int j = 0; j < innerTestCount; j++) {
                System.out.println("\t===============================================");
                System.out.println("\t现在执行第" + (i + 1) + "个测试的第" + (j + 1) + "遍测试（共" + innerTestCount + "遍）");
                System.out.println("\t目标输入参数：");
                totalTestCount++;

                Object params = commonMethod.invoke(reflector.getInnerObject());
                String paramString = reflector.getInnerObject().getParamFormat(params);
                paramString = paramString.replaceAll("\\n", "\n\t");
                System.out.println("\t" + paramString);


                Object result = null;
                for (Invoker invoker : targetMethods) {
                    if (invoker.isParamsIsThisMethod(params)) {
                        long innerStartTime = TimeUtil.getCurrentTime();
                        result = invoker.invoke(reflector.getInnerObject(), params);
                        long innerStopTime = TimeUtil.getCurrentTime();
                        innerTestTimes[j] = innerStopTime - innerStartTime;
                        break;
                    }
                }

                if (result == null) {
                    innerTestTimes[j] = -1;
                    invokeFaildCount++;
                    System.out.println("\t测试调用失败：第" + (i + 1) + "个测试的第" + (j + 1) + "遍");
                } else {
                    String resultString = reflector.getInnerObject().getResultFormat(result);
                    resultString = resultString.replaceAll("\\n", "\n\t");
                    if (reflector.getInnerObject().checkResult(result)) {
                        successTestCount++;
                        System.out.println("\t本次测试用时：" + innerTestTimes[j] + "ms");
                        System.out.println("\t测试结果:");
                        System.out.println(resultString);
                        if (innerTestTimes[j] > innerTestTimes[innerMaxIndex]) {
                            innerMaxIndex = j;
                        }
                        if (innerTestTimes[j] < innerTestTimes[innerMinIndex]) {
                            innerMinIndex = j;
                        }
                    } else {
                        faildTestCount++;
                        System.out.println("\t本次测试失败");
                        System.out.println("\t测试结果");
                        System.out.println("\t" + resultString);
                    }
                }

                System.out.println("本次测试结果：");
                System.out.println("\t=最少测试时间：" + innerTestTimes[innerMinIndex]);
                System.out.println("\t=最多测试时间：" + innerTestTimes[innerMaxIndex]);
                double avg = 0;
                int count = 0;
                for (long innerTime : innerTestTimes) {
                    if (innerTime != -1) {
                        avg += innerTime;
                        count++;
                    }

                }
                avg = count == -1 ? -1 : avg / (count);
                testTime[i] = avg;
                System.out.println("\t=平均测试时间：");

                if (avg > testTime[maxTimeTestIndex]) {
                    maxTimeTestIndex = i;
                }

                if (avg < testTime[minTimeTestIndex] && avg != -1) {
                    minTimeTestIndex = i;
                }
            }
        }

        double avg = 0;
        int count = 0;
        for (double time : testTime) {

            if (avg != -1) {
                count++;
                avg += time;
            }
        }
        avg = count == 0 ? -1 : avg / count;
        System.out.println("最小耗时" + testTime[minTimeTestIndex] + "ms");
        System.out.println("最大耗时" + testTime[maxTimeTestIndex] + "ms");
        System.out.println("平均耗时" + avg + "ms");
        System.out.println("测试总数" + totalTestCount);
        System.out.println("测试成功数" + successTestCount + "; 测试成功率" + (totalTestCount == 0 ? 0 :successTestCount / totalTestCount));
        System.out.println("测试失败数" + faildTestCount + "; 测试失败率" + (totalTestCount == 0 ? 0 : faildTestCount / totalTestCount));
        System.out.println("测试异常数" + invokeFaildCount + "; 测试异常率" + (totalTestCount == 0 ? 0 : invokeFaildCount / totalTestCount));

        this.stopTime = TimeUtil.getCurrentTime();
        System.out.println("执行测试结束");
        System.out.println("测试总耗时：" + (stopTime - startTime) + "ms");

    }


    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStopTime() {
        return stopTime;
    }

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }
}
