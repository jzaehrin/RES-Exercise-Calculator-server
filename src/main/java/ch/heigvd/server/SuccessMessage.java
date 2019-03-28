package ch.heigvd.server;

public class SuccessMessage {
    static String getSuccessMessage(String message) {
        return "ACK\t" + message + '\n';
    }
}
