package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Nam", "Hoa", "Bình", "An", "Nam", "Linh", "Bình");
        List<Integer> numbers = Arrays.asList(5, 12, 7, 9, 21, 5, 30, 12);

        //  Từ danh sách names:
        //✔️ Lọc ra các tên có độ dài lớn hơn 3 ký tự
        List<String> filtered = names.stream().filter(n -> n.length() > 3).toList();
        System.out.println("Loại bỏ tên >3 kí tự: " + filtered);

        //✔️ Loại bỏ tên trùng lặp
        List<String> filteredSame = new ArrayList<>(new HashSet<String>(names));
        System.out.println("Loại bỏ trùng tên: " + filteredSame);
        //✔️ In ra kết quả

        //
        //        2️⃣ Từ danh sách names:
        //✔️ Chuyển tất cả các tên thành chữ in hoa
        List<String> upperCaseList = names.stream().map(word -> word.toUpperCase()).toList();
        System.out.println("UppercaseList: " + upperCaseList);
        //✔️ Sắp xếp theo thứ tự bảng chữ cái
        List<String> incrList = names.stream().sorted().toList();
        System.out.println("IncrList: " + incrList);
        //✔️ In ra kết quả
//
//        3️⃣ Từ danh sách numbers:
//✔️ Lọc ra các số chẵn
        List<Integer> evenNums = numbers.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("Even: " + evenNums);
//✔️ Tính tổng các số chẵn đó và in ra kết quả
        int sum = evenNums.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Tong = " + sum);
//
//        4️⃣ Từ danh sách numbers:
//✔️ Loại bỏ số trùng lặp
        List<Integer> nums = new ArrayList<>(new HashSet<Integer>(numbers));
        System.out.println("New number array: "+ nums);
//✔️ Sắp xếp giảm dần
        List<Integer> decrNums = numbers.stream().sorted().toList().reversed();
        System.out.println(decrNums);
//✔️ In ra danh sách mới
//
//        5️⃣ Nâng cao với names:

//✔️ Tìm phần tử đầu tiên có độ dài bằng 4 ký tự
//✔️ Nếu tìm thấy in ra, không thì in "Không tìm thấy"
        Optional<String> first4CharName = names.stream()
                .filter(n -> n.length() == 4)
                .findFirst();

        if (first4CharName.isPresent()) {
            System.out.println("Tìm thấy tên 4 ký tự: " + first4CharName.get());
        } else {
            System.out.println("Không tìm thấy");
        }
    }
}
