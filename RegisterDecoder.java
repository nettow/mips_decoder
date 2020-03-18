public class RegisterDecoder{

    public static String decode(String instruction){
        String result;
        char type = defineRegType(instruction.substring( 0, instruction.indexOf(" ") ) );
        switch(type){
            case 'r':
                proccessInstructionTypeR(instruction);
                break;
            case 'i':
                proccessInstructionTypeI(instruction);
                break;
            case 'j':
                proccessInstructionTypeJ(instruction);
                break;
        }
        
        return result;
    }

    private static void proccessInstructionTypeR(String instruction){
        // R -> [OpCode, rs(arg1), rt(arg2), rd(result), shamt, funct]

        String opCode = "000000";


    }

    private static void proccessInstructionTypeI(String instruction){

    }

    private static void proccessInstructionTypeJ(String instruction){

    }

    private static char defineRegType(String inst){
        char result = ' ';

        switch(inst){
            //type R
            case "add":
            case "sub":
            case "mult":
            case "div":
            case "xor":
            case "nor":
            case "slt":
            case "and":
            case "sll":
            case "srl":
            case "jr":
            case "or":
            case "neg": 
                result = 'r';
                break;
            //type J
            case "j":
            case "jal":
                result = 'j';
                break;
            //type I
            case "addi": 
            case "lw": 
            case "sw": 
            case "beq": 
            case "bne": 
            case "slti": 
            case "andi": 
            case "ori": result = 'i';
        }

        return result;
    }
}