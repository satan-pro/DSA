import java.util.*;
class gfgBitManipulation
{
	static void bitManipulation(int num, int i) {
        // code here
        int getBit = (num>>(i-1))&1;
        
        int setBit = num | (1<<(i-1));
        int clearBit = num & ~(1<<(i-1));
        
        System.out.println(getBit +" "+ setBit +" "+ clearBit);
    }

    public static void main(String[] args) {
    	bitManipulation(678883006, 16);
    }
}