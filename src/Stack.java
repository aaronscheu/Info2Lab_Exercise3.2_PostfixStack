/**
 * Created by amaridev on 27/11/15.
 * Package: PACKAGE_NAME for Exercise3.2_.
 */

public class Stack<Item> {

    private LinkedList<Item> stack;

    public Stack() {
        this.stack = new LinkedList();
    }

    public Item pop() {
        return stack.remove();
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
}