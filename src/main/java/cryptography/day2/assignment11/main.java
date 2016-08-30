package cryptography.day2.assignment11;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Random;

/**
 * Created by joost on 30-8-2016.
 */
public class main {

    static SecretKeySpec key;
    static int random;
    static int randomByteCount;

    static {
        random = new Random().nextInt(2) + 1;
        randomByteCount = new Random().nextInt(10) + 5;
    }

    public static void main(String[] args) throws Exception {
        generateRandomAES();
        System.out.println(encryption_oracle("Hello world"));
    }

    private static void generateRandomAES() throws Exception{
        byte[] aes = new byte[16];
        new Random().nextBytes(aes);
        key = new SecretKeySpec(aes, "AES");
    }

    private static String encryption_oracle(String input) throws Exception{
        input = appendBytesToPlainText(input);
        String jibberish = "";
        switch(random){
            case 1: jibberish = encryptWithCBC(input);
                break;
            case 2: jibberish = encryptWithECB(input);
                break;
        }
        return jibberish;
    }

    private static String encryptWithCBC(String plaintext) throws Exception{
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] output = cipher.doFinal(plaintext.getBytes());
        System.out.println("CBC");
        return new String(output, "UTF-8");
    }

    private static String encryptWithECB(String plaintext) throws Exception{
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] output = cipher.doFinal(plaintext.getBytes());
        System.out.println("ECB");
        return new String(output, "UTF-8");
    }

    /**
     *
     * @param plaintext
     * Create a new byte arrays with 5 - 10 random bytes called before and after
     * Fill before and after byte arrays with random bytes
     * Concatenate before, plaintext an after and write return this byte array
     * @return output
     */
    private static String appendBytesToPlainText(String plaintext) throws Exception{
        byte[] before = new byte[randomByteCount];
        byte[] input = plaintext.getBytes();
        byte[] after = new byte[randomByteCount];

        new Random().nextBytes(before);
        new Random().nextBytes(after);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(before);
        outputStream.write(input);
        outputStream.write(after);
        return new String(outputStream.toByteArray(),"UTF-8");
    }

}
