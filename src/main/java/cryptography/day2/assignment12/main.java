package cryptography.day2.assignment12;

import com.sun.xml.internal.messaging.saaj.util.Base64;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import static cryptography.day2.assignment12.global.allBytes;
import static cryptography.day2.assignment12.global.beforePlainText;
import static cryptography.day2.assignment12.global.getGlobalKey;

/**
 * Created by Joost on 30-8-2016.
 */
public class main {

    public static void main(String[] args) throws Exception {
        String encryptedString = AES128ECBEncrypt("Hello worldasdasdasdasdadadsdaa!",getGlobalKey());
        //System.out.println(encryptedString);
        String decryptedString = AES128ECBDecrypt(encryptedString, getGlobalKey());
       // System.out.println(decryptedString);
    }

    private static String AES128ECBEncrypt(String plaintext, SecretKeySpec key) throws Exception{

        ByteOutputStream bs = new ByteOutputStream();
        bs.write(beforePlainText.getBytes());
        bs.write(plaintext.getBytes());

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] output = cipher.doFinal(bs.getBytes());
        return new String(output, "UTF-8");
    }

    private static String AES128ECBDecrypt(String cipherText, SecretKeySpec key) throws Exception{
        //findOutBlockSize(key);
        findOutSecret(key);
        for (int i = 0; i < 100; i++) {
        }
        return "";
    }

    private static void findOutBlockSize(SecretKeySpec key) throws Exception{
        String bytes = "";
        for (int i = 0; i < 100; i++) {
            bytes = bytes + "A";
         //   System.out.println(AES128ECBEncrypt(bytes, key));
        }
    }

    private static void findOutSecret(SecretKeySpec key) throws Exception{
        String initialCipher = "AAAAAAAAAAAAAAA";
        byte[] secret = new byte[16];
        for (int i = 0; i < 16 ; i++) {
            String initialCipherText = AES128ECBEncrypt(initialCipher,key);
            for(byte b: allBytes){
                String cipher = initialCipher + new String(new byte[]{b}, "UTF-8");
                if(initialCipherText.equals(AES128ECBEncrypt(cipher, key))){
                    secret[i] = b;
                }
            }
            initialCipher = initialCipher.substring(1) + new String(new byte[] {secret[i]}, "UTF-8");
        }
    }

}
