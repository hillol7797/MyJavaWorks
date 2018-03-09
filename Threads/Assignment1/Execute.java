package Assignment1;

class Execute 
{
	public static void main(String[] args)
	{
		Thread th1=new Thread(new MyThread());
		th1.setName("MyThreadObj1");
		th1.start();
	}
}
