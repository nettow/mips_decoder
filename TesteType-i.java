class Teste {

    public static void main(String[] args) {
        String opCode, immediate;
        int IntegerImmediate, rsNumber, rtNumber;
        String rs = "null";
        String rt = "null";
        String instruction = "andi $s2,$s3,4";
        String binaryResult = "null";

        String[] divInstruction = instruction.split(" ");
        opCode = OpCodeTable.getOpCode(divInstruction[0]);
        // divInstruction[1] = resto (ex: $s0,$s1,4)

        String[] newInstructions = divInstruction[1].split(",");
        // newInstructions[] = [$s2,$s4,4]

        if (opCode == "000011" || opCode == "001010" || opCode == "001100" || opCode == "001101") { // ADDI, SLTI, ANDI, ORI
            rtNumber = RegistersBinaryTable.getRegBinaryValue(newInstructions[0]);
            rt = Integer.toBinaryString(rtNumber);

            rsNumber = RegistersBinaryTable.getRegBinaryValue(newInstructions[1]);
            rs = Integer.toBinaryString(rsNumber);

            IntegerImmediate = Integer.parseInt(newInstructions[2]);
            immediate = completeSixteenBits(IntegerImmediate);

            binaryResult = "opcode: "+ opCode +"\nrt: " + rt + "\nrs:" + rs +"\nimmediate: "+ immediate;
            System.out.println(binaryResult);
        } else if (opCode == "100011" || opCode == "101011") { // LW and SW
            rtNumber = RegistersBinaryTable.getRegBinaryValue(newInstructions[0]);
            rt = Integer.toBinaryString(rtNumber);
            binaryResult = "NADA POR ENQUANTO";
            System.out.println(binaryResult);
        }else if (opCode == "000100" || opCode == "000101"){ // BEQ and BNE

            binaryResult = "NADA POR ENQT";
            System.out.println(binaryResult);
        }

        System.out.println("xd");
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
}
// end of Type I