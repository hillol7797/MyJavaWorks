package Assignment1;

class MyThread implements Runnable
{
	public void run()
	{
		for(int i=1;i<=100;i++)
		{
			System.out.println("Value: "+i);
			if(i%10==0)
				System.out.println("String");
			try
			{	Thread.currentThread();
				Thread.sleep(1000);	}
			catch(InterruptedException e) {	}
		}
	}
}