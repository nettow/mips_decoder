package tables;

public class OpCodeTable{
    public static String getOpCode(String inst){

        switch(inst){
            //type J
            case "j": return "000010";
            case "jal": return "000011";
            //type I
            case "addi": return "000011";
            case "lw": return "100011"; // R[rt] = M[R[rs]+SignExtImm] 
            case "sw": return "101011"; // M[R[rs]+SignExtImm] = R[rt]
            case "beq": return "000100"; // if(R[rs]==R[rt]) -> PC=PC+4+BranchAddr
            case "bne": return "000101"; // if(R[rs]!=R[rt]) -> PC=PC+4+BranchAddr
            case "slti": return "001010";
            case "andi": return "001100"; 
            case "ori": return "001101"; 
        }

        return null;
    }

    public static String getFunct(String inst){

        switch(inst){
            case "add": return "100000";
            case "sub": return "100010";
            case "mult": return "011000";                
            case "div": return "011010";                
            case "xor": return "100110";                
            case "nor": return "100111";                
            case "slt": return "101010";                
            case "and": return "100100";
            case "sll": return "000000";
            case "srl": return "000010";
            case "jr": return "001000";
            case "or": return "100101";
            //case "neg": return ""
        }

        return null;
    }
}