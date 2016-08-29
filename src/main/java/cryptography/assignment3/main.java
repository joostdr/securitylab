package cryptography.assignment3;

/**
 * Created by joost on 29-8-2016.
 */
public class main {
    byte[] bytes = Hex.decodeHex(hexString.toCharArray());
    System.out.println(new String(bytes, "UTF-8"));
}
