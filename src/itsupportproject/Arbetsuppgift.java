/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsupportproject;

/**
 *
 * @author Richard
 */
public class Arbetsuppgift {
    
    private int uppgiftsID;
    private String uppgiftsTyp;
    private String kompetensKrav;
    private String status;
    private double budgeteradTid;
    private String beskrivning;
    private int tilldeladPersID;
    private String kommentar;
    
       // behövs alla konstruktorer?
    public Arbetsuppgift(String typ, String komp, String stat, double tid, String besk, int tilld){
        this.uppgiftsTyp = typ;
        this.kompetensKrav = komp;
        this.status = stat;
        this.budgeteradTid = tid;
        this.beskrivning = besk;
        this.tilldeladPersID = tilld;
    }
    public Arbetsuppgift(String typ, String stat, double tid, String besk){
        this.uppgiftsTyp = typ;
        this.status = stat;
        this.budgeteradTid = tid;
        this.beskrivning = besk;
        
    }

    public Arbetsuppgift(String typ) {
        this.uppgiftsTyp = typ;
    }
    
    public void lagraUppgiftDb(){
        // skapa metod i databasemanager men se över databasen först
    }
    
    
    
    // Går säkert skriva om snyggare med "index" osv. Detta är iaf rätt tydligt.

    public String getKompetensKrav(){
        return this.kompetensKrav;
    }
    
    public double getBudgeteradTid(){
        return this.budgeteradTid;
    }
    
    public String getUppgiftstyp(){
        return this.uppgiftsTyp;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public String getBeskrivning(){
        return this.beskrivning;
    }
    
    
       
    public int getTilldeladPers(){
        return this.tilldeladPersID;
    }
    
    
}
