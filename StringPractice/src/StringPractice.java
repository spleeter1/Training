public class StringPractice {
    public static void main(String[] args) {
        String s1 = "welcome to rikkeisoft";
        System.out.println(s1);

        // StringBuffer - Thread Safe
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        System.out.println("StringBuffer: " + sb);

        // StringBuilder - Nhanh, Không thread-safe
        StringBuilder sb2 = new StringBuilder("Hello");
        sb2.append(" World");
        System.out.println("StringBuilder: " + sb2);

        System.out.println("So sánh String");
        System.out.println("------------------\n");

        s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

        System.out.println("Kết quả bằng equal: "+ s1.equals(s2)); //true
        System.out.println("Kết quả bằng == :" + (s1==s2)); //true
        System.out.println(s1==s3); //false
        //Giải thích: dấu == luôn dùng địa chỉ để so sánh. s1 bằng s2 thực ra là mặc định class String đã được override equal
        // s1 sẽ khác s3 khi s3 là 1 đối tượng mới có địa chỉ khác nên s1 khác s3


        //String buffer chưa được override method equals() nên luôn false do khác địa chỉ
        StringBuffer sbf1 = new StringBuffer("Hello");
        StringBuffer sbf2 = new StringBuffer("Hello");

        System.out.println("StringBuffer so sánh bằng equals(): " + sbf1.equals(sbf2)); //false
        System.out.println("StringBuffer so sánh bằng ==: " + (sbf1 == sbf2)); //false
    }
}