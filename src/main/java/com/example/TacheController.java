package com.example;

import java.util.ArrayList;

public class TacheController {
    public String DisplayAll(ArrayList<Tache> listTache) {
        String str = "";
        for (Tache tache : listTache) {
            str += DisplayTache(tache);
        }
        return str;
    }

    public String DisplayTache(Tache tache) {
        return tache.toString();
    }

}
