import java.io.*;
import java.util.*;
public class Execute
{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws IOException
    {
        int size,list[];
        System.out.print("Enter memory size: ");
        size=sc.nextInt();
        System.out.print("Enter list size: ");
        int n=sc.nextInt();
        list=new int[n];
        System.out.println("Enter the replacement sequence: ");
        for(int i=0;i<n;i++)
            list[i]=sc.nextInt();

        ReplacementMachine rm=new ReplacementMachine(list,size);
        rm.selector();
    }
}
