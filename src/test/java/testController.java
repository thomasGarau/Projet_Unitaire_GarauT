import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ResourceBundle.Control;

import com.example.Gestiontache;
import com.example.Projet;
import com.example.TacheController;

public class testController {
    

    @Test
    public void testDisplayTache(){
        TacheController c = new TacheController();
        Projet p = new Projet("projet");
        p.ajouterTacheProjet("titre", "description");
        p.ajouterTacheProjet("titre2", "description2");
        p.ajouterTacheProjet("titre3", "description3");
        p.ajouterTacheProjet("titre4", "description4");
        c.DisplayTache(p.getTache("titre"));
    }
}
