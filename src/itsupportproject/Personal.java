/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsupportproject;

import java.util.ArrayList;

/**
 *
 * @author Richard
 */
public class Personal {
    
    private int persID;
    private String fNamn;
    private String eNamn;
    private int antalArenden;
    
    private ArrayList<String> kompetenser = new ArrayList<>();
    
    public Personal (int persID, String fn, String en, int ant){
        this.persID = persID;
        this.fNamn = fn;
        this.eNamn = en;
        this.antalArenden = ant;
        
    }
    
    public String getFullName(){
        String fNamnENamn = this.fNamn + " " + this.eNamn;
        return fNamnENamn;
    }
    
    public int getPersID(){
        return this.persID;
    }
    
    public String getENamn(){
        return this.eNamn;
    }
    
    
    
    
}
