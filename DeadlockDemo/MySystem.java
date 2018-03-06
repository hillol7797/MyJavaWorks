public class MySystem
{
    public static void main(String[] args)
    {
        Resorce rA=new Resorce('a');
        Resorce rB=new Resorce('b');
        Process p1=new Process(1);
        Process p2=new Process(2);

        class Execute extends Thread implements Runnable
        {
            Process p;
            Resorce r1,r2;
            Execute(Process p,Resorce r1,Resorce r2)
            {
                this.p=p;
                this.r1=r1;
                this.r2=r2;
            }
            public void run()
            {
                p.request(r2);
                p.release(r2);
                p.request(r1);
                try{    Thread.sleep(1000); }catch(Exception e){}
                p.request(r2);
                p.release(r1);
                p.release(r2);
            }
        }

        Execute e1=new Execute(p1,rA,rB);
        Execute e2=new Execute(p2,rB,rA);
        e1.start();
        e2.start();
    }
}
