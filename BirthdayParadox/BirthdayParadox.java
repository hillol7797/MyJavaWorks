class BirthdayParadox
{
    public static void main(String[] args)
    {
        int days[]=new int[365];
        int nDays[] = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        String months[]=new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
        for(int i=0;i<365;i++)
            days[i]=0;
        boolean loop=true;
        int tries=0;
        while(loop)
        {
            tries++;
            int day=(int)(Math.random()*365);
            int n=0,d=day;
            while(d>nDays[n])
            {
                d=d-nDays[n];
                n++;
            }
            System.out.println(tries+": "+months[n]+" "+d);
            if(days[day]!=0)
            {
                System.out.println("Match found among "+tries+" birthdays");
                System.out.println("Bithdays no "+days[day]+" & "+tries+" match.");
                loop=false;
            }
            else
                days[day]=tries;
        }
    }
}
