package Project.Service;
import java.io.*;
import java.sql.Timestamp;
import java.util.Date;

public class AuditService {
    public String action_name;

    public static void audit(String action_name)
    {
        try {
            FileWriter fw = new FileWriter("audit.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            try {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                bw.write("nume_actiune, timestamp\r\n"); //se scrie antetul
                bw.write(action_name + "," + timestamp + "\r\n");
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
}

