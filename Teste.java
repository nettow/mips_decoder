import Decoders.*;
public class Teste{

    public static void main(String[] args){
        String result = DecoderTypeR.proccessInstructionTypeR("add $s1,$s2,$s3");
        System.out.println(result);
    }
}