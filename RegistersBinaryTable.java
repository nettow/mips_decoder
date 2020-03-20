public class RegistersBinaryTable{
    public static int getRegBinaryValue(String register){

        switch(register){
            case "$zero": return 0;
            case "$at": return 1;
            case "$v0": return 2;
            case "$v1": return 3;
            case "$a0": return 4;
            case "$a1": return 5;
            case "$a2": return 6;
            case "$a3": return 7;
            case "$t0": return 8;
            case "$t1": return 9;
            case "$t2": return 10;
            case "$t3": return 11;
            case "$t4": return 12;
            case "$t5": return 13;
            case "$t6": return 14;
            case "$t7": return 15;
            case "$s0": return 16;
            case "$s1": return 17;
            case "$s2": return 18;
            case "$s3": return 19;
            case "$s4": return 20;
            case "$s5": return 21;
            case "$s6": return 22;
            case "$s7": return 23;
            case "$t8": return 24;
            case "$t9": return 25;
            case "$k0": return 26;
            case "$k1": return 27;
            case "$gp": return 28;
            case "$sp": return 29;
            case "$fp": return 30;
            case "$ra": return 31;   
        }

        return -1;
    }
}