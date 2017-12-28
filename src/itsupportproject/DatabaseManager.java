/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsupportproject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Richard
 */
public class DatabaseManager {
   
    private static final String DBURL = "jdbc:sqlserver://127.0.0.1\\MSSQLEXPRESS:1434;databaseName=itsupport";
    private static final String USER = "admin";
    private static final String PWD = "12345";
    private static ArrayList<Personal> hamtadPersDb = new ArrayList<>();
    private static ArrayList<Arende> hamtadeArendenDb = new ArrayList<>();
    private static Connection conn = null; //Hanterar uppkoppling
    private static PreparedStatement allStaff;
    private static PreparedStatement insertAssignment;
    private static final String staff_select = "SELECT persID, fNamn, eNamn, antalArenden FROM personal";
    private static final String assignment_select = "SELECT arendeID, status, budgetTid, tidsAtgang, beskrivning, prio FROM arende";
    private static final String task_select = "SELECT arendeID, status, budgetTid, tidsAtgang, beskrivning, prio FROM arende";

    public static ArrayList<Personal> populeraPerslistaFranDb(){
        return hamtadPersDb;
    }
    
    public static ArrayList<Arende> populeraArendenFranDb(){
        return hamtadeArendenDb;
    }
    
    
//Konstruktor
    public DatabaseManager() throws ClassNotFoundException, SQLException{
       //Koppla upp
       connectToDb();
       
    }
    
    public static void connectToDb() throws ClassNotFoundException, SQLException{
       //Koppla upp mot db
        if (conn == null){
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DBURL, USER, PWD);
        } 
    }
            
    public static void closeDbConnection() throws SQLException{
        //Stäng uppkoppling
        if (conn != null) {
            conn.close();
        }
    }
    
    public static void InsertAssignment(){ 
        //lägg som inparametrar allting vi skickar från ärende. på nåt sätt måste vi ju rulla igenom alla uppgifter för ärendet och lägga in dem också.
     
    };
    
    /*
    public static DefaultTableModel getTasksDb() throws SQLException, ClassNotFoundException {
        
        connectToDb();
        insertTasks = conn.prepareStatement(assignment_select, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = insertAssignment.executeQuery();
        ResultSetMetaData assignmentMetaData = rs.getMetaData();
        
        // names of columns
        Vector<String> assignmentsColumns = new Vector<String>();
        
        assignmentsColumns.add("ÄrendeID");
        assignmentsColumns.add("Status");
        assignmentsColumns.add("Budg. tid");
        assignmentsColumns.add("Tidsåtgång");
        assignmentsColumns.add("Beskr.");
        assignmentsColumns.add("Prio");

        int assColumnCount = assignmentMetaData.getColumnCount();

        // data of the table
        Vector<Vector<Object>> assignmentData = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> assignmentVector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= assColumnCount; columnIndex++) {
                assignmentVector.add(rs.getObject(columnIndex));
            }
            
            int arendeID = rs.getInt("arendeID");
            String status = rs.getString("status");
            float totalBudgeteradTid = rs.getFloat("budgetTid");
            float tidsAtgang = rs.getFloat("tidsAtgang");
            String arendebeskrivning = rs.getString("beskrivning");
            int prio = rs.getInt("prio");
            Arende nyttArende = new Arende(arendeID, prio, arendebeskrivning,totalBudgeteradTid,tidsAtgang,status);
            hamtadeArendenDb.add(nyttArende);
            assignmentData.add(assignmentVector);
        }
        
        //closeDbConnection();
        return new DefaultTableModel(assignmentData, assignmentsColumns);
      
    }
    */
    
     
    public static DefaultTableModel getAssignmentsDb() throws SQLException, ClassNotFoundException {
        
   
        connectToDb();
        insertAssignment = conn.prepareStatement(assignment_select, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = insertAssignment.executeQuery();
        ResultSetMetaData assignmentMetaData = rs.getMetaData();
        
        // names of columns
        Vector<String> assignmentsColumns = new Vector<String>();
        
        assignmentsColumns.add("ÄrendeID");
        assignmentsColumns.add("Status");
        assignmentsColumns.add("Budg. tid");
        assignmentsColumns.add("Tidsåtgång");
        assignmentsColumns.add("Beskr.");
        assignmentsColumns.add("Prio");

        int assColumnCount = assignmentMetaData.getColumnCount();

        // data of the table
        Vector<Vector<Object>> assignmentData = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> assignmentVector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= assColumnCount; columnIndex++) {
                assignmentVector.add(rs.getObject(columnIndex));
            }
            
            int arendeID = rs.getInt("arendeID");
            String status = rs.getString("status");
            float totalBudgeteradTid = rs.getFloat("budgetTid");
            float tidsAtgang = rs.getFloat("tidsAtgang");
            String arendebeskrivning = rs.getString("beskrivning");
            int prio = rs.getInt("prio");
            Arende nyttArende = new Arende(arendeID, prio, arendebeskrivning,totalBudgeteradTid,tidsAtgang,status);
            hamtadeArendenDb.add(nyttArende);
            assignmentData.add(assignmentVector);
        }
        
        //closeDbConnection();
        return new DefaultTableModel(assignmentData, assignmentsColumns);
        
     }

    public static DefaultTableModel getPersDb() throws SQLException, ClassNotFoundException {

        connectToDb();
        allStaff = conn.prepareStatement(staff_select, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = allStaff.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        
        columnNames.add("PersID");
        columnNames.add("Förnamn");
        columnNames.add("Efternamn");
        columnNames.add("Antal tilld.");

        int columnCount = metaData.getColumnCount();

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            
            int persID = rs.getInt("persID");
            String fNamn = rs.getString("fNamn");
            String eNamn = rs.getString("eNamn");
            int antalArenden = rs.getInt("antalArenden");
            Personal nyPersonal = new Personal(persID, fNamn, eNamn, antalArenden);
            hamtadPersDb.add(nyPersonal);
            data.add(vector);
        }
        

        //closeDbConnection();
        return new DefaultTableModel(data, columnNames);

    }
    
    
    
}
    


