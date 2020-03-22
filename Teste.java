import decoders.*;
public class Teste{

    public static void main(String[] args){
        String result = DecoderTypeI.proccessInstructionTypeI("addi $s1, $s2, 2");
        System.out.println(result);
    }
}