import decoders.*;
public class Teste{

    public static void main(String[] args){
        String result = RegisterDecoder.decode("addi $s1,$s2, 2");
        System.out.println(result);
    }
}