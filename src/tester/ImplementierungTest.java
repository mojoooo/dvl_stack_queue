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
		
		list.insertAtTheEnd(v1);
		list.insertAtTheEnd(v2);
		
		System.out.println(list);
	}
}
