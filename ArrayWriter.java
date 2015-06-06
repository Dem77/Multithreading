
public class ArrayWriter implements Runnable
{
	private final SimpleArray ssarray;
	private final int startValue;
	
	public ArrayWriter (int value, SimpleArray array)
	{
		startValue = value;
		ssarray = array;
	}

	@Override
	public void run() 
	{
		for (int i = startValue; i < startValue + 3; i++)
		{
			ssarray.add(i);
		}
	}
	
}
