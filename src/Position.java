public class Position {
    /**
     * Parametre de positon x
     */
    private int x;
    /**
     * Parametre de position y
     */
    private int y;

    /**
     * Cree une postion avec les valeurs en parametre
     * @param x valeur pour la position x
     * @param y valeur pour la position y
     */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Recupere la valeur x
     * @return la postion x
     */
    public int getX() {
        return x;
    }

    /**
     * Recupere la valeur y
     * @return la postion y
     */
    public int getY() {
        return y;
    }

    /**
     * Modifie la valeur x
     * @param x Valeur a echange avec celle actuelle
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Modifie la valeur y
     * @param y Valeur a echange avec celle actuelle
     */
    public void setY(int y) {
        this.y = y;
    }
}
