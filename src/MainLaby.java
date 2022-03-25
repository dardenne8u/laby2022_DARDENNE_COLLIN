import java.io.FileInputStream;
import java.io.IOException;

public class MainLaby
{
    public static void main(String[] args)
    {
        String commande= "";
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe(args[0]);
        while (commande != "exit")
        {
            System.out.println(laby);
            System.out.println();
        }





    }
}
