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

            while (!commande.equals("exit"))
            {
                System.out.println(laby);
                System.out.print("Entrer une action :\n- Deplacer le personnage : haut / bas / gauche / droite\n- Quitter : exit\n>> ");
                commande = sc.nextLine();

                try{
                    if (!commande.equals("exit"))
                        laby.deplacerPerso(commande);
                }
                catch (ActionInconnueException e)
                {
                    System.out.println("Commande inconnue\n");
                }

                if (laby.etreFini())
                {
                    commande = "exit";
                    System.out.println(laby);
                    System.out.println("Vous avez gagne !");
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
