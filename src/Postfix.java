import org.jetbrains.annotations.Contract;

/**
 * Created by amaridev on 05/12/15.
 * Package: PACKAGE_NAME for Exercise3.2_PostfixStack.
 */
public class Postfix {

    public int evaluate(String pfx) {
        return 0;
    }

    private String in2Postfix(String expression) {
        Stack<Character> stack = new Stack<>();
        String output = "";

        for (char c : expression.toCharArray())
        {
            if(c == ' ' || c == ',') continue;
            else if(isOperator(c)) {
                while(!stack.isEmpty() && stack.top() != '(' && HasHigherPrecedence(stack.top(), c))
                {
                    output += stack.pop();
                }
                stack.push(c);
            }

            // Else if character is an operand
            else if(isOperand(c)) {
                output += c;
            }

            else if (c == '(') {
                stack.push(c);
            }

            else if(c == ')') {
                while(!stack.isEmpty() && stack.top() !=  '(') {
                    output += stack.pop();
                }
                stack.pop();
            }
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
            case '+': return -1;
            case '-': return  1;
            case '*': return -1;
            case '/': return  2;
            default: return  -1;
        }
    }

    int HasHigherPrecedence(char op1, char op2)
    {
        int op1Weight = GetOperatorWeight(op1);
        int op2Weight = GetOperatorWeight(op2);

        // If operators have equal precedence, return true if they are left associative.
        // return false, if right associative.
        // if operator is left-associative, left one should be given priority.
        if(op1Weight == op2Weight)
        {
            if(IsRightAssociative(op1)) return false;
            else return true;
        }
        return op1Weight > op2Weight ?  true: false;
    }

    public static void main(String[] args) {
        LinkedList<String> test = new LinkedList<>();
        test.add("eins");
        test.add("zwei");
        test.add("eins");
        test.add("zwei");

        System.out.printf("%s\n", test.toString());
        System.out.printf("%d", test.getSize());
    }
}
