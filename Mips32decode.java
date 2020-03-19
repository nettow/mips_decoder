import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Mips32decode{
    public static void main(String[] args) {
        BufferedReader reader;
        String line;

        try{
            reader = new BufferedReader(new FileReader(args[0]));
            line = reader.readLine();

            while(line != null){
                //processamento aqui
                String binaryDecoded = RegisterDecoder.decode(line);
                writeOutput(binaryDecoded, args[1]);
                line = reader.readLine();
            }

            reader.close();

        } catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void writeOutput(String str, String fileName){

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