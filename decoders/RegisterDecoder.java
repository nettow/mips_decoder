package decoders;

public class RegisterDecoder {

    public static String decode(String instruction) {
        String result = "";

        if (instruction.equals("nop")) {
            result = completeBits(0, 32);
        }else{
            switch (defineRegType(instruction.substring(0, instruction.indexOf(" ")))) {
                case 'r':
                    result = DecoderTypeR.proccessInstructionTypeR(instruction);
                    break;
                case 'i':
                    result = DecoderTypeI.proccessInstructionTypeI(instruction);
                    break;
                case 'j':
                    result = DecoderTypeJ.proccessInstructionTypeJ(instruction);
            }
        }
        return result;
    }

    public static String completeBits(int value, int tamanho) {
        String binaryNumber = Integer.toBinaryString(value);
        int numLength = binaryNumber.length();

        while (numLength < tamanho) {
            binaryNumber = "0" + binaryNumber;
            numLength++;
        }
        return binaryNumber;
    }

    private static char defineRegType(String inst) {
        char result = ' ';

        switch (inst) {
            // type R
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
            // type I
            case "addi":
            case "lw":
            case "sw":
            case "beq":
            case "bne":
            case "slti":
            case "andi":
            case "ori":
                result = 'i';
                break;
            // type J
            case "j":
            case "jal":
                result = 'j';
                break;
            // Nop
            case "nop":
                result = 'n';
                break;

        }

        return result;
    }
}