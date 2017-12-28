package itsupportproject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import itsupportproject.DatabaseManager;


public class Program {

    static ArrayList<Arende> arendelista = new ArrayList<>();
    static ArrayList<Personal> perslista = new ArrayList<>();
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        // TODO code application logic here

        DesktopGUI gui = new DesktopGUI();
        hamtaPersonal();
        hamtaArenden();
        gui.setVisible(true);
        
        
    }   
    
    public static void hamtaArenden() throws ClassNotFoundException, SQLException{ 
        //döp om skickapersdb till typ populeraPerslista?
        arendelista = DatabaseManager.populeraArendenFranDb();
    }
    
    public static void hamtaPersonal() throws ClassNotFoundException, SQLException{
        //döp om skickapersdb till typ populeraPerslista?
        perslista = DatabaseManager.populeraPerslistaFranDb();
    }
    
    public static void registreraArende(){
        // hämta alla arbetsuppgifter från specifika ärendeinstansen
        // insert till databasen
        arendelista.get(arendelista.size()-1).lagraUppgifterDb();
    }
    
    public static void skapaArende(int p, String b, float bt, String s){
        Arende nyttArende = new Arende(p, b, bt,s);
        arendelista.add(nyttArende);
    }
    
    public static void laggTillUppgift(String typ, String komp, String stat, double tid, String besk, int tilld){
        //Aktuellt ärende är alltid senaste tillagda - lägg till uppgift i listans sista ärende
            arendelista.get(arendelista.size()-1).laggTillUppgift(typ, komp, stat, tid, besk, tilld);
            
                    
    }
    
    public static ArrayList<Arbetsuppgift> getUppg(){
        return arendelista.get(arendelista.size()-1).getUppgifter(); 
    }
    
    public static String getPersNamn(int id){
        String fornamnEfternamn = "";
        
        
        for(int i = 0; i < perslista.size(); i++){
            if(perslista.get(i).getPersID() == id){
                fornamnEfternamn = perslista.get(i).getFullName();
            }
        }
        return fornamnEfternamn;
    }
    
    public static String getKompKrav(){
        return arendelista.get(arendelista.size()-1).getKomp();
    }
    
    public static double getLastArendeTid(){
        return arendelista.get(arendelista.size()-1).getTotalBudgeteradTid();
    }
    
    public static double getArendeTid(int id){
        
        double tempTid = 0;
        for(int i = 0; i < arendelista.size();i++){
            if(arendelista.get(i).getID() == id){
                tempTid = arendelista.get(i).getTotalBudgeteradTid();
            }
        }
        return tempTid;
    }
    
    public static double getArendeAnvandTid(int id){
        
        double tempAnvandTid = 0;
        for(int i = 0; i < arendelista.size();i++){
            if(arendelista.get(i).getID() == id){
                tempAnvandTid = arendelista.get(i).getAnvandTid();
            }
        }
        return tempAnvandTid;
    }
    
    public static String getArendeBeskrivning(int id){
        
        String tempBeskr = "";
        for(int i = 0; i < arendelista.size();i++){
            if(arendelista.get(i).getID() == id){
                tempBeskr = arendelista.get(i).getBeskrivning();
            }
        }
        return tempBeskr;
    }
    
    public static void setArendeTid(){
        arendelista.get(arendelista.size()-1).setTotalTid();
    }
    
    
    
    
}
    
