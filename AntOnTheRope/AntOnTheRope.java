class AntOnTheRope
{
    static void travel(double lengthRope,double lengthCovered,int seconds)
    {
        do
        {
            lengthRope+=10.0;
            lengthCovered+=1.0;
            seconds++;
            double unitDistance=lengthRope/(lengthRope-10);
            lengthCovered*=unitDistance;
        } while (lengthCovered<lengthRope);
        System.out.println("Length of Rope: "+lengthRope+" Seconds taken: "+seconds+" Distance Covered: "+lengthCovered);
    }
    public static void main(String[] args)
    {
        travel(10.0,0.0,0);
    }
}
