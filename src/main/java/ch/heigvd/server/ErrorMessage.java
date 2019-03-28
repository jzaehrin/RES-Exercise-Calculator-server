package ch.heigvd.server;

public class ErrorMessage {
    static String getErrorMessage(String message) {
        return "NACK\t" + message + '\n';
    }
}
