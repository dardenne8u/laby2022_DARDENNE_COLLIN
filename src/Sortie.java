public class Sortie extends Position
{
    /**
     * Construit une sortie au postion passee en parametre
     * @param xp position x de la sortie
     * @param yp position y de la sortie
     */
    public Sortie (int xp, int yp)
    {
        super(xp,yp);
    }

    /**
     * Permet de voir si deux sorties sont egales (meme position)
     * @param obj Sortie dont on veut verifie l'egalite
     * @return Vrai s'il sont egaux sinon faux
     */
    @Override
    public boolean equals(Object obj) {
        Sortie s = (Sortie) obj;
        return this.getX() == s.getX() && this.getY() == s.getY();
    }
}
