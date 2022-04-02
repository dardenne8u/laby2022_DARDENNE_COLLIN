import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LabyrintheTest {

    /**
     * Teste si un objet Labyrinthe construit avec
     * le constructeur vide a bien ses attributs
     * qui valent null.
     */
    @Test
    public void test_constructeur_vide ()
    {
        //Initialisation
        Labyrinthe laby = new Labyrinthe();

        //Tests
        assertEquals(null, laby.personnage, "doit etre null");
        assertEquals(null, laby.sortie, "doit etre null");
        assertEquals(null, laby.murs, "doit etre null");
    }


    /**
     * Test la methode chargerLabyrinthe lors que le fichier
     * n'a aucune erreur de format
     * @throws FichierIncorrectException Mauvais format de lecture pour le fichier
     * @throws IOException Impossibilite de lire le fichier
     */
    @Test
    public void test_charger_PasDeProbleme() throws FichierIncorrectException, IOException {
        // Initialisation
        Labyrinthe atester = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        // Labyrinthe qu'on doit obtenir
        boolean[][] murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        Labyrinthe resultat = new Labyrinthe(new Personnage(2,3), new Sortie(1,1),murs);

        // Test du labyrinthe
        assertEquals(resultat, atester, "Mauvais labyrinthe");
    }

    /**
     * Test la methode chargerLabyrinthe en verifiant si l'exception deux sortie est bien lancee
     */
    @Test
    public void test_charger_deuxSortie(){
        Exception exception = assertThrows(FichierIncorrectException.class, ()->{
            Labyrinthe atester = Labyrinthe.chargerLabyrinthe("laby/laby_deuxSortie.txt");
        });

        String msgAttendu = "plusieurs sorties";
        String msgRecu = exception.getMessage();

        assertEquals(msgAttendu, msgRecu, "Pas la meme exception");
    }

    /**
     * Test la methode chargerLabyrinthe
     * en verifiant si l'exception
     * pas de sortie est bien lancee
     */
    @Test
    public void test_charger_pasSortie(){
        Exception exception = assertThrows(FichierIncorrectException.class, ()->{
            Labyrinthe atester = Labyrinthe.chargerLabyrinthe("laby/laby_pasSortie.txt");
        });

        String msgAttendu = "Sortie inconnue";
        String msgRecu = exception.getMessage();

        assertEquals(msgAttendu, msgRecu, "Pas la meme exception");
    }

}