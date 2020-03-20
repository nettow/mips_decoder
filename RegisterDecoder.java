public class RegisterDecoder {

    public static String decode(String instruction) {
        String result = "";
        char type = defineRegType(instruction.substring(0, instruction.indexOf(" ")));

        switch (type) {
            case 'r':
                result = proccessInstructionTypeR(instruction);
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

    private static String proccessInstructionTypeR(String instruction) {
        // R -> [OpCode, rs(arg1), rt(arg2), rd(result), shamt, funct]

        String[] inst = instruction.split(" ");
        String[] instRegisters = inst[1].split(",");

        String opCode = "000000";
        int rsInteger, rtInteger, rdInteger;
        String rs, rt, rd, shamt, funct;
        String result;

        if (inst[0].equals("mult") || inst[0].equals("div")){

            rsInteger = RegistersBinaryTable.getRegBinaryValue(instRegisters[0]);
            rs = Integer.toBinaryString(rsInteger);

            rtInteger = RegistersBinaryTable.getRegBinaryValue(instRegisters[1]);
            rt = Integer.toBinaryString(rtInteger);

            rd = "00000";
            shamt = "00000";
            funct = OpCodeTable.getFunct(inst[0]);

        } else{

            rsInteger = RegistersBinaryTable.getRegBinaryValue(instRegisters[1]);
            rs = Integer.toBinaryString(rsInteger);

            rtInteger = RegistersBinaryTable.getRegBinaryValue(instRegisters[2]);
            rt = Integer.toBinaryString(rtInteger);

            rdInteger = RegistersBinaryTable.getRegBinaryValue(instRegisters[0]);
            rd = Integer.toBinaryString(rdInteger);

            shamt = "00000";
            funct = OpCodeTable.getFunct(inst[0]);

        }

        result = opCode + rs + rt + rd + shamt + funct;
        return result;
    }

    // TYPE I [OpCode, rs, rt, immediate (16 bits)]
    private static String proccessInstructionTypeI(String instruction) {
        String opCode, immediate;
        int IntegerImmediate, rsNumber, rtNumber;
        String rs = "null";
        String rt = "null";

        String binaryResult;

        String[] divInstruction = instruction.split(" ");
        opCode = OpCodeTable.getOpCode(divInstruction[0]);
        // divInstruction[1] = resto (ex: $s0,$s1,4)

        String[] newInstructions = divInstruction[1].split(",");
        // newInstructions[] = [$s0,$s1,4]

        if (opCode == "000011" || opCode == "001010" || opCode == "001100" || opCode == "001101") { // ADDI, SLTI, ANDI, ORI
            rtNumber = RegistersBinaryTable.getRegBinaryValue(newInstructions[0]);
            rt = Integer.toBinaryString(rtNumber);

            rsNumber = RegistersBinaryTable.getRegBinaryValue(newInstructions[1]);
            rs = Integer.toBinaryString(rsNumber);

            IntegerImmediate = Integer.parseInt(newInstructions[2]);
            immediate = completeSixteenBits(IntegerImmediate);

            binaryResult = opCode + rt + rs + immediate;
            return binaryResult;
        } else if (opCode == "100011" || opCode == "101011") { // LW and SW
            rtNumber = RegistersBinaryTable.getRegBinaryValue(newInstructions[0]);
            rt = Integer.toBinaryString(rtNumber);
            binaryResult = "NADA POR ENQUANTO";
            return binaryResult;
        }else if (opCode == "000100" || opCode == "000101"){ // BEQ and BNE

            binaryResult = "NADA POR ENQT";
            return binaryResult;
        }

        return "error";
    }

    private static String completeSixteenBits(int binaryNumber) {
        String value = Integer.toBinaryString(binaryNumber);
        int valueLength = value.length();

        while (valueLength < 16) {
            value = "0" + value;
            valueLength++;
        }
        return value;
    }

    // end of Type I
    private static void proccessInstructionTypeJ(String instruction) {

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