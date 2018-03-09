//Set Priority
class MyThread implements Runnable
{
	public void run()
	{
		String name=Thread.currentThread().getName();
		for(int i=0;i<3;i++)
		{
			System.out.println("Thread name: "+name+"\tValue: "+i);
		}
	}
}

class Execute 
{
	public static void main(String[] args)
	{
		Thread th1=new Thread(new MyThread());
		Thread th2=new Thread(new MyThread());
		Thread th3=new Thread(new MyThread());
		th1.setName("MyThreadObj1");
		th2.setName("MyThreadObj2");
		th3.setName("MyThreadObj3");
		th1.start();
		th1.setPriority(8);
		th2.start();
		th2.setPriority(5);
		th3.start();
		th3.setPriority(3);
	}
}
