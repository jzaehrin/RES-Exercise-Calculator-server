package ch.heigvd.server;

public class HelloMessage {
    private Operation[] operations;

    public HelloMessage(Operation[] operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "HELLO\t" + buildOperation() + '\n';
    }

    private String buildOperation() {
        StringBuilder sb = new StringBuilder();

        for(Operation o : operations) {
            sb.append(o.getName());
            sb.append('\t');
        }

        sb.deleteCharAt(sb.length() -1);

        return sb.toString();
    }
}
