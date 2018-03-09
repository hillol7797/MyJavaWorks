package Assignment2;

public class ThreadModulo implements Runnable
{
	int a,b;
	ThreadModulo(int a,int b)
	{
		this.a=a;
		this.b=b;
	}
	public void run() 
	{
		try
		{
		System.out.println("Thread Modulo: \t\tResult: "+(this.a%this.b));
		}
		catch(ArithmeticException e)
		{}
	}
}
