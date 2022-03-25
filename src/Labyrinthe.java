/** 
 * Squelette de classe labyrinthe
 */
class Labyrinthe{

    // Static attributes
    public static final String HAUT = "haut";
    public static final String BAS = "bas";
    public static final String DROITE = "droite";
    public static final String GAUCHE = "gauche";


    //Attributes
    boolean [][] murs;
    Personnage personnage;
    Sortie sortie;

    //Methods
    char getChar(int x, int y)
    {
        if (this.murs[x][y])
            return 'X';
        if (x == this.personnage.getX() && y == this.personnage.getY())
            return 'P';
        if (x == this.sortie.getX() && y == this.sortie.getY())
            return 'S';
        return '.';
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
        // Initialisation
        boolean deplacementfini = false;
        int[] posApresDeplacement;
        char typeCase;

        // Se deplace dans une direction tant qu'il ne croise pas un mur
        while (!deplacementfini){
            // Recuperation des valeurs de la case suivante
            posApresDeplacement = Labyrinthe.getSuivant(this.personnage.getX(), this.personnage.getY(), action);
            // Recuperation du type de la case suivante
            typeCase = getChar(posApresDeplacement[0], posApresDeplacement[1]);

            // Verification du type correspondant a des cases ou on peut s'y deplacer
            if (typeCase == Labyrinthe.VIDE || typeCase == Labyrinthe.SORTIE){
                this.personnage.setX(posApresDeplacement[0]);
                this.personnage.setY(posApresDeplacement[1]);
            }
            else{
                deplacementfini = true;
            }
        }
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
