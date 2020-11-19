package javaapplication1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rishika
 */
public class DatabaseHandler {
    //private static DatabaseHandler handler;
    
    private static final String DB_URL = "jdbc:derby:database;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;
    
    public DatabaseHandler(){
        createConnection();
        setupVanTable();
        setupDustbinTable();
    }
    
    // Creating a connection to database
    void createConnection() {
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(DB_URL);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    void setupDustbinTable() {
        String TABLE_NAME = "DUSTBIN";
        try{
            stmt = conn.createStatement();
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            // Checking if Table Van already exists
            if(tables.next()){
                System.out.println("Table " + TABLE_NAME + " already exists.");
            }
            //If the table does not exist then creating it
            else{
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "     ID varchar(2000) primary key,\n"
                        + "     location varchar(2000),\n"
                        + "     dimension varchar(2000),\n"
                        + "     sensedMoisture double default 45.0,\n"
                        + "     sensedGarbageDepth double default 80.0,\n"
                        + "     moisture varchar(2000) default 'Dry',\n"
                        + "     isFull boolean default false,\n"
                        + "     delay integer default 0,\n"
                        + "     isMailSentToVan boolean default false,\n"
                        + "     isMailSentToAuthority boolean default false\n"
                        + "  )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + "... Setup Database");
        }
        /*finally{
            
        }*/
    }
    
    //Craeting a table in the database for van
    void setupVanTable() {
        String TABLE_NAME = "VAN";
        try{
            stmt = conn.createStatement();
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            // Checking if Table Van already exists
            if(tables.next()){
                System.out.println("Table " + TABLE_NAME + " already exists.");
            }
            //If the table does not exist then creating it
            else{
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "     ID varchar(2000) primary key,\n"
                        + "     email varchar(2000),\n"
                        + "     driver varchar(2000)"
                        + "  )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + "... Setup Database");
        }
        /*finally{
            
        }*/
    }
    
   // Functin execQuery(Always returns something)
    public ResultSet execQuery(String query){
//        System.out.println("1");
        ResultSet result;
        try{
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            return null;
        } finally{
            
        }
        
        return result;
    }
    
    // Function execAction ( returns bool : true if action is performed successfully)
    public boolean execAction(String qu){
        try {
            stmt = conn.createStatement();
            stmt.execute(qu);
            return true;
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
            System.out.println("Exception at execAction " + ex.getLocalizedMessage());
            return false;
        }
    }
}
