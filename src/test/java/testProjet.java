import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Gestiontache;
import com.example.Projet;

//test d'intégration projet + gestiontache
public class testProjet {
    
    @Test 
    public void testAjouterTacheProjet(){
        Projet p = new Projet("nom");
        p.ajouterTacheProjet("titre", "description");
        //verifie que la tâches est bien dans le dictionnaire des taches de gestionTache avec getTache 
        //et getTaches.contains verifie qu'il ce trouve dans la liste de tache du projet 
        assertTrue(p.getTaches().contains(p.getTache("titre")));
        //verifie que ca retourne une exception si la tache existe pas
        assertThrows(IllegalArgumentException.class, () -> p.getTaches().contains(p.getTache("aze")));
        
    }

    @Test
    public void testCompleterTacheProjet(){
        Projet p = new Projet("nom");
        p.ajouterTacheProjet("titre", "description");
        p.completerTacheProjet("titre");
        //verifie que l'état est bien a complete
        assertTrue(p.getTache("titre").getEtat().equals("complete"));
        //verifie que la mise à jours à bien ete repercuté dans le dico de gestiontache
        assertTrue(p.getTaches().contains(p.getTache("titre"))); 
        //test le cas ou la tâche n'existe pas
        assertThrows(IllegalArgumentException.class, () -> p.completerTacheProjet("aze"));
    }

    @Test
    public void testverifierTache(){
        Projet p = new Projet("nom");
        p.ajouterTacheProjet("titre", "description");
        //verifie qu'elle n'est pas complete
        assertFalse(p.verifierTacheProjet("titre"));
        p.completerTacheProjet("titre");
        //verifie que la tâche est bien complete
        assertTrue(p.verifierTacheProjet("titre"));
        //test le cas ou la tâche n'existe pas
        assertThrows(IllegalArgumentException.class, () -> p.verifierTacheProjet("aze"));
    }

    @Test
    public void testCalculDuree(){
        Projet p = new Projet("nom");
        p.ajouterTacheDuree("titre", "description", 10);
        p.ajouterTacheDuree("titre2", "description2", 20);
        //verifie que la duree est bien de 30
        assertEquals(30, p.calculDuree());
        p.ajouterTacheDuree("titre3", "description3", -12);
        //verifie que la duree est bien de 30
        assertEquals(30, p.calculDuree());
        Projet p2 = new Projet("nom");
        //verifie que la duree est bien de 0
        assertEquals(0, p2.calculDuree());
    }

}
