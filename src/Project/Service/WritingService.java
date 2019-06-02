package Project.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class WritingService {
    public String path;
    public WritingService(){path =" ";}
    public WritingService(String path) {
        this.path = path;
    }
    public void write(List<String> line) {
        try {
            FileWriter fw = new FileWriter(path , true);
            BufferedWriter bw = new BufferedWriter(fw);
            try {
                for (String cuv: line)
                {
                    bw.write(cuv + ",");
                }
                bw.write( "\r\n");
                bw.flush();
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                bw.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public void updatesql()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(Exception e){
            System.out.println(e);}
        Connection cnn = null;
        try{
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:1000/petshop","root","1234");

        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }
}
