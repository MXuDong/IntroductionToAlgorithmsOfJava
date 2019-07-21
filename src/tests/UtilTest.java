package tests;

import io.github.mxudong.rs.Reflector;
import io.github.mxudong.rs.packings.methods.Invoker;

/**
 * 测试工具
 *
 * @author Dong
 */
public class UtilTest {

    /**
     * 需要测试数据集的方法
     */
    private Invoker [] targetParamInvokers;

    private long startTime;
    private long stopTime;

    /**
     * 执行方法
     *
     * @param tClass 目标类
     * @param targetMethodName 目标方法名
     */
    public void start(Class tClass, String targetMethodName){

        long startTime = TimeUtil.getCurrentTime();

        Reflector reflector = new Reflector(tClass);
        Invoker[] methods = reflector.getClassObject().getMethods();

    }
}
