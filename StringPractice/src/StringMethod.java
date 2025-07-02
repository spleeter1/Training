public class StringMethod {
    public static void main(String[] args) {

        String s = " Hello World ";

        System.out.println(s.trim());                     //  "Hello World"
        System.out.println(s.toLowerCase());              // " hello world "
        System.out.println(s.toUpperCase());              // " HELLO WORLD "
        System.out.println(s.contains("World"));          // true
        System.out.println(s.startsWith(" H"));           // true
        System.out.println(s.endsWith(" "));              // true
        System.out.println(s.indexOf("o"));               // 5
        System.out.println(s.lastIndexOf("o"));           // 8

        String[] parts = s.trim().split(" ");
        System.out.println(parts[0]);                     // "Hello"
        System.out.println(parts[1]);                     // "World"

        System.out.println("abc123".replaceAll("\\d", "*")); // "abc***"

        String a = "abc";
        String b = "ABC";

        System.out.println(a.equals(b));                  // false
        System.out.println(a.equalsIgnoreCase(b));        // true

        System.out.println("--------------");
        System.out.println("Method của StringBuilder");
        StringBuilder sb = new StringBuilder();

        sb.append("Hello");                   //  "Hello"
        System.out.println(sb);

        sb.insert(2, "abc");                  // "Heabcllo"
        System.out.println(sb);

        sb.delete(0, 3);                      // Xóa từ vị trí 0 đến 2 → "bcllo"
        System.out.println(sb);

        sb.replace(0, 3, "xyz");              // Thay đoạn 0-2 bằng "xyz" → "xyzlo"
        System.out.println(sb);

        sb.reverse();                         // Đảo ngược chuỗi → "olzyx"
        System.out.println(sb);

        String result = sb.toString();        // Chuyển về String
        System.out.println("Chuỗi kết quả: " + result);

        System.out.println("Độ dài: " + sb.length()); // Lấy độ dài

        char c = sb.charAt(0);                // Lấy ký tự đầu tiên
        System.out.println("Ký tự đầu tiên: " + c);

        sb.setCharAt(1, 'Q');                 // Thay ký tự tại vị trí 1 bằng 'Q'
        System.out.println(sb);
    }
}
