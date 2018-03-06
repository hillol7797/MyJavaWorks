import java.util.Scanner;
class PolynomialArithmetic
{
    static Scanner sc=new Scanner(System.in);
    static final int MINUS_INFINITY=-1;
    static final int MAX_DEGREE=100;
    static final int POLY_SIZE=102;
    static final int DEGREE_INDEX=101;
    void polyScan(int f[])
    {
        System.out.print("Enter the degree of polynomial: ");
        f[DEGREE_INDEX]=sc.nextInt();
        System.out.println("Enter the coefficients:");
        for(int i=0;i<=f[DEGREE_INDEX];i++)
            f[i]=sc.nextInt();
    }
    void polyPrint(int f[])
    {
        for(int i=f[DEGREE_INDEX];i>=0;i--)
        {
            if(i==f[DEGREE_INDEX]&&f[i]!=0)
                System.out.print(((f[i]==1)?"":((f[i]==-1)?"-":f[i]))+"x^"+i);
            else if(i>1&&f[i]!=0)
                System.out.print(((f[i]<0)?"":"+")+((f[i]==1)?"":((f[i]==-1)?"-":f[i]))+"x^"+i);
            else if(i==1&&f[i]!=0)
                System.out.print(((f[i]<0)?"":"+")+((f[i]==1)?"":((f[i]==-1)?"-":f[i]))+"x");
            else if(i==0)
                System.out.println(((f[i]<0)?"":"+")+f[i]);
        }
    }
    int polyEval(int f[], int n)
    {
        int result=0;
        for(int i=f[DEGREE_INDEX];i>0;i--)
        {
            result=(result+f[i])*n;
        }
        return result+f[0];
    }
    int polyComp(int f[], int g[])
    {
        if(f[DEGREE_INDEX]!=g[DEGREE_INDEX])
            return 1;
        for(int i=0;i<=f[DEGREE_INDEX];i++)
        {
            if(f[i]!=g[i])
                return 1;
        }
        return 0;
    }
    void polyAdd(int h[],int f[],int g[])
    {
        h[DEGREE_INDEX]=(f[DEGREE_INDEX]>=g[DEGREE_INDEX])?f[DEGREE_INDEX]:g[DEGREE_INDEX];
        for(int i=0;i<=h[DEGREE_INDEX];i++)
        {
            if(f[DEGREE_INDEX]>=g[DEGREE_INDEX])
            {
                if(i<=g[DEGREE_INDEX])
                    h[i]=f[i]+g[i];
                else
                    h[i]=f[i];
            }
            else
            {
                if(i<=f[DEGREE_INDEX])
                    h[i]=f[i]+g[i];
                else
                    h[i]=g[i];
            }
        }
    }
    void polyMult(int h[],int f[],int g[])
    {
        h[DEGREE_INDEX]=f[DEGREE_INDEX]+g[DEGREE_INDEX];
        for(int i=0;i<=h[DEGREE_INDEX];i++)
            h[i]=0;
        if(f[DEGREE_INDEX]!=-1&&g[DEGREE_INDEX]!=-1)
        {
            for(int i=0;i<=g[DEGREE_INDEX];i++)
            {
                for(int j=0;j<=f[DEGREE_INDEX];j++)
                    h[i+j]+=f[j]*g[i];
            }
        }
    }
    void polyDeriv(int h[],int f[])
    {
        h[DEGREE_INDEX]=f[DEGREE_INDEX]-1;
        for(int i=f[DEGREE_INDEX];i>0;i--)
            h[i-1]=f[i]*i;
    }
    public static void main(String[] args)
    {
        int f[]=new int[POLY_SIZE],g[]=new int[POLY_SIZE],h[]=new int[POLY_SIZE];
        PolynomialArithmetic pa=new PolynomialArithmetic();
        pa.polyScan(f);
        pa.polyPrint(f);
        // System.out.print("Enter n:");
        // System.out.println(pa.polyEval(f,sc.nextInt()));
        // pa.polyScan(g);
        // pa.polyPrint(g);
        //System.out.println(pa.polyComp(f,g));
        pa.polyDeriv(h,f);
        pa.polyPrint(h);
    }
}
