import java.util.EmptyStackException;
import java.util.Stack;

public class ArrayQueue<T> {
    private Object[] elements;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        elements[rear] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = (T) elements[front];
        elements[front] = null;
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return (T) elements[front];
    }

    public int size() {
        return size;
    }

    /** Método que invierte la cola actual usando un Stack auxiliar */
    public void reverse() {
        Stack<T> stack = new Stack<>();

        // Paso 1: Vaciar la cola al stack
        while (!isEmpty()) {
            stack.push(dequeue());
        }

        // Paso 2: Pasar de vuelta del stack a la cola (invirtiendo el orden)
        while (!stack.isEmpty()) {
            enqueue(stack.pop());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int index = front;
        for (int i = 0; i < size; i++) {
            sb.append(elements[index]);
            if (i < size - 1) sb.append(", ");
            index = (index + 1) % capacity;
        }
        sb.append("]");
        return sb.toString();
    }
}