class CSLabtest2
{
    int countA=0,countB=0,countC=0;
    int[] a,b,c;
    CSLabtest2Even(int n)
    {
        a=new int[n+1];
        b=new int[n+1];
        c=new int[n+1];
        reset();
    }
    void reset()
    {
        for(int i=0;i<a.length;i++)
            a[i]=b[i]=c[i]=0;
    }
    int getAn(int n)
    {
        a[n]++;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return getAn(n/2)+getBn(n)-3*getCn(n-2);
    }
    int getBn(int n)
    {
        b[n]++;
        if(n==0)
            return 1;
        return n-2*getBn(n/3)+getCn(n);
    }
    int getCn(int n)
    {
        c[n]++;
        if(n==0)
            return -1;
        if(n==1)
            return 0;
        if(n==2)
            return 1;
        return 5-getAn(n-1)+getBn(n-2)-getCn(n-3);
    }
    void printCallFreq()
    {
        System.out.println("Number of calls:");
        for(int i=0;i<a.length;i++)
            System.out.print("A("+i+")= "+a[i]+"  ");
        System.out.println();
        for(int i=0;i<b.length;i++)
            System.out.print("B("+i+")= "+b[i]+"  ");
        System.out.println();
        for(int i=0;i<c.length;i++)
            System.out.print("C("+i+")= "+c[i]+"  ");
        System.out.println();
        reset();
    }
    public static void main(String[] args)
    {
        int n=10;
        CSLabtest2Odd obj=new CSLabtest2Odd(n);
        System.out.println("Recusive method:\nA("+n+")= "+obj.getAn(n));
        obj.printCallFreq();
        System.out.println("Recusive method:\nB("+n+")= "+obj.getBn(n));
        obj.printCallFreq();
        System.out.println("Recusive method:\nC("+n+")= "+obj.getCn(n));
        obj.printCallFreq();
    }
}
