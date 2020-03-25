import decoders.*;
public class Teste{

    public static void main(String[] args){
        System.out.println("\nTYPE I \n");
        System.out.println("addi $t3,$s2,20: " + RegisterDecoder.decode(("addi $t3,$s2,20")));
        System.out.println("lw $t2,10($s1): " + RegisterDecoder.decode(("lw $t2,10($s1)")));
        System.out.println("sw $t2,10($s1): " + RegisterDecoder.decode(("sw $s1,14($t2)")));
        System.out.println("andi $s1,$s2,4: " + RegisterDecoder.decode(("andi $s1,$s2,4")));
        System.out.println();
        System.out.println("TYPE R \n");
        System.out.println("add $s4,$s0,$t3: " + RegisterDecoder.decode(("add $s4,$s0,$t3")));
        System.out.println("sub: $s4,$s0,$t3" + RegisterDecoder.decode(("sub $s4,$s0,$t3")));
        //System.out.println("mult: $s4,$s0" + RegisterDecoder.decode(("sub $s4,$s1")));

        System.out.println();
        System.out.println("TYPE J \n");
    }
}