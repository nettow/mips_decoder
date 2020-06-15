package tables;

public class RegisterBinaryTable{
    public static String getRegBinaryValue(String register){

        switch(register){
            case "$zero": return "00000";
            case "$at": return "00001";
            case "$v0": return "00010";
            case "$v1": return "00011";
            case "$a0": return "00100";
            case "$a1": return "00101";
            case "$a2": return "00110";
            case "$a3": return "00111";
            case "$t0": return "01000";
            case "$t1": return "01001";
            case "$t2": return "01010";
            case "$t3": return "01011";
            case "$t4": return "01100";
            case "$t5": return "01101";
            case "$t6": return "01110";
            case "$t7": return "01111";
            case "$s0": return "10000";
            case "$s1": return "10001";
            case "$s2": return "10010";
            case "$s3": return "10011";
            case "$s4": return "10100";
            case "$s5": return "10101";
            case "$s6": return "10110";
            case "$s7": return "10111";
            case "$t8": return "11000";
            case "$t9": return "11001";
            case "$k0": return "11010";
            case "$k1": return "11011";
            case "$gp": return "11100";
            case "$sp": return "11101";
            case "$fp": return "11110";
            case "$ra": return "11111";   
        }

        return "erro";
    }
}