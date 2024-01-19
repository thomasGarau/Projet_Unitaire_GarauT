package com.example;

import java.util.HashMap;

public class Gestiontache {
    private HashMap<String, Tache> taches = new HashMap<String, Tache>();

    public Gestiontache(){}

    public void ajouterTache(String titre, String description) {
        Tache t = new Tache(titre, description);
        taches.put(titre, t);
    }

    public void supprimerTache(String titre) {
        if (taches.containsKey(titre)){
            taches.remove(titre);
        }else{
            throw new IllegalArgumentException("La tache n'existe pas");
        }
    }

    public Boolean verifierTache(String titre) {
        if (taches.containsKey(titre)){
            return taches.get(titre).getEtat().equals("complete");
        }else{
            throw new IllegalArgumentException("La tache n'existe pas");
        }
    }

    public void completerTache(String titre) {
        if (taches.containsKey(titre)){
            taches.get(titre).setEtat("complete");
        }else{
            throw new IllegalArgumentException("La tache n'existe pas");
        }
    }

    public HashMap<String, Tache> getTaches() {
        return taches;
    }

    public void ajouterTacheDuree(String titre, String description, int temps) {
        Tache t = new Tache(titre, description, temps);
        taches.put(titre, t);
    } 

    
}
