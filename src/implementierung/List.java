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
			listElement = new ListElement(new ValueElement("Placeholder", 0));
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
				this.getRoot().getPredecessor().setSuccessor(newElement);
			} else if (pos > this.countElementsRecursive(this.getHead())) {
				this.insertAtTheEnd(value);
			} else {
				IListElement previousElement = this.getListElementAt(pos - 1);
				IListElement nextElement = this.getListElementAt(pos);
				
				newElement.setPredecessor(this.getListElementAt(pos).getPredecessor());
				newElement.setSuccessor(this.getListElementAt(pos));
				previousElement.setSuccessor(newElement);
				nextElement.setPredecessor(newElement);
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
	
	public IListElement getListElementAt(int pos)
	{		
		return getListElementAtRecursive(this.getRoot(), pos);
	}
	
	public IListElement getListElementAtRecursive(IListElement listElement, int pos)
	{
		if (pos == 0)
		{
			return listElement;
		}
		
        return getListElementAtRecursive(listElement.getSuccessor(), pos - 1);
    }
	
	public IValueElement getElementAt(int pos)
	{
		if (pos == 0)
		{
			return null;
		} else if (pos > this.countElementsRecursive(this.getHead())) {
			return this.getRoot().getPredecessor().getValueElement();
		}
		
		
		return getElementAtRecursive(this.getRoot(), pos).getValueElement();
	}
	
	public IListElement getElementAtRecursive(IListElement listElement, int pos)
	{
		if (pos == 0)
		{
			return listElement;
		}
		
		return getElementAtRecursive(listElement.getSuccessor(), pos - 1);
	}
	
	public int getFirstPosOf(IValueElement value)
	{
		return getFirstPosOfRecursive(this.getRoot(), value);
	}
	
	public int getFirstPosOfRecursive(IListElement listElement, IValueElement value)
	{
		if (listElement.getValueElement() == value)
		{
			return 0;
		}
		
		return 1 + getFirstPosOfRecursive(listElement.getSuccessor(), value);
	}
	
	public void deleteFirstOf(IValueElement value)
	{
		IListElement elementToDelete = this.findElementByValue(this.getRoot(), value);
		
		if (elementToDelete != null)
		{
			elementToDelete.getPredecessor().setSuccessor(elementToDelete.getSuccessor());
			elementToDelete.getSuccessor().setPredecessor(elementToDelete.getPredecessor());
		}
	}
	
	public IListElement findElementByValue(IListElement listElement, IValueElement value)
	{
		if (listElement.getValueElement() == value)
		{
			return listElement;
		}

		if (listElement.getSuccessor() == this.getRoot())
		{
			return null;
		}
		
		return findElementByValue(listElement.getSuccessor(), value);
	}
	
	public void deleteAllOf(IValueElement value)
	{
		while (this.findElementByValue(this.getRoot(), value) != null)
		{
			this.deleteFirstOf(value);
		}
	}
	
	public boolean member(IValueElement value)
	{
		if (this.findElementByValue(this.getRoot(), value) != null)
		{
			return true;
		}

		return false;
	}
	
	public void reverse()
	{	
		this.swapPredecessorAndSuccessor(this.getRoot());
	}

	public void swapPredecessorAndSuccessor(IListElement listElement)
	{		
		if (listElement.getSuccessor() != this.getRoot())
		{		
			swapPredecessorAndSuccessor(listElement.getSuccessor());
			IListElement tempElement = listElement.getPredecessor();
			listElement.setPredecessor(listElement.getSuccessor());
			listElement.setSuccessor(tempElement);
		}
	}
	
	public List() { }
	
	public String toString()
	{
		return printAllListElements(this.getRoot().getSuccessor());
	}
	
	public String printAllListElements(IListElement listElement)
	{
		if (listElement.getValueElement().getName() == "Dummy")
		{
			return "";
		}
		
		return listElement.getValueElement() + this.printAllListElements(listElement.getSuccessor());
	}
}
