package ch.heigvd.server;

import java.util.Stack;

public enum Operation {
    ADD("add"),
    SUB("sub"),
    MUlTIPLY("multi"),
    DIVIDE("div"),
    SQRT("sqrt"),
    ROOT("root");

    Operation(String name) {
        this.name = name;
    }

    public Double operate(Stack<Double> stack) {
        Double op1;
        Double op2;

        switch (this) {
            case ADD:
                op1 = stack.pop();
                op2 = stack.pop();

                return op1 + op2;
            case SUB:
                op1 = stack.pop();
                op2 = stack.pop();

                return op2 - op1;
            case MUlTIPLY:
                op1 = stack.pop();
                op2 = stack.pop();

                return op1 * op2;

            case DIVIDE:
                op1 = stack.pop();
                op2 = stack.pop();

                return op1 / op2;

            case SQRT:
                op1 = stack.pop();

                return Math.sqrt(op1);

            case ROOT:
                op1 = stack.pop();
                op2 = stack.pop();

                return  Math.pow(Math.E, Math.log(op1)/op2);
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
        else if(name.equals("div"))
            return Operation.DIVIDE;
        else if(name.equals("sqrt"))
            return Operation.SQRT;
        else if(name.equals("root"))
            return Operation.ROOT;

        return null;
    }

    public String getName() {
        return name;
    }

    private String name;
}
