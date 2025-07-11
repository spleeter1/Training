package org.example;

import java.util.*;

public class CollectionMethod {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("C++");
        list.add("python");
        list.add("java");
        list.add("javascript");

        System.out.println("list added: " + list);

        List<String> list2 = new ArrayList<>(Arrays.asList("C#", "PHP", "java", "Java"));
        list.addAll(list2);

        System.out.println("Add all list2: " + list);

        List<String> list3 = new ArrayList<>(list);
        System.out.println("list3: " + list3);

        list3.clear();
        System.out.println("clear list3: " + list3);

        System.out.println("ktra list: " + list);
        System.out.println("có chứa trong list 1 k: " + list.contains(list2.get(2)));

        list2.add("C++");
        list2.add("python");
        list2.add("java");
        list2.add("javascript");
        boolean same = list.equals(list2);
        System.out.println("So sánh 2 list: " + same);

        Iterator<String> it = list.iterator();
        System.out.println("Danh sách:");
        while (it.hasNext()){
            System.out.println(it.next());
        }

        Object[] arr = list.toArray();
        list.remove(3);
        System.out.println(list);

        System.out.println(Arrays.toString(arr));

        System.out.println("---------------");
        Collections.sort(list);
        System.out.println("List: "+ list);

        int index = Collections.binarySearch(list, "Python");
        System.out.println("Tìm kiếm 'Python': Vị trí = " + index);

        Collections.reverse(list);
        System.out.println("Đảo ngược danh sách: " + list);

        Collections.shuffle(list);
        System.out.println("Trộn ngẫu nhiên: " + list);

        Collections.fill(list, "Học Java");
        System.out.println("Gán giá trị cho toàn bộ: " + list);

        Collections.copy(list2,list);
        System.out.println("List2: "+list2);
    }
}