public class FichierIncorrectException extends Exception{

    /**
     * Exception pour le format du fichier
     * @param message Cause de l'exception
     */
    public FichierIncorrectException(String message){
        super(message);
    }
}
