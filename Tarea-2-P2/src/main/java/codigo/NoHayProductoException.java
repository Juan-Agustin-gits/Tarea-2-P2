package codigo;

public class NoHayProductoException extends Exception{
    public NoHayProductoException(String mensaje){
        super(mensaje);
    }
}