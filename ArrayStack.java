import java.util.EmptyStackException;

/**
 * @author Tobias Lauer
 */
public class ArrayStack implements StringStack {

    private String[] elements;
    private int currentSize;

    public ArrayStack(int capacity) {
        elements = new String[capacity];
        currentSize = 0;
    }

    @Override
    public void push(String element) {
        if (element != null) {
            // Handle full stack
            if (currentSize == elements.length) {
                // Move elements to left
                for (int i=0; i<elements.length-1; i++) {
                    elements[i] = elements[i+1];
                }
                // Delete last element
                elements[elements.length-1] = null;
                currentSize--;
            }
            // Insert element at corrent position and increase currentSize (afterwards)
            elements[currentSize++] = element;
        }

    }

    @Override
    public String top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return elements[currentSize-1];
        }
    }

    @Override
    public String pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            String result = top();
            elements[--currentSize] = null;
            return result;
        }
    }

    @Override
    public boolean isEmpty() {
        return (currentSize == 0);
    }
    
}
