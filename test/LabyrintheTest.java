import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LabyrintheTest {

    @Test
    public void test_charger() throws FichierIncorrectException, IOException {
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

}