package tester;

import implementierung.*;

public class ImplementierungTest
{
    public static void main(String[] args)
    {
        List list = new List();

        ValueElement v1 = new ValueElement("eins", 1);
        ValueElement v2 = new ValueElement("zwei", 2);
        ValueElement v3 = new ValueElement("drei", 3);
        ValueElement v4 = new ValueElement("vier", 4);
        ValueElement v5 = new ValueElement("fünf", 5);
        ValueElement v6 = new ValueElement("sechs", 6);

        list.insertAtTheEnd(v1);
        list.insertAtTheEnd(v2);
        list.insertAtTheEnd(v3);
        list.insertAtTheEnd(v4);

        Stack stack = new Stack();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        Queue queue = new Queue();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);

        System.out.println();
    }
}
