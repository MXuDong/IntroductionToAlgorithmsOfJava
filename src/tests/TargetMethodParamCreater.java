package tests;

import java.lang.annotation.*;

/**
 * 表明该方法生成的数据集是提供测试的数据
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetMethodParamCreater {
    /**
     * 该方法应该被测试的次数
     *
     * @return 测试的次数
     */
    int methodInvokeCount() default 1;
}
