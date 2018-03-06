import java.util.*;
public class MyArraylist
{
    Entity[] array1,array2;
    //ArrayList<Entity> array1,array2;
    public MyArraylist(int n)       //Creates Your two array;
    {
        //array1=new ArrayList<Entity>(n);
        //array2=newi ArrayList<Entity>(n);
        array1=new Entity[n];
        array2=new Entity[n];
        for(int i=0;i<n;i++)
        {
            array1[i]=new Entity();
            array2[i]=new Entity();
        }
    }
    public void createGraph()
    {
        for(int i=0;i<array1.length;i++)        //Loops through all elements in array1
        {
            while(array1[i].noOfConnections<2)      //Loops untill 2 connections are made
            {
                int index=(int)(Math.random() * (array2.length) );        //Picks a randon connection
                if(array2[index].noOfConnections<2)         //Checks if it is already connected to 2 elements
                {
                    array1[i].connectedTo[array1[i].noOfConnections]=index;       //Creates the connection
                    array1[i].noOfConnections++;
                    array2[index].connectedTo[array2[index].noOfConnections]=i;
                    array2[index].noOfConnections++;
                }
            }
        }
    }
    public void values()
    {
        for(int i=0;i< array1.length;i++)
        {
            array1[i].value=i;
            array2[i].value=i;
        }
    }
}
