package cryptography.day2.assignment9;

import java.io.UnsupportedEncodingException;

/**
 * Created by joost on 30-8-2016.
 */
public class main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String input = "YELLOW SUBMARINE";
        String output = new String(createPadding(input.getBytes(), 20), "UTF-8");
    }

    private static byte[] createPadding(byte[] inputBlock, int blockSize) throws UnsupportedEncodingException{
        int paddingSize = blockSize - inputBlock.length;
        byte[] output = new byte[blockSize];
        byte padding = 0x4;
        for (int i = 0; i < blockSize; i++) {
            if(i >= inputBlock.length){
                output[i] = padding;
            }else{
                output[i] = inputBlock[i];
            }
        }
        return output;
    }
}
