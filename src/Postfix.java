import org.jetbrains.annotations.Contract;

/**
 * Created by amaridev on 05/12/15.
 * Package: PACKAGE_NAME for Exercise3.2_PostfixStack.
 */
public class Postfix {

    public Postfix() {
    }

    public int evaluate(String pfx) {
        return 0;
    }

    public String in2Postfix(String expression) {
        Stack<Character> stack = new Stack<>();
        String output = "";

        for (char c : expression.toCharArray()) {
            if(c == ' ' || c == ',') continue;

            else if(isOperator(c)) {
                while(!stack.isEmpty() && isLowPrio(stack.top(), c)) {
                    output += stack.pop();
                }
                stack.push(c);
            }

            // Else if character is an operand
            else if(isOperand(c)) output += c;

            else if (c == '(') stack.push(c);

            else if(c == ')') {
                while(!stack.isEmpty() && stack.top() != '(') output += stack.pop();
                stack.pop();
            }
            //output += stack.pop();
        }

        return output;
    }

    @Contract(pure = true)
    private boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/') ;
    }

    @Contract(pure = true)
    private boolean isOperand(char c) {
        return (c >= '0' && c <= '9');
    }

    @Contract(pure = true)
    private int getOperatorWeight(char op) {
        switch(op) {
            case '(': return 0;
            case '+': return 1;
            case '-': return 1;
            case '*': return 2;
            case '/': return 2;
            case '^': return 3;
            default: return -1;
        }
    }

    private boolean isLowPrio(char op1, char op2) {
        int op1w = getOperatorWeight(op1);
        int op2w = getOperatorWeight(op2);

        return op1w == op2w || op1w > op2w;
    }

    public static void main(String[] args) {
        String test = "2 * 3 + 5";
        Postfix postfix = new Postfix();
        System.out.printf("%s", postfix.in2Postfix(test));
    }
}
