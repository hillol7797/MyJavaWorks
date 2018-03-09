package Assignment3;

public class Consumer implements Runnable
{
	Product P;
	Consumer(Product P)
	{
		this.P=P;
	}
	public void run()
	{
		for(int i=0;i<3;i++)
			P.consume();
	}
}

