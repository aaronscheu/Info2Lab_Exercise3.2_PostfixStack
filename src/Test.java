/**
 * Created by amaridev on 08/12/15.
 * Package: PACKAGE_NAME for Exercise3.2_PostfixStack.
 */
public class Test {

    public Test() {
        testInfix("1 * 2 + 3", 5);
        testInfix("1 + 2 * 3", 7);
        testInfix("1 + 2 - 3^4", -78);
        testInfix("1^2 - 3 * 4", -11);
        testInfix("1 + 2 * 3 - 4^5 + 6", -1011);
        testInfix("(1 + 2) * 3 + (4 ^ ( 5 - 6 ))", 9);
        testInfix("1 + 2 + 3 / 4 + 5 + 6 * (7 + 8)", 98);
        testInfix("9 - 1 - 2 - 3 * 2 - 1", -1);
    }

    public void testInfix(String string, int expected) {
        Postfix postfix = new Postfix();
        System.out.printf("---------------------\n");
        System.out.printf("Infix:   %s\n", string);
        System.out.printf("Postfix: %s\n", postfix.in2Postfix(string));
        System.out.printf("Erg.:    %s\n", postfix.evaluate(postfix.in2Postfix(string)));
        System.out.printf("Exp.:    %s\n", expected);
        System.out.printf("---------------------\n");
    }

}
