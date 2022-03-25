/** 
 * Squelette de classe labyrinthe
 */
class Labyrinthe{

    // Static attributes
    public static final String HAUT = "haut";
    public static final String BAS = "bas";
    public static final String DROITE = "droite";
    public static final String GAUCHE = "gauche";

    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char SORTIE = 'S';
    public static final char VIDE = '.';



    //Attributes
    boolean [][] murs;
    Personnage personnage;
    Sortie sortie;

    //Methods
    char getChar(int x, int y)
    {
        if (this.murs[x][y])
            return MUR;

        if (x == this.personnage.getX() && y == this.personnage.getY())
            return PJ;
        if (x == this.sortie.getX() && y == this.sortie.getY())
            return SORTIE;
        return VIDE;
    }


    static int[] getSuivant(int x, int y, String action) throws ActionInconnueException{
        int[] resPostion = new int[2];
        switch (action){
            case "haut":
                resPostion[0] = x-1;
                resPostion[1] = y;
                break;
            case "bas":
                resPostion[0] = x+1;
                resPostion[1] = y;
                break;
            case "gauche":
                resPostion[0] = x;
                resPostion[1] = y-1;
                break;
            case "droite":
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
        StringBuffer sb = new StringBuffer("");
        for (int i = 0 ; i <)

        return sb.toString();
    }


    public boolean etreFini() {
        throw new Error("TODO");
    }

    public static Labyrinthe chargerLabyrinthe(String nom) {
        throw new Error("TODO");
    }

}
