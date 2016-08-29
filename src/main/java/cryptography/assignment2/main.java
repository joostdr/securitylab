package cryptography.assignment2;

import javax.xml.bind.DatatypeConverter;
import java.util.Base64;

/**
 * Created by joost on 29-8-2016.
 */
public class main {

    public static void main(String[] args) {
        byte[] decodeString1 = DatatypeConverter.parseHexBinary("1c0111001f010100061a024b53535009181c");
        byte[] decodeString2 = DatatypeConverter.parseHexBinary("686974207468652062756c6c277320657965");

        byte[] finalArray = new byte[decodeString1.length];
        int i = 0;
        for(byte b : decodeString1){
            finalArray[i] = b ^ decodeString2[i];
        }

        System.out.println(decodeString1);
        System.out.println(decodeString2);


    }

}
