public class Sortie extends Position
{
    //Constructors
    public Sortie ()
    {
        super(0,0);
    }

    public Sortie (int xp, int yp)
    {
        super(xp,yp);
    }

    //Methods

    @Override
    public boolean equals(Object obj) {
        Sortie s = (Sortie) obj;
        return this.getX() == s.getX() && this.getY() == s.getY();
    }
}
