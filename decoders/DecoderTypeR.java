package decoders;

import tables.*;
public class DecoderTypeR {

    public static String proccessInstructionTypeR(String instruction) {
        // R -> [OpCode, rs(arg1), rt(arg2), rd(result), shamt, funct]

        String inst = instruction.substring(0, instruction.indexOf(" "));
        String instRegistersStr = instruction.substring(instruction.indexOf(" "), instruction.length()).replace(" ", "");
        String[] instRegisters = instRegistersStr.split(",");

        String opCode = "000000";
        int rsInteger, rtInteger, rdInteger;
        String rs, rt, rd, shamt, funct = "";
        String result;

        if (inst.equals("mult") || inst.equals("div")) {

            rsInteger = RegistersDecimalTable.getRegDecimalValue(instRegisters[0]);
            rs = Integer.toBinaryString(rsInteger);

            rtInteger = RegistersDecimalTable.getRegDecimalValue(instRegisters[1]);
            rt = Integer.toBinaryString(rtInteger);

            rd = "00000";
            shamt = "00000";
            funct = OpCodeTable.getFunct(inst);

        } else {

            rsInteger = RegistersDecimalTable.getRegDecimalValue(instRegisters[1]);
            rs = Integer.toBinaryString(rsInteger);

            rtInteger = RegistersDecimalTable.getRegDecimalValue(instRegisters[2]);
            rt = Integer.toBinaryString(rtInteger);

            rdInteger = RegistersDecimalTable.getRegDecimalValue(instRegisters[0]);
            rd = Integer.toBinaryString(rdInteger);

            shamt = "00000";
            funct = OpCodeTable.getFunct(inst);

        }

        result = opCode + rs + rt + rd + shamt + funct;
        return result;
    }
}