import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Squelette de classe labyrinthe
 */
class Labyrinthe{

    // Static attributes
    /**
     * Attributs de deplacement
     */
    public static final String HAUT = "haut";
    public static final String BAS = "bas";
    public static final String DROITE = "droite";
    public static final String GAUCHE = "gauche";

    /**
     * Attributs correspondant aux types des cases
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char SORTIE = 'S';
    public static final char VIDE = '.';

    /**
     * Attribut pour les murs du labyrinthe
     */
    boolean [][] murs;

    /**
     * Attribut pour le personnage dans le labyrinthe
     */
    Personnage personnage;

    /**
     * Attribut pour la sortie dans le labyrinthe
     */
    Sortie sortie;

    /**
     * Contructeur de labyrinthe initialisant les valeurs
     * a null pour chargerLabyrinthe
     */
    public Labyrinthe(){
        this.personnage =null;
        this.sortie = null;
        this.murs = null;
    }

    /**
     * Contructeur de labyrinthe initialisant les valeurs
     * aux parametres, pour les tests unitaires.
     * @param p Personnage
     * @param s Sortie
     * @param m Tableau de boolean representant les murs
     */
    public Labyrinthe(Personnage p, Sortie s, boolean[][] m){
        this.personnage = p;
        this.sortie = s;
        this.murs = m;
    }

    /**
     * Permet de savoir aux positions passées
     * en parametre quelle case elle represente
     * @param x Position x de la case
     * @param y Positon y de la case
     * @return Type de case : MUR ou PJ (personnage) ou SORTIE ou VIDE
     */
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

    /**
     * Permet de recuperer les coordonees de la prochaine
     * case par rapport a une autre avec une direction indiquee
     * @param x Position x de la case actuelle
     * @param y Position y de la case actuelle
     * @param action Direction vers laquelle on veut la case adjacente
     * @return Case adjacente a la case actuelle en fonction de la direction
     * @throws ActionInconnueException Direction pas reconnue (n'est pas un cote adjancent)
     */
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

    /**
     * Methode permettant de deplacer le
     * personnage dans une direction
     * @param action direction vers laquelle le personnage doit aller
     * @throws ActionInconnueException Action inconnue (direction invalide)
     */
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


    /**
     * Permet d'afficher le labyrinthe dans le bon format
     * @return le labyrinthe
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

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


    /**
     * Permet de savoir si le personnage est sur la sortie ou non.
     * @return Vrai s'il est dessus, faux sinon
     */
    public boolean etreFini()
    {
        return this.personnage.getX() == this.sortie.getX() && this.personnage.getY() == this.sortie.getY();
    }

    /**
     * Methode permettant de generer un labyrinthe a partir d'un fichier texte.
     * @param nom Nom du fichier contenent le labyrinthe
     * @return Un labyrinthe cree a partir du fichier
     * @throws IOException Probleme de lecture du fichier
     * @throws FichierIncorrectException Pas le bon format de fichier
     */
    public static Labyrinthe chargerLabyrinthe(String nom) throws IOException, FichierIncorrectException {
        BufferedReader br = new BufferedReader(new FileReader(nom));
        int x,y;

        // Verification des valeurs pour generer ensuite le tableau de boolean
        try{
            x = Integer.parseInt(br.readLine());
            y = Integer.parseInt(br.readLine());
        }
        catch (NumberFormatException e){
            throw new FichierIncorrectException("Format des nombres invalides !");
        }

        // Initialisation des variables pour la boucle
        Labyrinthe res = new Labyrinthe();
        res.murs = new boolean[x][y];
        String ligne = br.readLine();
        int posLigne = 0;

        // Parcours du fichier
        while (ligne != null){
            // S'il y a plus de ligne qu'attendu
            if (posLigne > res.murs.length-1)
                throw new FichierIncorrectException("Nombre de ligne trop grand !");

            // S'il y a trop ou pas assez de colonne
            if (ligne.length() > res.murs[0].length)
                throw new FichierIncorrectException("Nombre de colonnes trop grand !");
            else if (ligne.length() < res.murs[0].length)
                throw new FichierIncorrectException("Nombre de colonnes trop petit !");

            // Parcours de la ligne, caractere par caractere
            for (int posCol=0; posCol < ligne.length(); posCol++ ){
                char c = ligne.charAt(posCol);
                switch (c){
                    case Labyrinthe.MUR: //Cree un mur aux positions posLigne et posCol
                        res.murs[posLigne][posCol] = true;
                        break;
                    case Labyrinthe.SORTIE: // Cree une sortie s'il y en a pas, aux positions posLigne et posCol
                        res.murs[posLigne][posCol] = false;

                        // Verifie qu'il n'y a pas de sortie
                        if (res.sortie == null)
                            res.sortie = new Sortie(posLigne, posCol);
                        else
                            throw new FichierIncorrectException("plusieurs sorties");
                        break;
                    case Labyrinthe.VIDE: // Cree une place vide aux positions posLigne et posCol
                        res.murs[posLigne][posCol] = false;
                        break;
                    case Labyrinthe.PJ: // Cree un personnage s'il n'y en a pas, aux positions posLigne et posCol
                        res.murs[posLigne][posCol] = false;

                        // Verification qu'il n'y ait pas de personnage
                        if (res.personnage == null)
                            res.personnage = new Personnage(posLigne, posCol);
                        else
                            throw new FichierIncorrectException("Plusieurs personnages");
                        break;
                    default:
                        throw new FichierIncorrectException("Caractere inconnu "+ c);
                }
            }
            ligne = br.readLine();
            posLigne++;
        }
        // S'il n'y a pas assez de ligne
        if (posLigne < res.murs.length)
            throw new FichierIncorrectException("Nombre de ligne trop faible");

        // S'il n'y a pas de sortie
        if (res.sortie == null)
            throw new FichierIncorrectException("Sortie inconnue");

        // S'il n'y a pas de personnage
        if (res.personnage == null)
            throw new FichierIncorrectException("Personnage inconnu");

        return res;
    }

    /**
     * Permet de savoir si deux objets sont identiques
     * en fonction de leurs parametres.
     * @param obj Objet dont on veut verifier l'egalite.
     * @return Vrai si les objets sont egaux, faux sinon.
     */
    @Override
    public boolean equals(Object obj) {
        Labyrinthe laby = (Labyrinthe) obj;
        // verification personnage et sortie
        boolean bonPetS = this.personnage.equals(laby.personnage) && this.sortie.equals(laby.sortie);

        // verification taille tableau
        boolean bonnetaille = this.murs.length == laby.murs.length && this.murs[0].length == laby.murs[0].length;

        // verification tableau
        boolean memetab = false;

        if (bonnetaille){
            for(int i=0; i<this.murs.length; i++){

                for(int j=0; j<this.murs[0].length; j++){
                    memetab = this.murs[i][j] == laby.murs[i][j];
                }
                // sort de la boucle si jamais quelque chose n'est pas egal
                if (!memetab) break;
            }
        }

        return bonPetS && bonnetaille && memetab;
    }
}
