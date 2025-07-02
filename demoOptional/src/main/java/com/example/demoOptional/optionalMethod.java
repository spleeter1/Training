package com.example.demoOptional;

import java.util.Optional;

public class optionalMethod {
    public static void main(String[] args) {
        Optional<String> opt1 = Optional.of("Hello");
        System.out.println(opt1);  // Optional[Hello]


        Optional<String> opt2 = Optional.empty();
        System.out.println(opt2);  // Optional.empty

        Optional<String> opt3 = Optional.of("World");
        Optional<String> opt4 = Optional.ofNullable(null);
        System.out.println(opt3);  // Optional[World]
        System.out.println(opt4);  // Optional.empty


        if (opt1.isPresent()) {
            System.out.println("opt1 có giá trị: " + opt1.get());
        }

        if (opt2.isEmpty()) {
            System.out.println("opt2 không có giá trị");
        }

        String value1 = opt1.get();  // OK
        System.out.println(value1);
        // String value2 = opt2.get();  // Lỗi vì k có giá trị

        // Có giá trị thì thực hiện hành động
        opt1.ifPresentOrElse(v -> System.out.println("opt1 chứa: " + v),() -> System.out.println("Không có giá trị"));

        //chống lỗi
        opt2.ifPresentOrElse(
                v -> System.out.println("Có giá trị: " + v),
                () -> System.out.println("Không có giá trị")
        );

        // Có giá trị thì lấy, không có thì dùng giá trị mặc định
        String name1 = opt1.orElse("Mặc định 1");
        String name2 = opt2.orElse("Mặc định 2");
        System.out.println(name1);  // Hello
        System.out.println(name2);  // Mặc định 2

        // Có giá trị thì lấy, không có thì tính toán giá trị mặc định
        String result = opt2.orElseGet(() -> generateDefault());
        System.out.println(result);

        // Không có giá trị thì ném ra NoSuchElementException
        try {
            String val = opt2.orElseThrow();
        } catch (Exception e) {
            System.out.println("Bắt được lỗi: " + e);
        }

        // Không có giá trị thì ném ra lỗi do mình tự định nghĩa
        try {
            String val = opt2.orElseThrow(() -> new RuntimeException("Không tìm thấy giá trị"));
        } catch (Exception e) {
            System.out.println("Lỗi tự định nghĩa: " + e.getMessage());
        }

        // Biến đổi giá trị nếu có
        Optional<String> upper = opt1.map(String::toUpperCase);
        System.out.println(upper);  // Optional[HELLO]

        Optional<String> filtered = opt1.filter(v -> v.length() > 3);
        System.out.println(filtered);  // Optional[Hello]

        Optional<String> filtered2 = opt1.filter(v -> v.length() > 10);
        System.out.println(filtered2);  // Optional.empty

    }

    private static String generateDefault() {
        System.out.println("Tính toán giá trị mặc định...");
        return "Giá trị mặc định từ hàm";
    }
}
