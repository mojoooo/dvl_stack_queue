package implementierung;

import schnittstellen.*;

public class List implements IList
{
	private IListElement head = new ListElement(new ValueElement());
	private final IListElement root = head;
	
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
	
	public IListElement getRoot()
	{
		return this.root;
	}
	
	public void insertAtTheEnd(IValueElement value)
	{
		IListElement listElement;
		
		if (value != null)
		{
			listElement = new ListElement(value);
		} else {
			listElement = new ListElement(new ValueElement());
		}
		
		this.getHead().setSuccessor(listElement);
		listElement.setPredecessor(this.getHead());
		listElement.setSuccessor(this.getRoot());
		
		this.getRoot().setPredecessor(listElement);
		
		this.setHead(listElement);
	}
	
	public void insertAtPos(int pos, IValueElement value)
	{
		if (value != null)
		{
			ListElement newElement = new ListElement(value);

			if (pos <= 1)
			{
				newElement.setPredecessor(this.getRoot());
				newElement.setSuccessor(this.getRoot().getSuccessor());
				this.getRoot().getSuccessor().setPredecessor(newElement);
				this.getRoot().setSuccessor(newElement);
			} else if (pos > this.countElementsRecursive(this.getHead())) {
				this.insertAtTheEnd(value);
			} else {
				System.out.println("Element at pos " + pos + ": " + this.getElementAtt(pos).getValueElement().toString());
				/*
				newElement.setPredecessor(this.getElementAtt(pos));
				newElement.setSuccessor(this.getElementAtt(pos).getSuccessor());
				this.getElementAtt(pos).getSuccessor().setPredecessor(newElement);
				this.getElementAtt(pos).setSuccessor(newElement);
				*/
			}
		}
	}
	
	public int countElementsRecursive(IListElement listElement)
	{
        if (listElement.getValueElement().getName() == "Dummy")
        {	
            return 0;
        }

        return (1 + countElementsRecursive(listElement.getPredecessor()));
    }
	
	/**
	 * @TODO
	 * correct the methods below
	 * 
	 * getElementAtt gets stackoverflow error
	 * 
	 * why is the predefined method getElementAt of return type iValueElement? IListElement would make more sense to me
	 * 
	 */
	
	public IListElement getElementAtt(int pos)
	{
		return getElementAtRecursive(this.getRoot(), pos);
	}
	
	public IListElement getElementAtRecursive(IListElement listElement, int pos)
	{
        return getElementAtRecursive(listElement.getSuccessor(), (pos - 1));
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
