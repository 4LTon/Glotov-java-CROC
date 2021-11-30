import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RunDecode implements Runnable{

    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private final String hash;
    private final int numberOfChars = 7;    // количество символов в пароле
    private final long start;
    private final long end;

    public RunDecode(String hash, int threadIndex, int countThreads) {
        this.hash = hash;

        long numberOfCombinations = (long) Math.pow(26, numberOfChars); // количество возможных комбинаций
        start = (numberOfCombinations * threadIndex) / countThreads;
        end = (numberOfCombinations * (threadIndex + 1)) / (countThreads - 1);
    }

    private static String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
            hex.append(HEX_DIGITS[b & 0x0f]);
        }
        return hex.toString();
    }

    private static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(password.getBytes());
        byte[] bytes = digest.digest();
        return toHexString(bytes);
    }

    // генератор пароля по индексу
    private StringBuilder passGeneration(long index) {
        int[] passInt = new int[numberOfChars];

        for (int i = 0; i < numberOfChars; i++) {
            passInt[i] = (int) ((index % 26) + 'a');
            index /= 26;
        }

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < numberOfChars; i++) {
            password.append((char) passInt[i]);
        }

        return password;
    }

    @Override
    public void run() {
        for (long i = start; i < end; i++) {
            if (Main.isPass) break;

            String pass = passGeneration(i).toString();

            if (hashPassword(pass).equals(hash)) {
                Main.isPass = true;
                Main.pass = pass;
            }
        }
    }
}