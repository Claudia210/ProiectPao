package Project.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadingService {
     public String path;
     public BufferedReader br;
    public ReadingService(String path,BufferedReader br) {
        this.path = path;
        try
        {
           br = new BufferedReader( new FileReader(this.path));
           this.br = br;

        }
        catch( IOException e )
        {
            System.out.println("Error opening file: "+ path );
        }
    }

    public BufferedReader getBr() {
        return br;
    }

    public List<String> read(BufferedReader br) throws IOException {
        if (br != null) {
                String line = br.readLine();
                if (line == null) {
                    return null;
                }
                String[] date = line.split(",");
                return new ArrayList<>(Arrays.asList(date));
            }
        br.close();
        return null;
    }
}