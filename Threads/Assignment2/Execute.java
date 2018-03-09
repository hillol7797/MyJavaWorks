package Assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Execute 
{
	public static void main(String[] args)
	{
		int a=0,b=0;
		System.out.println("Enter two numbers: ");
		try
		{
			a=input();
			b=input();
		} catch(Exception e)	{}
		Thread th1=new Thread(new ThreadAdd(a,b));
		Thread th2=new Thread(new ThreadSubstract(a,b));
		Thread th3=new Thread(new ThreadMultiply(a,b));
		Thread th4=new Thread(new ThreadDivide(a,b));
		Thread th5=new Thread(new ThreadModulo(a,b));
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
	}
	public static int input() throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		return n;
	}
}
