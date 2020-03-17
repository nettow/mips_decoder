import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
                line = reader.readLine();
            }

            reader.close();

        } catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}