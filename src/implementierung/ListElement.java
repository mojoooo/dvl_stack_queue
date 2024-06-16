package implementierung;

import schnittstellen.*;

public class ListElement implements IListElement
{
	private IValueElement valueElement;
	private IListElement predecessor;
	private IListElement successor;
	
	public IValueElement getValueElement()
	{
		return this.valueElement;
	}
	
	public void setValueElement(IValueElement value)
	{
		if (value != null)
		{
			this.valueElement = value;
		} else {
			this.valueElement = new ValueElement();
		}
	}
	
	public IListElement getPredecessor()
	{
		return this.predecessor;
	}
	
	public void setPredecessor(IListElement predecessor)
	{
		if (predecessor != null)
		{
			this.predecessor = predecessor;
		}
	}
	
	public IListElement getSuccessor()
	{
		return this.successor;
	}
	
	public void setSuccessor(IListElement successor)
	{
		if (successor != null)
		{
			this.successor = successor;
		}
	}
	
	public ListElement(IValueElement valueElement)
	{
		this.setValueElement(valueElement);
	}
	
	public String toString()
	{
		String previousElement = this.getPredecessor() != null ? this.getPredecessor().getValueElement().toString() : "Leer";
		String nextElement = this.getSuccessor() != null ? this.getSuccessor().getValueElement().toString() : "Leer";
		
		return (
					"currentElement: " + this.getValueElement().toString() + "\n" +
					"previousElement: " + previousElement + "\n" +
					"nextElement: " + nextElement 
				);
	}
}
