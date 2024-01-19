import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Gestiontache;

public class testGestionTache {
    
    @Test
    public void testAjouterTache(){
        Gestiontache g = new Gestiontache();
        g.ajouterTache("titre", "description");
        //verifie que la tâches est bien dans le dictionnaire des taches de gestionTache
        assertTrue(g.getTaches().containsKey("titre"));
    }

    @Test
    public void testSupprimerTache(){
        Gestiontache g = new Gestiontache();
        g.ajouterTache("titre", "description");
        g.supprimerTache("titre");
        //test qu'on ne trouve plus le titre dans la liste des taches
        assertFalse(g.getTaches().containsKey("titre"));
        //test qu'une exception est bien levez quand on cherche a supprimer une tache qui n'existe pas
        assertThrows(IllegalArgumentException.class, () -> g.supprimerTache("titre"));
    }

    @Test
    public void testCompleterTache(){
        Gestiontache g = new Gestiontache();
        g.ajouterTache("titre", "description");
        g.completerTache("titre");
        //verifie que l'état est bien a complete
        assertTrue(g.getTaches().get("titre").getEtat().equals("complete"));
        //test le cas ou la tâche n'existe pas
        assertThrows(IllegalArgumentException.class, () -> g.completerTache(null));
    }

    @Test
    public void testverifierTache(){
        Gestiontache g = new Gestiontache();
        g.ajouterTache("titre", "description");
        //verifie qu'elle n'est pas complete
        assertFalse(g.verifierTache("titre"));
        g.completerTache("titre");
        //verifie que la tâche est bien complete
        assertTrue(g.verifierTache("titre"));
        //test le cas ou la tâche n'existe pas
        assertThrows(IllegalArgumentException.class, () -> g.verifierTache(null));
    }
}
