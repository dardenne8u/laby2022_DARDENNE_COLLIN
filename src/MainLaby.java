import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainLaby
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String commande= "";
        Labyrinthe laby = null;
        try {
            laby = Labyrinthe.chargerLabyrinthe(args[0]);

            while (!commande.equals("exit") || !laby.etreFini())
            {
                System.out.println(laby);
                System.out.print("\nEntrer une action :\n- exit\n- haut\n- bas\n- gauche\n- droite\n>> ");
                commande = sc.nextLine();

                try{
                    if (!commande.equals("exit"))
                        laby.deplacerPerso(commande);
                }
                catch (ActionInconnueException e)
                {
                    System.out.println("Commande inconnue\n");
                }


            }
            
        } catch (FileNotFoundException e){
            System.out.println("Nom du fichier inexistant");
        } catch (IOException e){
            System.out.println("Probleme a la lecture du fichier");
        } catch (FichierIncorrectException e){
            System.out.println(e);
        }







    }
}
