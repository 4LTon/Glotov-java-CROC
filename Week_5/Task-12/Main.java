public class Main {
    private static String hash;
    private static int numberOfThreads;
    public static volatile String pass;
    public static volatile boolean isPass = false;

    public static void main(String[] args) {
        numberOfThreads = Integer.parseInt(args[0]);
        hash = args[1];    // 40682260CC011947FC2D0B1A927138C5 - passwrd

        System.out.println(getDecodeHash(hash));
    }

    public static String getDecodeHash(String hash) {
        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(new RunDecode(hash, i, numberOfThreads));
            threads[i].start();
        }

        try {
            for (int i = 0; i < numberOfThreads; i++) threads[i].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Password: " + pass;
    }
}
