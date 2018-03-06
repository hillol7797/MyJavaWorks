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
        int i=0;
        while(i<sequence.length && sequence[i]!=-1)
            i++;
        for(int b=0;b<memory.length;b++)
        {
            if(memory[b]==n)
                return;
        }
        System.out.println("\nFault");
        if(i==sequence.length)
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
            sequence[i]=i;
            memory[i]=n;
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
