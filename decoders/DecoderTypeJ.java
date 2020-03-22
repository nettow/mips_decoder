package decoders;
import tables.*;
public class DecoderTypeJ{
    public static String proccessInstructionTypeJ(String instruction) {
        String opCode;
        String address = "";
        int integerAddress;
        String binaryResult;

        String[] divInstruction = instruction.split(" ");
        opCode = OpCodeTable.getOpCode(divInstruction[0]);
        if (opCode == "000010" || opCode == "000011"){ // j and jal
            integerAddress = Integer.parseInt(divInstruction[1]);
            address = RegisterDecoder.completeBits(integerAddress,26);
        }
        binaryResult = opCode + address;
        return binaryResult;
    }
}