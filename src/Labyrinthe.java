/** 
 * Squelette de classe labyrinthe
 */
class Labyrinthe{

    //Attributes
    boolean [][] murs;
    Personnage personnage;
    Sortie sortie;

    char getChar(int x, int y)
    {

    }


    static int[] getSuivant(int x, int y, String action) {
        int[] resPostion = new int[2];
        switch (action){
            case "HAUT":
                resPostion[0] = x-1;
                resPostion[1] = y;
                break;
            case "BAS":
                resPostion[0] = x+1;
                resPostion[1] = y;
                break;
            case "GAUCHE":
                resPostion[0] = x;
                resPostion[1] = y-1;
                break;
            case "DROITE":
                resPostion[0] = x;
                resPostion[1] = y+1;
                break;
            default:
                throw new ActionInconnueException("Direction inconnue !");
        }
        return  resPostion;
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
