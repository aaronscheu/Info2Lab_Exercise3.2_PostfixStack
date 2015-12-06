/**
 * Created by amaridev on 06/12/15.
 * Package: PACKAGE_NAME for Exercise3.2_PostfixStack.
 */
public class StackUnderflowException extends Exception {

    public void printStackTrace(){
        System.out.println("Stack is empty!");
    }
}
