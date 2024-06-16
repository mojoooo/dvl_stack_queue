package implementierung;

import schnittstellen.*;

public class List implements IList
{
	private IListElement head = new ListElement(new ValueElement());
	
	public IListElement getHead()
	{
		return this.head;
	}
	
	public void setHead(IListElement head)
	{
		if (head != null)
		{
			this.head = head;
		}
	}
	
	public void insertAtTheEnd(IValueElement value)
	{
		if (value != null)
		{
			this.getHead().setSuccessor(new ListElement(value, null, null));
		} else {
			this.getHead().setSuccessor(new ListElement(new ValueElement(), this.getHead(), null));
		}
	}
	
	public void insertAtPos(int pos, IValueElement value)
	{
		
	}
	
	public IValueElement getElementAt(int position)
	{
		return null;
	}
	
	public int getFirstPosOf(IValueElement value)
	{
		return 0;
	}
	
	public void deleteFirstOf(IValueElement value)
	{
		
	}
	
	public void deleteAllOf(IValueElement value)
	{
		
	}
	
	public boolean member(IValueElement value)
	{
		return false;
	}
	
	public void reverse()
	{
		
	}
	
	public List()
	{
		
	}
	
	public String toString()
	{
		return this.getHead().toString();
	}
}
