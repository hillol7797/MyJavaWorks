import java.io.*;
class EnglishSentences
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static void distAlphabets(String str)
    {
        str=str.toUpperCase();
        class Sets
        {
            char character;
            int frequency;
            Sets(char c)
            {
                character=c;
                frequency=0;
            }
        }
        Sets set[]=new Sets[26];
        for(int i=0;i<26;i++)
        {
            set[i]=new Sets((char)(65+i));
        }
        for(int i=0;i<str.length();i++)
        {
            int c=(int)(str.charAt(i))-65;
            if(c>=0&&c<26)
                set[c].frequency++;
        }
        for(int i=0;i<26;i++)
        {
            System.out.print(set[i].character+":"+set[i].frequency+"\t");
            if(i==12)
                System.out.println();
        }
    }
    public static void main(String[] args) throws IOException
    {
        System.out.println("Enter the string.");
        distAlphabets(br.readLine());
    }
}
