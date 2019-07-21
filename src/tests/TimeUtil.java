package tests;

/**
 * 时间工具箱
 *
 * @author Dong
 */
public class TimeUtil {

    /**
     * 获取当前时间戳
     *
     * @return 当前时间戳
     */
    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    /**
     * 获取时间平均值
     *
     * @param times 时间数组
     * @return 时间平均值
     */
    public static double getTimeAverage(long... times) {
        long sum = 0;
        for (long l : times) {
            sum += l;
        }
        return sum / (double) times.length;
    }
}
