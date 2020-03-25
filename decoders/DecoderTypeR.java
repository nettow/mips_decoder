package decoders;

import tables.*;

public class DecoderTypeR {
    public static String proccessInstructionTypeR(String instruction) {
        String inst = instruction.substring(0, instruction.indexOf(" "));
        String instRegistersStr = instruction.substring(instruction.indexOf(" "), instruction.length()).replace(" ","");
        String[] instRegisters = instRegistersStr.split(",");
        String opCode = "000000";
        String rs, rt, rd, shamt, funct = "";
        String result;

        if (inst.equals("mult") || inst.equals("div")) {

            rt = RegisterBinaryTable.getRegBinaryValue(instRegisters[0]);
            rs = RegisterBinaryTable.getRegBinaryValue(instRegisters[1]);

            rd = "00000";
            shamt = "00000";
            funct = OpCodeTable.getFunct(inst);

        } else {
            rt = RegisterBinaryTable.getRegBinaryValue(instRegisters[2]);
            rs = RegisterBinaryTable.getRegBinaryValue(instRegisters[1]);

            rd = RegisterBinaryTable.getRegBinaryValue(instRegisters[0]);

            shamt = "00000";
            funct = OpCodeTable.getFunct(inst);

        }
        result = opCode + rs + rt + rd + shamt + funct;
        return result;
    }
}