package implementierung;

import schnittstellen.*;

public class ValueElement implements IValueElement
{
	private String name;
	private int value;
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		if (name != null)
		{
			this.name = name;
		}
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public void setValue(int value)
	{
		if (value != 0)
		{
			this.value = value;
		}
	}
	
	public ValueElement()
	{
		this.name = "";
		this.value = 0;
	}
	
	public ValueElement(String name, int value)
	{
		this.setName(name);
		this.setValue(value);
	}
	
	public ValueElement(ValueElement valueElement)
	{
		this.setName(valueElement.getName());
		this.setValue(valueElement.getValue());
	}
	
	public String toString()
	{
		return "Name: " + this.getName() + " Value: " + this.getValue();
	}
}
