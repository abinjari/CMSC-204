/*
 * Class: CMSC204
 * Instructor: Prof. Khandan Monshi
 * Description: (Give a brief description for each Class)
 * Due: 2/27/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Aditya Raj Binjariya 
*/
public class Notation {

    public Notation() {
        // Default constructor (not needed but kept for structure)
    }

    /**
     * Converts an infix expression to a postfix expression.
     *
     * @param infix The infix expression as a string.
     * @return The corresponding postfix expression as a string.
     * @throws InvalidNotationFormatException If the notation format is incorrect.
     */
    public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
        MyQueue<Character> postfixQueue = new MyQueue<>();
        MyStack<Character> operatorStack = new MyStack<>();

        for (int i = 0; i < infix.length(); i++) {
            char symbol = infix.charAt(i);

            if (Character.isWhitespace(symbol)) {
                continue;
            }

            if (Character.isDigit(symbol)) {
                postfixQueue.enqueue(symbol);
            } else if (symbol == '(') {
                operatorStack.push(symbol);
            } else if (symbol == '+' || symbol == '-') {
                while (!operatorStack.isEmpty() && (operatorStack.top() == '+' || operatorStack.top() == '-' ||
                        operatorStack.top() == '*' || operatorStack.top() == '/')) {
                    postfixQueue.enqueue(operatorStack.pop());
                }
                operatorStack.push(symbol);
            } else if (symbol == '*' || symbol == '/') {
                while (!operatorStack.isEmpty() && (operatorStack.top() == '*' || operatorStack.top() == '/')) {
                    postfixQueue.enqueue(operatorStack.pop());
                }
                operatorStack.push(symbol);
            } else if (symbol == ')') {
                while (!operatorStack.isEmpty() && operatorStack.top() != '(') {
                    postfixQueue.enqueue(operatorStack.pop());

                    if (operatorStack.isEmpty()) {
                        throw new InvalidNotationFormatException();
                    }
                }
                if (!operatorStack.isEmpty() && operatorStack.top() == '(') {
                    operatorStack.pop();
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            postfixQueue.enqueue(operatorStack.pop());
        }

        return postfixQueue.toString("");
    }

    /**
     * Converts a postfix expression to an infix expression.
     *
     * @param postfix The postfix expression as a string.
     * @return The corresponding infix expression as a string.
     * @throws InvalidNotationFormatException If the notation format is incorrect.
     */
    public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
        MyStack<String> expressionStack = new MyStack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char symbol = postfix.charAt(i);

            if (Character.isWhitespace(symbol)) {
                continue;
            }

            if (Character.isDigit(symbol)) {
                expressionStack.push(Character.toString(symbol));
            } else if (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/') {
                if (expressionStack.size() < 2) {
                    throw new InvalidNotationFormatException();
                }

                String rightOperand = expressionStack.pop();
                String leftOperand = expressionStack.pop();
                String newExpression = "(" + leftOperand + symbol + rightOperand + ")";
                expressionStack.push(newExpression);
            }
        }

        if (expressionStack.size() > 1) {
            throw new InvalidNotationFormatException();
        }

        return expressionStack.top();
    }

    /**
     * Evaluates a postfix expression and returns the result.
     *
     * @param postfixExpr The postfix expression as a string.
     * @return The evaluated result as a double.
     * @throws InvalidNotationFormatException If the notation format is incorrect.
     */
    public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
        MyStack<String> evaluationStack = new MyStack<>();

        for (int i = 0; i < postfixExpr.length(); i++) {
            char symbol = postfixExpr.charAt(i);

            if (Character.isWhitespace(symbol)) {
                continue;
            }

            if (Character.isDigit(symbol)) {
                evaluationStack.push(Character.toString(symbol));
            } else if (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/') {
                if (evaluationStack.size() < 2) {
                    throw new InvalidNotationFormatException();
                }

                int operand2 = Integer.parseInt(evaluationStack.pop());
                int operand1 = Integer.parseInt(evaluationStack.pop());
                int result;

                switch (symbol) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                    default:
                        result = operand1 + operand2;
                        break;
                }

                evaluationStack.push(Integer.toString(result));
            }
        }

        if (evaluationStack.size() > 1) {
            throw new InvalidNotationFormatException();
        }

        return Double.parseDouble(evaluationStack.pop());
    }
}

