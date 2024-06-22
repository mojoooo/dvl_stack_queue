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
		ValueElement v1_2 = new ValueElement("eins", 1);
		
		list.insertAtTheEnd(v1);
		list.insertAtTheEnd(v2);
		list.insertAtTheEnd(v3);
		list.insertAtTheEnd(v1);
		list.insertAtPos(2, v3);
		list.insertAtPos(2, v4);
		
		Stack stack = new Stack(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		
		System.out.println(stack.getDVL());	
		System.out.println(stack.pop());
		System.out.println(stack.top());
	}
}
