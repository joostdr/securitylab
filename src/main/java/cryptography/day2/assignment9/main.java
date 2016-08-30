package cryptography.day2.assignment9;

import java.io.UnsupportedEncodingException;

/**
 * Created by joost on 30-8-2016.
 */
public class main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String input = "YELLOW SUBMARINE";
        createPadding(input.getBytes(), 20);
    }

    private static byte[] createPadding(byte[] inputBlock, int blockSize) throws UnsupportedEncodingException{
        int paddingSize = blockSize - inputBlock.length;
        byte[] output = new byte[blockSize];
        byte padding = 0x4;
        int i = 0;
        for(byte b : inputBlock){
            output[i++] = b;
        }
        for (int p = 0; p < paddingSize; p++) {
            output[inputBlock.length + p] = padding;
        }
        System.out.println(new String(output, "UTF-8"));
        return null;
    }

}
