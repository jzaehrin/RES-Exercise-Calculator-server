package ch.heigvd.server;

public enum Operation {
    ADD("add"),
    SUB("sub"),
    MUlTIPLY("multi");

    Operation(String name) {
        this.name = name;
    }

    public Double operate(Double op1, Double op2) {
        switch (this) {
            case ADD:
                return op1 + op2;
            case SUB:
                return op1 - op2;
            case MUlTIPLY:
                return op1 * op2;
        }

        return Double.NaN;
    }

    static public Operation getOperation(String name) {
        if(name.equals("add"))
            return Operation.ADD;
        else if(name.equals("sub"))
            return Operation.SUB;
        else if(name.equals("multi"))
            return Operation.MUlTIPLY;

        return null;
    }

    public String getName() {
        return name;
    }

    private String name;
}
