/**
 * Created by amaridev on 27/11/15.
 * Package: PACKAGE_NAME for Exercise3.2_.
 */

public class Stack<Item> {

    private LinkedList<Item> stack;

    public Stack() {
        this.stack = new LinkedList<>();
    }

    public Item pop() {
        try {
            return stack.remove();
        } catch (StackUnderflowException e) {
            System.out.printf("%s\n", e.getMessage());
        }
        return null;
    }

    public void push(Item data) {
        stack.add(data);
    }

    public Item top() {
        return stack.getLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}