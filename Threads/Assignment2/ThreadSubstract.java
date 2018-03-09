package Assignment2;

public class ThreadSubstract implements Runnable
{
	int a,b;
	ThreadSubstract(int a,int b)
	{
		this.a=a;
		this.b=b;
	}
	public void run() 
	{
		System.out.println("Thread Substract: \tResult: "+(this.a-this.b));
	}
	
}