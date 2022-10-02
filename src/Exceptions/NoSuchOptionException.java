package Exceptions;
// wyjatek kontrolowany
public class NoSuchOptionException extends Exception{
    public NoSuchOptionException(String message) {
        super(message);
    }
}
