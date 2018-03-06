import java.util.*;
class Conjecture3xPlus1
{
    public int findConjectureLoops(int n,int print)
    {
        int count=0;
        while(n>1)
        {
            count++;
            if(n%2==0)
                n=n/2;
            else
                n=3*n+1;
            if(print==1)
                System.out.print(n+"   ");
        }
        return count;
    }
    public void findMaxIterations(int n)
    {
        int max[]=new int[2];
        max[1]=0;
        for(int i=1;i<=n;i++)
        {
            int loops=findConjectureLoops(i,0);
            if(max[1]<loops)
            {
                max[0]=i;
                max[1]=loops;
            }
        }
        System.out.println("Maximum number of iterations= "+max[1]+" for n= "+max[0]);
        System.out.println("The sequence is:");
        findConjectureLoops(max[0],1);
    }
    // public void findMaxIterations(int n)
    // {
    //     Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    //     map.put(0,0);
    //     map.put(2,1);
    //     map.put(1,2);
    //     int max[]=new int[2];
    //     for(int i=1;i<=n;i++)
    //     {
    //         int num=i,count=0;
    //         while(num>1)
    //         {
    //             if(num%2==0)
    //             {
    //                 map.put(num,(map.get(num/2)+1));
    //                 map.remove(num/2);
    //                 num=1;
    //             }
    //             else
    //             {
    //                 num=3*num+1;
    //             }
    //             count++;
    //         }
    //         if(map.get(i)>max[1])
    //         {
    //             max[1]=map.get(i);
    //             max[0]=i;
    //         }
    //     }
    //     System.out.println(max[1]+" "+max[0]);
    // }
    public static void main(String[] args)
    {
        int bound=100000;
        Conjecture3xPlus1 obj=new Conjecture3xPlus1();
        obj.findMaxIterations(bound);
    }
}
