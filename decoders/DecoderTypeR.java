package decoders;

import tables.*;

public class DecoderTypeR {
    public static Objeto proccessInstructionTypeR(String instruction) {
        String inst = instruction.substring(0, instruction.indexOf(" "));
        String instRegistersStr = instruction.substring(instruction.indexOf(" "), instruction.length()).replace(" ","");
        String[] instRegisters = instRegistersStr.split(",");
        String opCode = "000000";
        String rs, rt, rd, shamt, funct = "";

        if (inst.equals("jr")){
            rs = RegisterBinaryTable.getRegBinaryValue(instRegistersStr);
            rt = "00000";
            rd = "00000";
            shamt = "00000";
            funct = OpCodeTable.getFunct(inst);
        } else if (inst.equals("mult") || inst.equals("div")) {

            rs = RegisterBinaryTable.getRegBinaryValue(instRegisters[0]);
            rt = RegisterBinaryTable.getRegBinaryValue(instRegisters[1]);

            rd = "00000";
            shamt = "00000";
            funct = OpCodeTable.getFunct(inst);

        } else if (inst.equals("sll") || (inst.equals("srl"))){
            rs = "00000";
            rt = RegisterBinaryTable.getRegBinaryValue(instRegisters[1]);
            rd = RegisterBinaryTable.getRegBinaryValue(instRegisters[0]);
            shamt = RegisterDecoder.completeBits(Integer.parseInt(instRegisters[2]), 5);
            funct = OpCodeTable.getFunct(inst);
        } else{
            rt = RegisterBinaryTable.getRegBinaryValue(instRegisters[2]);
            rs = RegisterBinaryTable.getRegBinaryValue(instRegisters[1]);

            rd = RegisterBinaryTable.getRegBinaryValue(instRegisters[0]);

            shamt = "00000";
            funct = OpCodeTable.getFunct(inst);

        }
        String hexaValue = Integer.toHexString(soma(rs,rt));
        Objeto resultado = new Objeto((opCode + rs + rt + rd + shamt + funct), hexaValue, Integer.parseInt(rd,2));
        
        return resultado;

    }

    public static int soma(String rs,String rt){
        int rsInteger = Integer.parseInt(rs,2);
        int rtInteger = Integer.parseInt(rt,2);
        int resultado = rsInteger + rtInteger;

        return resultado;
    }
}