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
    }
}