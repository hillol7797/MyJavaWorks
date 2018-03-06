import java.io.*;
class FindDecimal
{
    static boolean checkArray[]=new boolean[10];
    FindDecimal()
    {
        for(int i=0;i<checkArray.length;i++)
            checkArray[i]=false;
    }
    private static int checker(int number,int n)
    {
        number=number*n;
        // System.out.print(number+" ");
        int x=number;
        while(x>0)
        {
            int d=x%10;
            if(!checkArray[d])
                checkArray[d]=true;
            x=x/10;
        }
        boolean reccur=false;
        for(int i=0;i<checkArray.length;i++)
        {
            // if(checkArray[i])
            // System.out.print(i+" ");
            if(!checkArray[i])
            {
                reccur=true;
                break;
            }
        }
        // System.out.print("\n");
        if(reccur)
            return checker(number,++n);
        else
            return n;
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number: ");
        int number=Integer.parseInt(br.readLine());
        System.out.println("Result: "+checker(number,1));
    }
}
