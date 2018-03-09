package Assignment2;

public class ThreadMultiply implements Runnable
{
	int a,b;
	ThreadMultiply(int a,int b)
	{
		this.a=a;
		this.b=b;
	}
	public void run() 
	{
		System.out.println("Thread Multiply: \tResult: "+(this.a*this.b));
	}
	
}