import java.util.Scanner;
class CSLabtest1Odd
{
    static int a=0,b=0,c=0,d=0;
    static void input()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Input a: ");
        a=sc.nextInt();
        while(b==0)
        {
            System.out.print("Input b: ");
            b=sc.nextInt();
        }
        System.out.print("Input c: ");
        c=sc.nextInt();
        while(d==0)
        {
            System.out.print("Input d: ");
            d=sc.nextInt();
        }
    }
    static int gcd(int a,int b)
    {
        if(a==0||b==0)
            return 1;
        if(a==b)
            return a;
        if(a>b)
            return gcd(a-b,b);
        return gcd(a,b-a);
    }
    static int lcm(int a,int b)
    {
        int lcm=(a>b)?a:b;
        while(true)
        {
            if(lcm%a==0&&lcm%b==0)
                return lcm;
            lcm++;
        }
    }
    public static void main(String[] args)
    {
        input();
        int bLd=lcm(b,d);
        int aPc=(a*(bLd/b))+(c*(bLd/d));
        int aSc=(a*(bLd/b))-(c*(bLd/d));
        int ac=a*c,bd=b*d;
        System.out.println("(a/b)+(c/d)= "+aPc+"/"+bLd);
        System.out.println("(a/b)-(c/d)= "+aSc+"/"+bLd);
        System.out.println("(a/b)*(c/d)= "+ac+"/"+bd);
        System.out.println("After Reduction");
        int x=2;
        while(x!=1)
        {
            x=gcd(Math.abs(aPc),Math.abs(bLd));
            aPc/=x;
            bLd/=x;
        }
        x=2;
        while(x!=1)
        {
            x=gcd(Math.abs(aSc),Math.abs(bLd));
            aSc/=x;
            bLd/=x;
        }
        x=2;
        while(x!=1)
        {
            x=gcd(Math.abs(ac),Math.abs(bd));
            ac/=x;
            bd/=x;
        }
        System.out.println("(a/b)+(c/d)= "+aPc+"/"+bLd);
        System.out.println("(a/b)-(c/d)= "+aSc+"/"+bLd);
        System.out.println("(a/b)*(c/d)= "+ac+"/"+bd);
    }
}
