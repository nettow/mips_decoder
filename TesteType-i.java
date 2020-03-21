class Teste {

    public static void main(String[] args) {
        String opCode, immediate = "";
        int integerImmediate, rsDecimal, rtDecimal;
        String rs = ""; 
        String rt = ""; 
        String baseReg = "";
        String instruction = "lw $s1,4($t1)";
        String binaryResult;


        String[] divInstruction = instruction.split(" ");
        opCode = OpCodeTable.getOpCode(divInstruction[0]);
        // divInstruction[1] = resto (ex: $s0,$s1,4)

        String[] newInstructions = divInstruction[1].split(",");
        // newInstructions[] = [$s2,$s4,4]

        if (opCode == "000011" || opCode == "001010" || opCode == "001100" || opCode == "001101") { // ADDI, SLTI, ANDI, ORI
            rtDecimal = RegistersDecimalTable.getRegDecimalValue(newInstructions[0]);
            rt = Integer.toBinaryString(rtDecimal);

            rsDecimal = RegistersDecimalTable.getRegDecimalValue(newInstructions[1]);
            rs = Integer.toBinaryString(rsDecimal);

            integerImmediate = Integer.parseInt(newInstructions[2]);
            immediate = completeSixteenBits(integerImmediate);

            binaryResult = "opcode: "+ opCode +"\nrt: " + rt + "\nrs:" + rs +"\nimmediate: "+ immediate;
            System.out.println(binaryResult);
        } else if (opCode == "100011" || opCode == "101011") { // LW and SW
            rtDecimal = RegistersDecimalTable.getRegDecimalValue(newInstructions[0]);
            rt = Integer.toBinaryString(rtDecimal);
            baseReg = newInstructions[1].substring(newInstructions[1].indexOf("(") + 1, newInstructions[1].indexOf(")") );
            int baseRegDecimal = RegistersDecimalTable.getRegDecimalValue(baseReg);
            integerImmediate = rtDecimal + baseRegDecimal;
            immediate = completeSixteenBits(integerImmediate);

            binaryResult = opCode + rt + rs + immediate;
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