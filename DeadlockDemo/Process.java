import java.util.*;
public class Process
{
    int pNo;
    ArrayList<Character> allocated;
    Process(int n)
    {
        pNo=n;
        allocated = new ArrayList<Character>();
    }
    public void request(Resorce r)
    {
        if(r.assignedTo==-1)
        {
            allocated.add(r.name);
            r.assignedTo=pNo;
            System.out.println("Resorce "+r.name+" ALLOCATED to process "+pNo);
        }
        else
        {
            System.out.println("Process "+pNo+" WAITING for resorce: "+r.name);
            while(r.assignedTo!=-1);
        }
    }
    public void release(Resorce r)
    {
        allocated.remove(allocated.indexOf(r.name));
        r.assignedTo=-1;
        System.out.println("Process "+pNo+" RELEASED "+r.name);
    }
}
