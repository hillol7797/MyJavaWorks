package Assignment3;

public class Product
{
	int n=0;
	Product(int n)
	{
		this.n=n;
	}
	void produce()
	{
		n++;
		System.out.println("Producer "+n);
	}
	void consume()
	{
		n--;
		System.out.println("Consumer "+n);
	}
}
