public class TestEfficiency {
    public static void main(String[] args) {
        long startTime, endTime;

        // String
        startTime = System.nanoTime();
        String s = "";
        for (int i = 0; i < 10000; i++) {
            s += "a";
        }
        endTime = System.nanoTime();
        System.out.println("String time: " + (endTime - startTime) + " ns");

        // StringBuffer
        startTime = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            sb.append("a");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ns");

        // StringBuilder
        startTime = System.nanoTime();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb2.append("a");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ns");
    }
}
