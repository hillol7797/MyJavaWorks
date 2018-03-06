public class ReplacementMachine
{
    int memory[],sequence[],list[];
    ReplacementMachine(int list[],int size)
    {
        memory=new int[size];
        sequence=new int[size];
        for(int i=0;i<size;i++)
        {
            sequence[i]=-1;
            memory[i]=-1;
        }
        this.list=list;
    }
    void replace(int n)
    {
        int h=0,i=0;
        while(h<sequence.length && sequence[h]!=-1)
            h++;
        int k=0;
        while(k<memory.length&&memory[k]!=n)
            k++;
        if(k!=sequence.length)
        {
            i=0;
            while(i<sequence.length)
            {
                if(sequence[i]>sequence[k])
                    sequence[i]--;
                i++;
            }
            sequence[k]=h-1;
            return;
        }
        System.out.println("\nFault");
        if(h==sequence.length)
        {
            i=0;
            while(sequence[i]!=0)
                i++;
            memory[i]=n;
            sequence[i]=sequence.length;
            i=0;
            while(i<sequence.length)
            {
                sequence[i]--;
                i++;
            }
        }
        else
        {
            sequence[h]=h;
            memory[h]=n;
        }
    }
    void printState()
    {
        for(int i=0;i<memory.length;i++)
            System.out.print(memory[i]+"   ");
        System.out.println();
    }
    void selector()
    {
        for(int i=0;i<list.length;i++)
        {
            replace(list[i]);
            printState();
        }
    }
}
