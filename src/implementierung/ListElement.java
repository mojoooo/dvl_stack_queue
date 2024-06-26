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
        }
        else
        {
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
    
    public void deletePredecessor()
    {
        this.predecessor = null;
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

    public void deleteSuccessor()
    {
        this.successor = null;
    }

    public ListElement(IValueElement valueElement)
    {
        this.setValueElement(valueElement);
    }

    public ListElement(IListElement listElement)
    {
        this.setValueElement(listElement.getValueElement());
        this.setPredecessor(listElement.getPredecessor());
        this.setSuccessor(listElement.getSuccessor());
    }

    public String toString()
    {
        return this.getValueElement().toString();
    }
}
