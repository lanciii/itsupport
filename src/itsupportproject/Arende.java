
package itsupportproject;

import java.util.ArrayList;

public class Arende {
    
    private int arendeID;
    private int prio;
    private String arendebeskrivning = "";
    private double totalBudgeteradTid = 0;
    private double tidsAtgang = 0;
    private String status = "";
    private ArrayList<Arbetsuppgift> uppgiftslista = new ArrayList<>();
    
    public Arende(){
        //behövs den?
    }
    
    public Arende(int id, int p, String b, float bt, float ta, String s){
        this.arendeID=id;
        this.prio=p;
        this.arendebeskrivning=b;
        this.totalBudgeteradTid=bt;
        this.tidsAtgang=ta;
        this.status=s;
        
    }
    
    //konstruktor utan ID
      public Arende(int p, String b, float bt, String s){
        this.prio=p;
        this.arendebeskrivning=b;
        this.totalBudgeteradTid=bt;
        this.status=s;
    }
    
    public void lagraUppgifterDb(){
        for(int i = 0; i < uppgiftslista.size(); i++){
           uppgiftslista.get(i).lagraUppgiftDb();
        }
    }
    
    public void laggTillUppgift(String typ, String komp, String stat, double tid, String besk, int tilld){
        Arbetsuppgift nyUppg = new Arbetsuppgift(typ, komp, stat, tid, besk, tilld);
        uppgiftslista.add(nyUppg);
    }
    
    public ArrayList<Arbetsuppgift> getUppgifter(){
        return uppgiftslista;
    }
    
    public double getTotalBudgeteradTid(){
        return this.totalBudgeteradTid;
    }
    
    
    public void setTotalTid(){
        // Adderar uppgiftslistans sista tillagda uppgifts budgeterade tid till totaltid
        this.totalBudgeteradTid += uppgiftslista.get(uppgiftslista.size()-1).getBudgeteradTid();
    }
    
    public void setBeskrivning(String b){
        this.arendebeskrivning = b;
    }
    
    public String getBeskrivning(){
        return this.arendebeskrivning;
    }
    public int getID(){
        return this.arendeID;
    }
    public void setPrio(int p){
        this.prio = p;
    }
    
    public int getPrio(){
        //behövs denna? kan den slås ihop?
        return this.prio;
    }
    
    public double getAnvandTid(){
        return this.tidsAtgang;
    }
    
    public String getKomp(){
        return uppgiftslista.get(uppgiftslista.size()-1).getKompetensKrav();
    }

    
   
   
    
    
        
}
