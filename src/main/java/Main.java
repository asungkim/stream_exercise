import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("=== 명령형 ===");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("=== 스트림 ===");
        Arrays.stream(arr).forEach(Main::test);


        System.out.println("== 스트림 : 짝수 출력 ===");
        IntStream.rangeClosed(1,100)
                .forEach(Main::even);

    }

    public static void test(int num) {
        System.out.println("숫자 :" + num);

    }

    public static void even(int num) {
        if (num % 2 == 0) System.out.println(num);
    }
}
