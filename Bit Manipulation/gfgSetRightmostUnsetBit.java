import java.util.*;
class gfgSetRightmostUnsetBit
{
	static int setBit(int n) {
        // code here

        // Return n+1 if n is even, i.e leftmost bit is 0
        if((n&1)==0)
        	return n+1;
        int i=1;

        // Loop until you find the leftmost unset bit
        while((n&i)!=0)
        {
        	// Shift 1 until you find 0 bit
        	i = i<<1;
        }
        // Return answer
        return n|i;
    }
}