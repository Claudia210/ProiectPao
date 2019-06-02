package Project.Persoana;

import Project.Superclasa.Person;

import java.sql.*;

public class Employee extends Person {
    final static int password = 1234;
    int id;


    public static int getPassword() {
        return password;
    }

    public int inregistrare(int parola){
        if (parola != password)
            return 0;
        else
            return 1;
    }

    public void updateangajati() throws SQLException
    {
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:1000/petshop","root","12345");

            String query = " insert into users (employee_id,first_name, last_name)"
                    + " values (?, ?, ?, ?, ?)";


            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1, Integer.valueOf(id) );
            preparedStmt.setString (2, String.valueOf(Date.valueOf(first_name)));
            preparedStmt.setString   (3, String.valueOf(last_name));
            preparedStmt.execute();
            if(conn != null)
                conn.close();
        } catch (SQLException ex){}

    }

}
