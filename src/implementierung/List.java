package implementierung;

import schnittstellen.*;

public class List implements IList
{
    private IListElement head = new ListElement(new ValueElement());

    public IListElement getHead()
    {
        return this.head;
    }

    public void insertAtTheEnd(IValueElement value)
    {
        IListElement listElement;

        if (value != null)
        {
            listElement = new ListElement(value);
        }
        else
        {
            listElement = new ListElement(new ValueElement());
        }

        if (this.getHead().getSuccessor() != null)
        {
            listElement.setPredecessor(this.getHead().getPredecessor());

            this.getHead().setPredecessor(listElement);
            listElement.getPredecessor().setSuccessor(listElement);
        }
        else
        {
            this.getHead().setSuccessor(listElement);
            this.getHead().setPredecessor(listElement);

            listElement.setPredecessor(this.getHead());
        }
    }

    public void insertAtPos(int pos, IValueElement value)
    {
        if (value == null)
        {
            value = new ValueElement("unnamed", 0);
        }
        
        ListElement newElement = new ListElement(value);

        if (pos <= 1)
        {
            newElement.setPredecessor(this.getHead());

            if (this.getHead().getSuccessor() != null)
            {
                newElement.setSuccessor(this.getHead().getSuccessor());
                newElement.getSuccessor().setPredecessor(newElement);
            }
            else
            {
                this.getHead().setPredecessor(newElement);
            }

            this.getHead().setSuccessor(newElement);
        }
        else if (pos > this.countElementsRecursive(this.getHead()))
        {
            this.insertAtTheEnd(value);
        }
        else
        {
            IListElement previousElement = this.getListElementAt(pos - 1);
            IListElement nextElement = this.getListElementAt(pos);

            newElement.setPredecessor(this.getListElementAt(pos).getPredecessor());
            newElement.setSuccessor(this.getListElementAt(pos));
            previousElement.setSuccessor(newElement);
            nextElement.setPredecessor(newElement);
        }
    }

    public int countElementsRecursive(IListElement listElement)
    {
        if (listElement.getSuccessor() == null)
        {
            return 0;
        }

        return (1 + countElementsRecursive(listElement.getSuccessor()));
    }

    public IListElement getListElementAt(int pos)
    {
        return getListElementAtRecursive(this.getHead(), pos);
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
        if (pos <= 0 || pos > this.countElementsRecursive(this.getHead()))
        {
            return null;
        }

        return getElementAtRecursive(this.getHead(), pos).getValueElement();
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
        return getFirstPosOfRecursive(this.getHead(), value);
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
        IListElement elementToDelete = this.findElementByValue(this.getHead(), value);

        if (elementToDelete != null)
        {
            if (elementToDelete.getSuccessor() != null)
            {
                elementToDelete.getPredecessor().setSuccessor(elementToDelete.getSuccessor());
                elementToDelete.getSuccessor().setPredecessor(elementToDelete.getPredecessor());
            }
            else
            {
                ((ListElement) elementToDelete.getPredecessor()).deleteSuccessor();
                
                if (this.countElementsRecursive(this.getHead()) >= 1)
                {
                    this.getHead().setPredecessor(elementToDelete.getPredecessor());
                }
                else
                {
                    ((ListElement) this.getHead()).deletePredecessor();
                }
            }
        }
    }

    public IListElement findElementByValue(IListElement listElement, IValueElement value)
    {
        if (listElement.getValueElement() == value)
        {
            return listElement;
        }

        if (listElement.getSuccessor() == null)
        {
            return null;
        }

        return findElementByValue(listElement.getSuccessor(), value);
    }

    public void deleteAllOf(IValueElement value)
    {
        while (this.findElementByValue(this.getHead(), value) != null)
        {
            this.deleteFirstOf(value);
        }
    }

    public void deleteElementAt(int pos)
    {
        IListElement elementToDelete = this.getListElementAt(pos);

        if (elementToDelete.getSuccessor() != null)
        {
            elementToDelete.getPredecessor().setSuccessor(elementToDelete.getSuccessor());
            elementToDelete.getSuccessor().setPredecessor(elementToDelete.getPredecessor().getSuccessor());
        }
        else
        {
            ((ListElement) elementToDelete.getPredecessor()).deleteSuccessor();
            this.getHead().setPredecessor(elementToDelete.getPredecessor());
        }
    }

    public boolean member(IValueElement value)
    {
        if (this.findElementByValue(this.getHead(), value) != null)
        {
            return true;
        }

        return false;
    }

    public void reverse()
    {
        this.swapPredecessorAndSuccessor(this.getHead());

        this.getHead().getSuccessor().setSuccessor(this.getHead().getSuccessor().getPredecessor());
        this.getHead().getSuccessor().setPredecessor(this.getHead());
        ((ListElement) this.getHead().getPredecessor()).deleteSuccessor();
    }

    public void swapPredecessorAndSuccessor(IListElement listElement)
    {
        if (listElement.getSuccessor() != null)
        {
            IListElement tempElement = listElement.getPredecessor();
            listElement.setPredecessor(listElement.getSuccessor());
            listElement.setSuccessor(tempElement);
            swapPredecessorAndSuccessor(listElement.getPredecessor());
        }
    }

    public List()
    {
    }

    public String toString()
    {
        return printAllListElements(this.getHead());
    }

    public String printAllListElements(IListElement listElement)
    {
        if (listElement.getSuccessor() == null)
        {
            return listElement.getValueElement().toString();
        }

        return listElement.getValueElement() + this.printAllListElements(listElement.getSuccessor());
    }
}
