//Thread exteding Thread class
class MyThread extends Thread
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
		Thread.currentThread().setName("MYMAIN");
		MyThread th=new MyThread();
		th.start();
			System.out.println("Thread name from main(): "+Thread.currentThread().getName());
	}
}
