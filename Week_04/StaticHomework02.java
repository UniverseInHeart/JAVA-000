import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 * <p>
 * 第2种方式：静态变量
 */
public class StaticHomework02 {
    public static HashMap<String,Integer> map = new HashMap();

    public static void main(String[] args) throws Exception {


        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        new Thread(() -> {
            map.put("result", sum());
            System.out.println(map.get("result"));
        }).start();
        Thread.sleep(100L);
        int result = map.get("result");

        // 确保拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
