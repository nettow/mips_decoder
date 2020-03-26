package decoders;
import tables.*;
public class DecoderTypeJ{
    public static String proccessInstructionTypeJ(String instruction) {
        String[] dividedInstruction = instruction.split(" ");

        String opCode = OpCodeTable.getOpCode(dividedInstruction[0]);
        String address = RegisterDecoder.completeBits(Integer.parseInt(dividedInstruction[1]), 25);

        return opCode + address;
    }
}