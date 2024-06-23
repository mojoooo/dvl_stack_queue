package implementierung;

import schnittstellen.*;

public class Stack implements IStack
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

        return list.countElementsRecursive(list.getHead()) >= Stack.MAX_CAPACITY;
    }

    public int pop()
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

    public void push(int value)
    {
        if (!this.isFull() && value >= 0)
        {
            ValueElement newElement = new ValueElement("StackElement", value);
            this.getDVL().insertAtTheEnd(newElement);
        }
    }

    public int top()
    {
        if (this.isEmpty())
        {
            return -1;
        }

        List list = (List) this.getDVL();

        return list.getElementAt(list.countElementsRecursive(list.getHead())).getValue();
    }

    public Stack()
    {
        List newList = new List();
        this.setDVL(newList);
    }

    public Stack(int value)
    {
        this();
        ValueElement newValueElement = new ValueElement("StackElement", value);
        List newList = new List();
        newList.insertAtTheEnd(newValueElement);
        this.setDVL(newList);
    }
}
