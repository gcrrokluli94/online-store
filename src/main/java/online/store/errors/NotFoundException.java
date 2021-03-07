package online.store.errors;

public class NotFoundException extends RuntimeException{
    public NotFoundException(final String message){
        super(message);
    }
}
