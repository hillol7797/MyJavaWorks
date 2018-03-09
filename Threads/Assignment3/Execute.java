package Assignment3;

public class Execute
{
	static Product P;
	public static void main(String[] args)
	{
		P=new Product(5);
		Thread th1=new Thread(new Producer(P));
		Thread th2=new Thread(new Consumer(P));
		th1.start();
		th2.start();
	}

}
