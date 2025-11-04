public class Main {
    public static void main(String[] args) {
        ArrayQueue<Customer> queue = new ArrayQueue<>(10);

        // Agregamos varios clientes
        queue.enqueue(new Customer(1, "Ana"));
        queue.enqueue(new Customer(2, "Luis"));
        queue.enqueue(new Customer(3, "Maya"));
        queue.enqueue(new Customer(4, "Carlos"));
        queue.enqueue(new Customer(5, "Lucía"));

        System.out.println("Antes de invertir:");
        System.out.println(queue);

        int elementosAntes = queue.size();

        queue.reverse();

        System.out.println("Después de invertir:");
        System.out.println(queue);

        int elementosDespues = queue.size();

        System.out.println("Elementos antes = " + elementosAntes +
                ", elementos después = " + elementosDespues);
    }
}