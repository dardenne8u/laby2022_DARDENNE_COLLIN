public class Personnage extends Position{

    /**
     * Cree un personnage aux positons passee en parametre
     * @param x Position x du personnage
     * @param y Position y du personnage
     */
    public Personnage(int x, int y){
        super(x, y);
    }

    /**
     * Permet de savoir si deux personnages sont egaux
     * @param obj Personnage dont on veut verifier l'egalite
     * @return Vrai s'ils sont egaux sinon faux
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        Personnage p = (Personnage) obj;
        return this.getX() == p.getX() && this.getY() == p.getY();
    }
}
