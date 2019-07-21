package tests;

/**
 * 测试接口
 */
public interface TestAble {
    /**
     * 获取格式化的参数
     *
     * @param objects 目标参数
     * @return 格式化后的字符串
     */
    String getParamFormat(Object... objects);

    /**
     * 获取格式化后的结果
     *
     * @param objects 目标结果
     * @return 格式化后的肌肤穿
     */
    String getResultFormat(Object... objects);

    /**
     * 验证结果集是否正确
     *
     * @param objects 结果
     * @return 是否正确
     */
    boolean checkResult(Object... objects);
}
