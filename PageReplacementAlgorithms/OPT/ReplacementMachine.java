public class ReplacementMachine
{
    int memory[],list[];
    ReplacementMachine(int list[],int size)
    {
        memory=new int[size];
        for(int i=0;i<size;i++)
        {
            memory[i]=-1;
        }
        this.list=list;
    }
    void replace(int n,int x)
    {
        int h=0,i=0;
        while(h<memory.length && memory[h]!=-1)
            h++;
        for(int b=0;b<memory.length;b++)
        {
            if(memory[b]==n)
                return;
        }
        System.out.println("\nFault");
        if(h==memory.length)
        {
            int k[]=new int[memory.length];
            for(int a=0;a<memory.length;a++)
            {
                for(int b=x;b<list.length;b++)
                {
                    if(list[b]==memory[a])
                    {
                        k[a]=b;
                        break;
                    }
                }
            }
            i=0;
            for(int b=1;b<memory.length;b++)
                if(k[i]<k[b])
                    i=b;
            memory[i]=n;
        }
        else
        {
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
            replace(list[i],i);
            printState();
        }
    }
}

//1 2 3 4 3 1 4 2 5 2 1 2 3 4
