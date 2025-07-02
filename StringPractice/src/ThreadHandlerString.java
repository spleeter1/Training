public class ThreadHandlerString {
    static StringBuilder builder = new StringBuilder();
    static StringBuffer buffer = new StringBuffer();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                builder.append("a");
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                builder.append("b");
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                buffer.append("a");
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                buffer.append("b");
            }
        });

        long startTime, endTime;

        // Test StringBuilder (Không an toàn đa luồng)
        startTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        endTime = System.currentTimeMillis();

        System.out.println("StringBuilder length: " + builder.length());
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ms");

        // Test StringBuffer (An toàn đa luồng)
        startTime = System.currentTimeMillis();
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        endTime = System.currentTimeMillis();

        System.out.println("StringBuffer length: " + buffer.length());
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ms");
    }
}

//"C:\Program Files\Java\jdk-23\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.3.3\lib\idea_rt.jar=56729:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.3.3\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Users\NAMPC\Documents\Training Rikkeisoft\StringPractice\out\production\StringPractice" ThreadHandlerString
//Exception in thread "Thread-0" java.lang.ArrayIndexOutOfBoundsException: arraycopy: last destination index 1151 out of bounds for byte[1150]
//at java.base/java.lang.System.arraycopy(Native Method)
//at java.base/java.lang.String.getBytes(String.java:4823)
//at java.base/java.lang.AbstractStringBuilder.putStringAt(AbstractStringBuilder.java:1768)
//at java.base/java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:591)
//at java.base/java.lang.StringBuilder.append(StringBuilder.java:179)
//at ThreadHandlerString.lambda$main$0(ThreadHandlerString.java:9)
//at java.base/java.lang.Thread.run(Thread.java:1575)

//StringBuilder length: 100838    -> Lỗi xâu này do 2 luồng t1,t2 truy cập cùng vào 1 địa chỉ
//StringBuilder time: 3 ms
//StringBuffer length: 200000   -> đồng bộ nên t3 và t4 đã cùng hoàn thành thêm vào 10000 kí tự
//StringBuffer time: 30 ms