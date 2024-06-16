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
		
		list.insertAtTheEnd(v1);
		list.insertAtTheEnd(v2);
		list.insertAtTheEnd(v5);
		
		list.insertAtPos(3, v3);
		
		System.out.println(list.countElementsRecursive(list.getHead()));
		
		System.out.println(list);
	}
}
