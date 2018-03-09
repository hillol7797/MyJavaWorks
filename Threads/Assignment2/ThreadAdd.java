package Assignment2;

public class ThreadAdd implements Runnable
{
	int a,b;
	ThreadAdd(int a,int b)
	{
		this.a=a;
		this.b=b;
	}
	public void run() 
	{
		System.out.println("Thread Add: \t\tResult: "+(this.a+this.b));
	}
	
}
