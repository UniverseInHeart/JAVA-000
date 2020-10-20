package Week_01;

/**
 * 字节码测试
 */

public class ByteCodeTest {
    public static void main(String[] args) {
        int num1 = 20;
        int num2 = 30;
        int num3 = 60;
        int num4 = 80;

        int numSum = num1 + num2;
        int numSub = num2 - num3;
        int numJi = num1 * num4;
        int numShang = num4 / num2;

        if (numSum > 30) {
            System.out.println(numSum);
            System.out.println(numSub);
            System.out.println(numJi);
            System.out.println(numShang);
            for (int i = 0; i < 10; i++) {
                numSum++;
            }
        }
    }
}