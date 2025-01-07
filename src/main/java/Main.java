import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

    }

    public static void exam7() {

    }
    public static void exam6() {
        List<Person> people=new ArrayList<>();
        people.add(new Person(1, "Alice", 20, 'F'));
        people.add(new Person(2, "Bob", 25, 'M'));
        people.add(new Person(3, "David", 35, 'M'));

        // 남자 나이 합
        int sum = people.stream()
                .filter(p -> p.getGender() == 'M')
                .mapToInt(p -> p.getAge())
                .sum();
        System.out.println(sum);

        // 남자 나이 평균
        double avg = people.stream()
                .filter(p -> p.getGender() == 'M')
                .mapToInt(p -> p.getAge())
                .average()
                .orElse(0);
        System.out.println(avg);

        // 남자 이름 출력
        people.stream()
                .filter(p->p.getGender()=='M')
                .map(p->p.getName())
                .forEach(System.out::println);
    }


    public static void exam5() {
        int[] arr = {1, 2, 3, 4, 5}; // -> 1번,2번...

        String[] strNums=Arrays.stream(arr).mapToObj(n->n+"번").toArray(String[]::new);

        Arrays.stream(strNums).forEach(System.out::println);
    }

    public static void exam4() {
        String[] strNums = {"1번", "2번", "3번", "4번", "5번"};

        int[] arr = Arrays.stream(strNums)
                .map(str -> str.substring(0, 1))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 1)
                .toArray();

        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void exam3() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("=== 명령형 === ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 2;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("=== 스트림 ===");
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // 값 2배 배열
        int[] arr2 = Arrays.stream(arr1)
                .map(n -> 2 * n).toArray();

        Arrays.stream(arr2).forEach(System.out::println);

        // 값 3배 배열
        int[] arr3 = Arrays.stream(arr1)
                .map(n -> 3 * n).toArray();
        Arrays.stream(arr3).forEach(System.out::println);

        // 값 10배 배열
        int[] arr4 = Arrays.stream(arr1)
                .map(n -> 10 * n).toArray();
        Arrays.stream(arr4).forEach(System.out::println);
    }

    public static void exam2() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // 1~10까지 수중에서 짝수만 따로 뽑아서 짝수 배열

        System.out.println("=== 명령형 ===");
        int[] eveArr = new int[arr.length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                eveArr[idx++] = arr[i];
            }
        }

        for (int i = 0; i < idx; i++) {
            System.out.println(eveArr[i]);
        }

        System.out.println("=== 스트림 ===");
        int[] arr2 = IntStream.rangeClosed(1, 10)
                .filter(Main::even)
                .toArray();

        System.out.println(arr2.length);
    }

    public static void exam1() {
        // 1부터 100까 만들고 짝수만 출력 - 스트림 이용

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("=== 명령형 ===");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("=== 스트림 ===");
        Arrays.stream(arr)
                .forEach(Main::test); // forEach 안에는 만들어져있는 명령 ==> 메서드 레퍼런스

        System.out.println("=== 스트림: 짝수 출력 ===");
        // 숫자 스트림을 바로 만들 수 있음.
        IntStream.rangeClosed(1, 100)
                .forEach((num) -> {
                    if (num % 2 == 0) {
                        System.out.println(num);
                    }
                });


        // 람다 -> 익명함수
        // 기본은 람다를 쓰되,
        // 람다 안에서 사용하는게 재사용성이 높거나, 가독성이 떨어지는 복잡한 코드다 => 함수 정의
    }

    public static void test(int num) {
        System.out.println("숫자 :" + num);

    }

    public static boolean even(int num) {
        if (num % 2 == 0) return true;

        return false;
    }

}

class Person {
    private int id;
    private String name;
    private int age;
    private char gender;

    public Person(int id, String name, int age, char gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }
}
