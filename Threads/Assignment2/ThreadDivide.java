package Assignment2;

public class ThreadDivide implements Runnable
{
	int a,b;
	ThreadDivide(int a,int b)
	{
		this.a=a;
		this.b=b;
	}
	public void run() 
	{
		try
		{
		System.out.println("Thread Divide: \t\tResult: "+(this.a/this.b));
		}
		catch(ArithmeticException e)
		{}
	}
}
