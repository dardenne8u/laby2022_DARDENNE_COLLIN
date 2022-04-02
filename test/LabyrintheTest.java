import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LabyrintheTest {

    /**
     * Teste si un objet Labyrinthe construit avec
     * le constructeur vide a bien ses attributs
     * qui valent null.
     */
    @Test
    public void test_Labyrinthe_constructeurVide ()
    {
        //Initialisation
        Labyrinthe laby = new Labyrinthe();

        //Tests
        assertNull(laby.personnage, "doit etre null");
        assertNull(laby.sortie, "doit etre null");
        assertNull(laby.murs, "doit etre null");
    }

    /**
     * Teste si un objet Labyrinthe construit avec
     * a partir d'un personnage, d'une sortie et d'un
     * tableau de murs a bien ses attributs qui
     * correspondent aux paramètres.
     */
    @Test
    public void test_Labyrinthe_constructeurParams ()
    {
        //Initialisation
        Labyrinthe laby;
        boolean[][] murs;

        //Preparation des donnees
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        Personnage p = new Personnage(2,3);
        Sortie s = new Sortie(1,1);

        laby = new Labyrinthe(p, s, murs);

        //Tests
        assertEquals(new Personnage(2,3), laby.personnage, "doit etre le meme personnage");
        assertEquals(new Sortie(1,1), laby.sortie, "doit la meme sortie");
        assertEquals(murs, laby.murs, "doit etre le meme attribut murs");
    }

    /**
     * Teste si un objet Labyrinthe renvoie bien
     * le caractere X avec la methode getChar lorsque
     * la case est un mur.
     */
    @Test
    public void test_getChar_mur ()
    {
        //Initialisation
        Labyrinthe laby;
        boolean[][] murs;

        //Preparation des donnees
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        Personnage p = new Personnage(2,3);
        Sortie s = new Sortie(1,1);

        laby = new Labyrinthe(p, s, murs);

        //Appel de la methode
        char res = laby.getChar(0,0);

        //Test
        assertEquals('X', res, "doit renvoyer le caractere X");
    }

    /**
     * Teste si un objet Labyrinthe renvoie bien
     * le caractere P avec la methode getChar lorsqu'il
     * s'agit de la case ou se situe le personnage.
     */
    @Test
    public void test_getChar_pj ()
    {
        //Initialisation
        Labyrinthe laby;
        boolean[][] murs;

        //Preparation des donnees
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        Personnage p = new Personnage(2,3);
        Sortie s = new Sortie(1,1);

        laby = new Labyrinthe(p, s, murs);

        //Appel de la methode
        char res = laby.getChar(2,3);

        //Test
        assertEquals('P', res, "doit renvoyer le caractere P");
    }

    /**
     * Teste si un objet Labyrinthe renvoie bien
     * le caractere S avec la methode getChar lorsqu'il
     * s'agit de la case ou se situe la sortie.
     */
    @Test
    public void test_getChar_sortie ()
    {
        //Initialisation
        Labyrinthe laby;
        boolean[][] murs;

        //Preparation des donnees
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        Personnage p = new Personnage(2,3);
        Sortie s = new Sortie(1,1);

        laby = new Labyrinthe(p, s, murs);

        //Appel de la methode
        char res = laby.getChar(1,1);

        //Test
        assertEquals('S', res, "doit renvoyer le caractere S");
    }

    /**
     * Teste si un objet Labyrinthe renvoie bien
     * le caractere . avec la methode getChar lorsqu'il
     * s'agit d'une case vide.
     */
    @Test
    public void test_getChar_vide ()
    {
        //Initialisation
        Labyrinthe laby;
        boolean[][] murs;

        //Preparation des donnees
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        Personnage p = new Personnage(2,3);
        Sortie s = new Sortie(1,1);

        laby = new Labyrinthe(p, s, murs);

        //Appel de la methode
        char res = laby.getChar(1,2);

        //Test
        assertEquals('.', res, "doit renvoyer le caractere .");
    }

    //getSuivant, deplacerPerso, toString

    /**
     * Teste si etreFini renvoie false lorsque
     * les coordonnees x du personnage sont differentes
     * de celles de la sortie
     */
    @Test
    public void test_etreFini_fauxX ()
    {
        //Initialisation
        Labyrinthe laby;
        boolean[][] murs;

        //Preparation des donnees
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        Personnage p = new Personnage(2,1);
        Sortie s = new Sortie(1,1);

        laby = new Labyrinthe(p, s, murs);

        //Appel de la methode
        boolean res = laby.etreFini();

        //Test
        assertEquals(false, res, "doit etre faux");
    }

    /**
     * Teste si etreFini renvoie false lorsque
     * les coordonnees y du personnage sont differentes
     * de celles de la sortie
     */
    @Test
    public void test_etreFini_fauxY ()
    {
        //Initialisation
        Labyrinthe laby;
        boolean[][] murs;

        //Preparation des donnees
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        Personnage p = new Personnage(1,3);
        Sortie s = new Sortie(1,1);

        laby = new Labyrinthe(p, s, murs);

        //Appel de la methode
        boolean res = laby.etreFini();

        //Test
        assertEquals(false, res, "doit etre faux");
    }

    /**
     * Teste si etreFini renvoie false lorsque
     * les coordonnees x et y du personnage sont
     * egales a celles de la sortie.
     */
    @Test
    public void test_etreFini_vrai ()
    {
        //Initialisation
        Labyrinthe laby;
        boolean[][] murs;

        //Preparation des donnees
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        Personnage p = new Personnage(1,1);
        Sortie s = new Sortie(1,1);

        laby = new Labyrinthe(p, s, murs);

        //Appel de la methode
        boolean res = laby.etreFini();

        //Test
        assertEquals(true, res, "doit etre vrai");
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