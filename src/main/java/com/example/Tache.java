package com.example;

public class Tache {
    private String titre; 
    private String description;
    private String etat;
    private int temps; 
    

    public Tache(String titre, String description) {
        this.titre = titre;
        this.description = description;
        this.etat = "A faire";
    }

    public Tache(String titre, String description, int temps) {
        this(titre, description);
        if(temps < 0){
            this.temps = 0;
        }else{
            this.temps = temps;
        }
    }

    public String getEtat(){
        return this.etat;
    }

    public void setEtat(String etat){
        this.etat = etat;
    }

    public int getTemps(){
        return this.temps;
    }
}
