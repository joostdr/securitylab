package cryptography.day1.assignment5;

import javax.xml.bind.DatatypeConverter;

/**
 * Created by joost on 29-8-2016.
 */
public class main {

    public static void main(String[] args) {

        String plain = "Burning 'em, if you ain't quick and nimble\n" +
                "I go crazy when I hear a cymbal";
        String cipher = "ICE";

        byte[] byteArray = DatatypeConverter.parseHexBinary(plain);

        for(byte b: byteArray){
            System.out.println("asd");
        }
    }

}
