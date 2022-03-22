/** 
 * Squelette de classe labyrinthe
 */
class Labyrinthe{

    //Attributes
    boolean [][] murs;
    Personnage personnage;
    Sortie sortie;

    //Methods
    char getChar(int x, int y)
    {
        if (this.murs[x][y])
            return 'X';
        if (x == this.personnage.x && y == this.personnage.y)
            return 'P';
        if (x == this.sortie.x && y == this.sortie.y)
            return 'S';
        return '.';
    }


    static int[] getSuivant(int x, int y, String action) {
        throw new Error("TODO");
    }


    void deplacerPerso(String action) throws ActionInconnueException {
        throw new Error("TODO");
    }


    public String toString() {
        throw new Error("TODO");
    }


    public boolean etreFini() {
        throw new Error("TODO");
    }

    public static Labyrinthe chargerLabyrinthe(String nom) {
        throw new Error("TODO");
    }

}
