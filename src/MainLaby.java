import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainLaby
{
    public static void main(String[] args)
    {
        String commande= "";
        Labyrinthe laby;
        try {
            laby = Labyrinthe.chargerLabyrinthe(args[0]);
        } catch (FileNotFoundException e){
            System.out.println("Nom du fichier inexistant");
        } catch (IOException e){
            System.out.println("Probleme a la lecture du fichier");
        } catch (FichierIncorrectException e){
            System.out.println(e);
        }

        while (commande != "exit")
        {
            System.out.println(laby);
            System.out.println();
        }





    }
}
