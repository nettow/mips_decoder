package decoders;
import tables.*;
public class DecoderTypeI {
    // TYPE I [OpCode, rs, rt, immediate (16 bits)]
    public static String proccessInstructionTypeI(String instruction) {
        String immediate = "";
        String rs = "";
        String rt = "";
        String binaryResult;

        String opCode = OpCodeTable.getOpCode(instruction.substring(0, instruction.indexOf(" ")));

        String divInstruction = instruction.substring(instruction.indexOf(" "), instruction.length()).replace(" ", "");
        String[] dividedInstruction = divInstruction.split(",");

        if (opCode == "100011" || opCode == "101011") { // LW and SW
            rt = RegisterBinaryTable.getRegBinaryValue(dividedInstruction[0]);

            rs = dividedInstruction[1].substring(dividedInstruction[1].indexOf("$"),dividedInstruction[1].indexOf(")")); // Retira os parenteses
            rs = RegisterBinaryTable.getRegBinaryValue(rs);

            immediate = divInstruction.substring(divInstruction.indexOf(",") + 1,divInstruction.indexOf("(")); // Pega a constante
            immediate = RegisterDecoder.completeBits(Integer.parseInt(immediate), 16);

        }else{
            rt = RegisterBinaryTable.getRegBinaryValue(dividedInstruction[0]);
            rs = RegisterBinaryTable.getRegBinaryValue(dividedInstruction[1]);

            immediate = RegisterDecoder.completeBits(Integer.parseInt(dividedInstruction[2]), 16);
        }
        binaryResult = opCode + rs + rt + immediate;
        return binaryResult;
    }
}