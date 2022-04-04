import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LabyrintheTest {

    //Global attributes
    Labyrinthe laby;
    boolean[][] murs;
    Personnage p;
    Sortie s;


    //Methods
    /**
     * Teste si un objet Labyrinthe construit avec
     * le constructeur vide a bien ses attributs
     * qui valent null.
     */
    @Test
    public void test_Labyrinthe_constructeurVide ()
    {
        //Initialisation
        laby = new Labyrinthe();

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
        //Preparation des donnees
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        p = new Personnage(2,3);
        s = new Sortie(1,1);

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
        //Preparation des donnees
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        p = new Personnage(2,3);
        s = new Sortie(1,1);

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
        //Preparation des donnees
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        p = new Personnage(2,3);
        s = new Sortie(1,1);

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
        //Preparation des donnees
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        p = new Personnage(2,3);
        s = new Sortie(1,1);

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
        //Preparation des donnees
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        p = new Personnage(2,3);
        s = new Sortie(1,1);

        laby = new Labyrinthe(p, s, murs);

        //Appel de la methode
        char res = laby.getChar(1,2);

        //Test
        assertEquals('.', res, "doit renvoyer le caractere .");
    }


    //TODO : getSuivant, deplacerPerso


    /**
     * Teste si la fonction toString renvoie la chaine attendue
     */
    @Test
    public void test_toString_ok ()
    {
        //Preparation des donnees
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        p = new Personnage(2,3);
        s = new Sortie(1,1);

        laby = new Labyrinthe(p, s, murs);

        String expected = "Etat du labyrinthe :\nDimensions : \t5:7\nPersonnage : \t2:3\nSortie :\t\t1:1\nXXXXXXX\nXS....X\nX..P..X\nX.....X\nXXXXXXX\n";

        //Appel de la methode
        boolean res = laby.toString().equals(expected);

        //Test
        assertTrue(res, "doit etre la meme chaine");
    }


    /**
     * Teste si etreFini renvoie false lorsque
     * les coordonnees x du personnage sont differentes
     * de celles de la sortie
     */
    @Test
    public void test_etreFini_fauxX ()
    {
        //Preparation des donnees
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        p = new Personnage(2,1);
        s = new Sortie(1,1);

        laby = new Labyrinthe(p, s, murs);

        //Appel de la methode
        boolean res = laby.etreFini();

        //Test
        assertFalse(res, "doit etre faux");
    }

    /**
     * Teste si etreFini renvoie false lorsque
     * les coordonnees y du personnage sont differentes
     * de celles de la sortie
     */
    @Test
    public void test_etreFini_fauxY ()
    {
        //Preparation des donnees
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        p = new Personnage(1,3);
        s = new Sortie(1,1);

        laby = new Labyrinthe(p, s, murs);

        //Appel de la methode
        boolean res = laby.etreFini();

        //Test
        assertFalse(res, "doit etre faux");
    }

    /**
     * Teste si etreFini renvoie false lorsque
     * les coordonnees x et y du personnage sont
     * egales a celles de la sortie.
     */
    @Test
    public void test_etreFini_vrai ()
    {
        //Preparation des donnees
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        p = new Personnage(1,1);
        s = new Sortie(1,1);

        laby = new Labyrinthe(p, s, murs);

        //Appel de la methode
        boolean res = laby.etreFini();

        //Test
        assertTrue(res, "doit etre vrai");
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
        murs = new boolean[5][7];
        murs[0] = new boolean[] {true,true,true,true,true,true,true};
        murs[1] = new boolean[] {true,false,false,false,false,false,true};
        murs[2] = new boolean[] {true,false,false,false,false,false,true};
        murs[3] = new boolean[] {true,false,false,false,false,false,true};
        murs[4] = new boolean[] {true,true,true,true,true,true,true};

        p = new Personnage(2,3);
        s = new Sortie(1,1);

        laby = new Labyrinthe(p, s, murs);

        // Test du labyrinthe
        assertEquals(laby, atester, "Mauvais labyrinthe");
    }


    /**
     * Test la methode chargerLabyrinthe en verifiant si l'exception deux sortie est bien lancee
     */
    @Test
    public void test_charger_deuxSortie(){
        Exception exception = assertThrows(FichierIncorrectException.class, ()-> Labyrinthe.chargerLabyrinthe("laby/laby_deuxSortie.txt"));

        String msgAttendu = "plusieurs sorties";
        String msgRecu = exception.getMessage();

        assertEquals(msgAttendu, msgRecu, "Pas la meme exception");
    }

    @Test
    public void test_charger_deuxPerso(){
        Exception exception = assertThrows(FichierIncorrectException.class, ()-> Labyrinthe.chargerLabyrinthe("laby/laby_deuxPerso.txt"));

        String msgAttendu = "Plusieurs personnages";
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
        Exception exception = assertThrows(FichierIncorrectException.class, ()-> Labyrinthe.chargerLabyrinthe("laby/laby_pasSortie.txt"));

        String msgAttendu = "Sortie inconnue";
        String msgRecu = exception.getMessage();

        assertEquals(msgAttendu, msgRecu, "Pas la meme exception");
    }

    @Test
    public void test_charger_pasPerso(){
        Exception exception = assertThrows(FichierIncorrectException.class, ()-> Labyrinthe.chargerLabyrinthe("laby/laby_pasPerso.txt"));

        String msgAttendu = "Personnage inconnu";
        String msgRecu = exception.getMessage();

        assertEquals(msgAttendu, msgRecu, "Pas la meme exception");
    }

    @Test
    public void test_charger_pasAssezColonnes(){
        Exception exception = assertThrows(FichierIncorrectException.class, ()-> Labyrinthe.chargerLabyrinthe("laby/laby_pasAssezColonnes.txt"));

        String msgAttendu = "Nombre de colonnes trop petit !";
        String msgRecu = exception.getMessage();

        assertEquals(msgAttendu, msgRecu, "Pas la meme exception");
    }

    @Test
    public void test_charger_tropColonnes(){
        Exception exception = assertThrows(FichierIncorrectException.class, ()-> Labyrinthe.chargerLabyrinthe("laby/laby_tropColonnes.txt"));

        String msgAttendu = "Nombre de colonnes trop grand !";
        String msgRecu = exception.getMessage();

        assertEquals(msgAttendu, msgRecu, "Pas la meme exception");
    }

    @Test
    public void test_charger_pasAssezLigne(){
        Exception exception = assertThrows(FichierIncorrectException.class, ()-> Labyrinthe.chargerLabyrinthe("laby/laby_pasAssezLigne.txt"));

        String msgAttendu = "Nombre de ligne trop faible";
        String msgRecu = exception.getMessage();

        assertEquals(msgAttendu, msgRecu, "Pas la meme exception");
    }

    @Test
    public void test_charger_tropLigne(){
        Exception exception = assertThrows(FichierIncorrectException.class, ()-> Labyrinthe.chargerLabyrinthe("laby/laby_tropLigne.txt"));

        String msgAttendu = "Nombre de ligne trop grand !";
        String msgRecu = exception.getMessage();

        assertEquals(msgAttendu, msgRecu, "Pas la meme exception");
    }

    @Test
    public void test_charger_NombreInvalide(){
        Exception exception = assertThrows(FichierIncorrectException.class, ()-> Labyrinthe.chargerLabyrinthe("laby/laby_NombreInvalide.txt"));

        String msgAttendu = "Format des nombres invalides !";
        String msgRecu = exception.getMessage();

        assertEquals(msgAttendu, msgRecu, "Pas la meme exception");
    }

    /**
     * Test la methode deplacerPerso sans erreur
     * @throws FichierIncorrectException Format fichier incorrecte
     * @throws IOException Lecture du fichier impossible
     * @throws ActionInconnueException Action demandee inconnue
     */
    @Test
    public void test_deplacer() throws FichierIncorrectException, IOException, ActionInconnueException {
        // Initialsation
        Labyrinthe atester = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        Personnage pAttendu = new Personnage(3,5);
        // Appel de la methode
        atester.deplacerPerso(Labyrinthe.GAUCHE);
        atester.deplacerPerso(Labyrinthe.DROITE);
        atester.deplacerPerso(Labyrinthe.HAUT);
        atester.deplacerPerso(Labyrinthe.BAS);

        // Test de la postion
        assertEquals(pAttendu, atester.personnage, "Personnage au mauvais endroit !");
    }

    /**
     * Test la methode deplacerPerso
     * en verifiant si l'exception est bien
     * lancee
     * @throws FichierIncorrectException format fichier incorrect
     * @throws IOException lecture du fichier impossible
     */
    @Test
    public void test_deplacer_actionInconnu() throws FichierIncorrectException, IOException {
        Labyrinthe atester = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        // test de l'envoi de l'exception
        assertThrows(ActionInconnueException.class, ()-> atester.deplacerPerso("qzpdnqoif"));
    }

}