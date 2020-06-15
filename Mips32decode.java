import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import decoders.*;

public class Mips32decode {
    public static void main(String[] args) {
        BufferedReader reader;
        String line;
        String[] values = new String[32];
        String[] registerStrings = { "v0 ", "v1 ", "a0 ", "a1 ", "a2 ", "a3 ", "t0 ", "t1 ", "t2 ", "t3 ", "t4 ", "t5 ", "t6 ", "t7 ", "t8 ", "t9 ", "s0 ", "s1 ", "s2 ", "s3 ", "s4 ", "s5 ", "s6 ", "s7 ", "s8 ", "gp ", "fp ", "sp ", "ra ", "at ", "k1 ", "k2 " };
        for (int i = 0; i < 32; i++) {
            values[i] = "00000000";
        }
        try {
            reader = new BufferedReader(new FileReader(args[0]));
            line = reader.readLine();

            while (line != null) {
                Objeto binaryDecoded = RegisterDecoder.decode(line);
                values[binaryDecoded.indice] = binaryDecoded.hexa;
                writeOutput(binaryDecoded.decodado, "saida.txt");
                line = reader.readLine();
            }
            String registersResult = "";

            for (int i = 0; i < 32; i++) {
                registersResult += registerStrings[i] + "0x" + values[i] + "\n";
            }

            writeOutput(registersResult, "registers.txt");
            
            reader.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeOutput(String str, String fileName) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(str);
            writer.append('\n');
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}