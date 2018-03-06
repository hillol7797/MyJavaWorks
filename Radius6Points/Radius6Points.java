import java.util.Scanner;
class Points
{
    double x,y;
    Points(double x,double y)
    {
        this.x=x;
        this.y=y;
    }
}
class Radius6Points
{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args)
    {
        run();
    }
    static boolean checkColinear(Points p1,Points p2,Points p3)
    {
        if((p1.x*(p2.y-p3.y)+p2.x*(p3.y-p1.y)+p3.x*(p1.y-p2.y))==0)
            return true;
        return false;
    }
    static double circumRadius(Points p1,Points p2,Points p3)
    {
        double d1=Math.sqrt(Math.pow((p1.x-p2.x),2)+Math.pow((p1.y-p2.y),2));
        double d2=Math.sqrt(Math.pow((p2.x-p3.x),2)+Math.pow((p2.y-p3.y),2));
        double d3=Math.sqrt(Math.pow((p3.x-p1.x),2)+Math.pow((p3.y-p1.y),2));
        return ((d1*d2*d3)/(Math.sqrt((d1+d2+d3)+(d1+d2-d3)+(d2+d3-d1)+(d3+d1-d2))));
    }
    static void run()
    {
        Points points[]=new Points[6];
        System.out.println("Enter points:");
        for(int i=0;i<6;i++)
        {
            //points[i]=Points(sc.nextDouble(),sc.nextDouble());
            points[i].x=sc.nextDouble();
            points[i].y=sc.nextDouble();
        }
        for(int i=0;i<=3;i++)
        {
            for(int j=i+1;j<=4;j++)
            {
                for(int k=j+1;k<=5;k++)
                {
                    if(!checkColinear(points[i],points[j],points[k]))
                    {
                        double d=circumRadius(points[i],points[j],points[k]);
                        if(d>1.0)
                            System.out.println("Circum-radius of points "+i+", "+j+" & "+k+" is "+d+" (BIG CIRCUM-RADIUS)");
                        else
                            System.out.println("Circum-radius of points "+i+", "+j+" & "+k+" is "+d);
                    }
                }
            }
        }
    }
}
