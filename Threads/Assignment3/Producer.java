package Assignment3;

public class Producer implements Runnable
{
	Product P;
	Producer(Product P)
	{
		this.P=P;
	}
	public void run()
	{
		for(int i=0;i<3;i++)
			P.produce();
	}
}
