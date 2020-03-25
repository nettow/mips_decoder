package decoders;
import tables.*;
public class DecoderTypeI {
    // TYPE I [OpCode, rs, rt, immediate (16 bits)]
    public static String proccessInstructionTypeI(String instruction) {
        String immediate = "";
        String rs = "";
        String rt = "";
        String baseReg = "";
        String binaryResult;
        int integerImmediate, rsDecimal, rtDecimal;

        String opCode = OpCodeTable.getOpCode(instruction.substring(0, instruction.indexOf(" ")));

        String newInstructionsStr = instruction.substring(instruction.indexOf(" "), instruction.length()).replace(" ","");
        String[] newInstructions = newInstructionsStr.split(",");

        if (opCode == "000011" || opCode == "001010" || opCode == "001100" || opCode == "001101") { // ADDI, SLTI, ANDI, ORI
            rtDecimal = RegistersDecimalTable.getRegDecimalValue(newInstructions[0]); // rtDecimal recebe o valor em decimal do registrador em newInstruction[0]
            rt = Integer.toBinaryString(rtDecimal); // rt recebe rtDecimal transformado em binario

            rsDecimal = RegistersDecimalTable.getRegDecimalValue(newInstructions[1]); // rsDecimal recebe o valor em decimal do registrador em newInstruction[1]
            rs = Integer.toBinaryString(rsDecimal); // rrs recebe rsDecimal transformado em binario

            integerImmediate = Integer.parseInt(newInstructions[2]); // // integerImmediate recebe o valor da constante transformado para inteiro
            immediate = RegisterDecoder.completeBits(integerImmediate,16); // completa os bits faltantes pro immediate ter 16 bits

        } else if (opCode == "100011" || opCode == "101011") { // LW and SW
            rtDecimal = RegistersDecimalTable.getRegDecimalValue(newInstructions[0]);
            rt = Integer.toBinaryString(rtDecimal);
            baseReg = newInstructions[1].substring(newInstructions[1].indexOf("("), newInstructions[1].indexOf(")"));
            integerImmediate = rtDecimal + RegistersDecimalTable.getRegDecimalValue(baseReg);
            immediate = RegisterDecoder.completeBits(integerImmediate,16);

        } else if (opCode == "000100" || opCode == "000101") { // BEQ and BNE
            
        }

        binaryResult = opCode + rt + rs + immediate;
        return binaryResult;
    }
}