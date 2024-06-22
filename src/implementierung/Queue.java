package implementierung;

import schnittstellen.*;

public class Queue implements IQueue
{
	private final static int MAX_CAPACITY = 7;
	
	private IList dvl;
	
	public IList getDVL()
	{
		return this.dvl;
	}
	
	public void setDVL(IList list)
	{
		this.dvl = list;
	}
	
	public int getSize()
	{
		List list = (List) this.getDVL();
		
		return list.countElementsRecursive(list.getHead());
	}
	
	public boolean isEmpty()
	{
		List list = (List) this.getDVL();
		
		return list.countElementsRecursive(list.getHead()) == 0;
	}
	
	public boolean isFull()
	{
		List list = (List) this.getDVL();
		
		return list.countElementsRecursive(list.getHead()) >= Queue.MAX_CAPACITY;
	}
	
	public int dequeue()
	{
		if (this.isEmpty())
		{
			return -1;
		}

		List list = (List) this.getDVL();
		
		int value = list.getElementAt(list.countElementsRecursive(list.getHead())).getValue();
		list.deleteElementAt(this.getSize());		
		
		return value;
	}
	
	public void enqueue(int value)
	{
		if (!this.isFull() && value >= 0)
		{
			ValueElement newElement = new ValueElement("QueueElement", value);
			this.getDVL().insertAtPos(0, newElement);
		}
	}
	
	public int front()
	{
		if (this.isEmpty())
		{
			return -1;
		}

		List list = (List) this.getDVL();
		
		return list.getElementAt(list.countElementsRecursive(list.getHead())).getValue();
	}
	
	public Queue()
	{
		List newList = new List();
		this.setDVL(newList);
	}
}
