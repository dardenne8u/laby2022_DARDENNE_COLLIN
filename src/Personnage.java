public class Personnage extends Position{

    public Personnage(int x, int y){
        super(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        Personnage p = (Personnage) obj;
        return this.getX() == p.getX() && this.getY() == p.getY();
    }
}
