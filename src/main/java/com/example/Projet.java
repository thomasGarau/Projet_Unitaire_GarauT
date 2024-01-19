package com.example;

import java.util.ArrayList;

public class Projet {
    private String nom;
    private ArrayList<Tache> taches = new ArrayList<Tache>();
    private ArrayList<Tache> tachesDuree = new ArrayList<Tache>();
    private Gestiontache gestionTache;

    public Projet(String nom) {
        this.nom = nom;
        this.gestionTache = new Gestiontache();
    }

    public void ajouterTacheProjet(String titre, String description) {
        this.gestionTache.ajouterTache(titre, description);
        taches.add(gestionTache.getTaches().get(titre));
    }

    public void supprimerTacheProjet(String titre) {
        if (!this.gestionTache.getTaches().containsKey(titre)) {
            throw new IllegalArgumentException("La tache n'existe pas");
        }
        this.gestionTache.supprimerTache(titre);
        taches.remove(gestionTache.getTaches().get(titre));
    }

    public void completerTacheProjet(String titre) {
        if(!this.gestionTache.getTaches().containsKey(titre)){
            throw new IllegalArgumentException("La tache n'existe pas");
        }
        this.gestionTache.completerTache(titre);
    }

    public Boolean verifierTacheProjet(String titre) {
        if (!this.gestionTache.getTaches().containsKey(titre)) {
            throw new IllegalArgumentException("La tache n'existe pas");
        }
        return this.gestionTache.verifierTache(titre);
    }

    public Tache getTache(String key) {
        if (!this.gestionTache.getTaches().containsKey(key)) {
            throw new IllegalArgumentException("La tache n'existe pas");
        }
        return this.gestionTache.getTaches().get(key);
    }

    public ArrayList<Tache> getTaches() {
        return taches;
    }

    public void ajouterTacheDuree(String titre, String description, int temps) {
        this.gestionTache.ajouterTacheDuree(titre, description, temps);
        tachesDuree.add(gestionTache.getTaches().get(titre));
    }

    public int calculDuree(){
        int duree = 0;
        for (Tache t : tachesDuree){
            duree += t.getTemps();
        }
        return duree;
    }

    
}
