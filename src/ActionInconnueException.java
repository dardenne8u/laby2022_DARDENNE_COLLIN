public class ActionInconnueException extends Exception{

    /**
     * Exception qu'est lancee lorsque l'on ne reconnait pas l'action demander
     * @param msg Message pour l'exception
     */
    public ActionInconnueException(String msg){
        super(msg);
    }
}
