//Sleep function
class MyThread implements Runnable
{
	public void run()
	{
		String name=Thread.currentThread().getName();
		for(int i=0;i<3;i++)
		{
			System.out.println("Thread name: "+name+"\tValue: "+i);
			try
			{	Thread.currentThread().sleep(100);	}
			catch(InterruptedException e) {	}
		}
	}
}

class Execute 
{
	public static void main(String[] args)
	{
		Thread th1=new Thread(new MyThread());
		Thread th2=new Thread(new MyThread());
		th1.setName("MyThreadObj1");
		th2.setName("MyThreadObj2");
		th1.start();
		th2.start();
			System.out.println("Thread name from main(): "+Thread.currentThread().getName());
	}
}
