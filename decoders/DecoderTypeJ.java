package decoders;
import tables.*;
public class DecoderTypeJ{
    public static String proccessInstructionTypeJ(String instruction) {
        String opCode;
        String address = "";

        String binaryResult;

        String[] divInstruction = instruction.split(" ");
        opCode = OpCodeTable.getOpCode(divInstruction[0]);

        binaryResult = opCode + address;
        return binaryResult;
    }
}