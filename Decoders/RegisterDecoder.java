package Decoders;
public class RegisterDecoder {

    public static String decode(String instruction) {
        String result = "";
        char type = defineRegType(instruction.substring(0, instruction.indexOf(" ")));

        switch (type) {
            case 'r':
                result = DecoderTypeR.proccessInstructionTypeR(instruction);
                break;
            case 'i':
                result = DecoderTypeI.proccessInstructionTypeI(instruction);
                break;
            case 'j':
                result = DecoderTypeJ.proccessInstructionTypeJ(instruction);
                break;
        }

        return result;
    }

    public static String completeSixteenBits(int binaryNumber) {
        String value = Integer.toBinaryString(binaryNumber);
        int valueLength = value.length();

        while (valueLength < 16) {
            value = "0" + value;
            valueLength++;
        }
        return value;
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
            // type J
            case "j":
            case "jal":
                result = 'j';
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
        }

        return result;
    }
}