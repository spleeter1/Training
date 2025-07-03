package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LamdaPractice {
    public static void main(String[] args) {

        Runnable r = () -> System.out.println("Hello Lambda!");
        r.run();

        List<String> names = Arrays.asList("Nam", "Hoa", "Bình");
        names.forEach(s -> System.out.println("Xin chào " + s));

        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("Số 4 chẵn? " + isEven.test(4));

        // Tính chiều dài chuỗi
        Function<String, Integer> strLength = s -> s.length();
        System.out.println("Độ dài 'Lambda': " + strLength.apply("Lambda"));

        //
        Supplier<Double> random = () -> Math.random();
        System.out.println("Số ngẫu nhiên: " + random.get());

        // Stream - Lọc số > 3 và tính tổng
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .filter(n -> n > 3)
                .mapToInt(n -> n)
                .sum();
        System.out.println("Tổng số > 3: " + sum);

        //  BiFunction
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("Tổng 5 + 3: " + add.apply(5, 3));

        // forEach với Method Reference
        names.forEach(System.out::println);

        // filter và map kết hợp
        List<String> upperNames = names.stream()
                .filter(name -> name.length() > 3)
                .map(String::toUpperCase)
                .toList();
        System.out.println("Tên dài in hoa: " + upperNames);

        // Reduce - Tính tích các số
        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("Tích các số: " + product);

    }
}