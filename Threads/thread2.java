//Thread implementing Runnable interface
class MyThread implements Runnable
{
	public void run()
	{
		System.out.println("Thread name from run(): "+Thread.currentThread().getName());
	}
}

class Execute 
{
	public static void main(String[] args)
	{
		Thread th=new Thread(new MyThread());
		th.setName("MyThreadObject");
		th.start();
			System.out.println("Thread name from main(): "+Thread.currentThread().getName());
	}
}
