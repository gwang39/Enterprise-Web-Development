/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejdbc1;

/**
 *
 * @author guany
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author evansrb1
 */
public class Main {

    private static final String USERNAME = "johncolter";
    private static final String PASSWORD = "LetMeIn";
    private static final String HOST = "web6.jhuep.com";
    private static final String DB = "mysql";
    private static final int PORT = 3306;
    private static final String DB_NAME = "class";

    public Main() {
        try {
            Class.forName("org.apache.mysql.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading driver " + cnfe.getMessage());
        }
        try {
            String dbURL = "jdbc:" + DB + "://" + HOST + ":" + PORT + "/" + DB_NAME;
            Connection connection = DriverManager.getConnection(dbURL, USERNAME, PASSWORD);
            DatabaseMetaData meta = connection.getMetaData();
            System.out.println("Driver name: " + meta.getDriverName());
            System.out.println("Driver version: " + meta.getDriverVersion());
            
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            try {
                ResultSet resultSet = statement.executeQuery("select * from class.locations");
                System.out.println("People in the database are:");
                while (resultSet.next()) {
                    // first way...we'll use the column index
                    String firstName = resultSet.getString(2);

                    System.out.println(firstName);
                }
            } catch (SQLException sqle) {
                System.err.println("error: " + sqle.getMessage());
            }


            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();

        // TODO code application logic here
    }

}
