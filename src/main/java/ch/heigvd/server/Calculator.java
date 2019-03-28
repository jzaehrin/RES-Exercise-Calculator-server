package ch.heigvd.server;

import java.util.Stack;

public class Calculator {
    private Stack<Double> stack;
    private Operation[] operations;

    public Calculator(Operation[] operations) {
        this.operations = operations;
        this.stack = new Stack<Double>();
    }

    public String execute(String request) {
        request = request.substring(request.indexOf('\t') + 1);

        for(String arg : request.split("\t")) {
            if(arg.contains("OP")) {
                arg = arg.substring(2);

                Operation op = Operation.getOperation(arg);

                if(op == null) {
                    stack.clear();

                    return ErrorMessage.getErrorMessage("UNKNOWN operation");
                }

                stack.push(op.operate(stack));
            } else {
                try {
                    stack.push(Double.parseDouble(arg));
                } catch (NumberFormatException e) {
                    stack.clear();

                    return ErrorMessage.getErrorMessage("ERROR parsing number");
                }
            }
        }

        return SuccessMessage.getSuccessMessage(stack.pop().toString());
    }
}
