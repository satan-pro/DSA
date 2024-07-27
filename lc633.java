import java.util.*;
class lc633
{
	public boolean judgeSquareSum(int c) {
        int nearest = (int)(Math.pow((Math.floor(Math.sqrt(c))),2));
        int remaining = c-nearest;
        if(remaining==0)
            return true;
        double remainingNum = (Math.sqrt(remaining));
        System.out.println("A : "+Math.floor(Math.sqrt(c))+" Remaining : "+remaining+"Remaining Num : "+remainingNum);
        if((remainingNum - Math.floor(remainingNum))>0.0)
            return false;
        return true;
    }

    public static void main(String[] args) {
    	lc633 obj = new lc633();
    	boolean res = obj.judgeSquareSum(4);
    	System.out.println(res);
    }
}