import java.util.EmptyStackException;

public interface StringStack {

    void push(String element);

    String pop() throws EmptyStackException;

    String top() throws EmptyStackException;

    boolean isEmpty();
}
