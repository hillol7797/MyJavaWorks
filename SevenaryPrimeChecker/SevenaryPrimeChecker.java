class SevenaryPrimeChecker
{
    static int sevenary(int n)
    {
        int rem,quot,hept=0;
        quot=n;
        while(quot!=0)
        {
            rem=quot%7;
            hept=hept*10+rem;
            quot/=7;
        }
        return hept;
    }
    static boolean prime(int n)
    {
        for(int i=2;i<=n/2;i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }
    static int S7(int num)
    {
        int n=sevenary(num);
        int sum=0;
        while(n>0)
        {
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    public static void main(String[] args)
    {
        int counter=0;
        for(int i=2;;i++)
        {
            if(prime(i))
            {
                counter++;
                if(!prime(S7(i)))
                {
                    System.out.println("Prime: "+i+" Count: "+counter);
                    break;
                }
            }
        }
    }
}
