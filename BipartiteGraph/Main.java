public class Main
{
    public static void main(String[] args)
    {
        MyArraylist list=new MyArraylist(4);
        list.values();
        list.createGraph();
        for(int i=0;i<list.array1.length;i++)
        {
            System.out.println(i+" -> "+list.array1[i].connectedTo[0]+" & "+list.array1[i].connectedTo[1]);
        }
        for(int i=0;i<list.array2.length;i++)
        {
            System.out.println(i+" -> "+list.array2[i].connectedTo[0]+" & "+list.array2[i].connectedTo[1]);
        }
    }
}
