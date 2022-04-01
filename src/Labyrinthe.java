import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
        StringBuffer sb = new StringBuffer("");

        sb.append("Etat du labyrinthe :\n");
        sb.append("Dimensions : \t" + this.murs.length + ":" + this.murs[0].length);
        sb.append("\nPersonnage : \t" + this.personnage.getX() + ":" + this.personnage.getY());
        sb.append("\nSortie :\t\t" + this.sortie.getX() + ":" + this.sortie.getY() + "\n");
        for (int i = 0 ; i < this.murs.length ; i ++)
        {
            for (int j = 0 ; j < this.murs[i].length ; j ++)
            {
                sb.append(this.getChar(i,j));
            }
            sb.append("\n");
        }

        return sb.toString();
    }


    public boolean etreFini()
    {
        return this.personnage.getX() == this.sortie.getX() && this.personnage.getY() == this.sortie.getY();
    }

    public static Labyrinthe chargerLabyrinthe(String nom) throws IOException, FichierIncorrectException {
        BufferedReader br = new BufferedReader(new FileReader(nom));
        int x,y;

        try{
            x = Integer.parseInt(br.readLine());
            y = Integer.parseInt(br.readLine());
        }
        catch (NumberFormatException e){
            throw new FichierIncorrectException("probleme numero ligne ou colonne");
        }

        Labyrinthe res = new Labyrinthe();
        res.murs = new boolean[x][y];

        String ligne = br.readLine();
        int posLigne = 0;
        // Parcours du fichier
        while (ligne != null){
            // Parcours de la ligne

            // S'il y a trop ou pas assez de colonne
            if (ligne.length() != res.murs[0].length)
                throw new FichierIncorrectException("nombre colonnes ne correspond pas");
            for (int posCol=0; posCol < ligne.length(); posCol++ ){
                char c = ligne.charAt(posCol);
                switch (c){
                    case Labyrinthe.MUR:
                        res.murs[posLigne][posCol] = true;
                        break;
                    case Labyrinthe.SORTIE:
                        res.murs[posLigne][posCol] = false;
                        if (res.sortie == null)
                            res.sortie = new Sortie(posLigne, posCol);
                        else
                            throw new FichierIncorrectException("plusieurs sorties");
                        break;
                    case Labyrinthe.VIDE:
                        res.murs[posLigne][posCol] = false;
                        break;
                    case Labyrinthe.PJ:
                        res.murs[posLigne][posCol] = false;
                        // Verification qu'il n'y ait qu'un seul personnage
                        if (res.personnage == null)
                            res.personnage = new Personnage(posLigne, posCol);
                        else
                            throw new FichierIncorrectException("plusieurs personnages");
                        break;
                    default:
                        throw new FichierIncorrectException("Caractere inconnu "+ c);
                }
            }
            ligne = br.readLine();
            posLigne++;
        }
        // Si il y a plus ou moins de ligne qu'attendu
        if (posLigne != res.murs.length)
            throw new FichierIncorrectException("Nombre ligne ne correspond pas");

        // S'il n'y a pas de sortie
        if (res.sortie == null)
            throw new FichierIncorrectException("Sortie inconnue");

        // S'il n'y a pas de personnage
        if (res.personnage == null)
            throw new FichierIncorrectException("Personnage inconnu");

        return res;
    }

}
