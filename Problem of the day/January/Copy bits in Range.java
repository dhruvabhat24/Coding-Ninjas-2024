import java.util.* ;
import java.io.*; 

public class Solution {

	public static int copyBitsInRange(int a, int b, int x, int y) {
		//BIT MANIPULATION:
		//taking the range of x to y in a loop:
		for (int i=x;i<=y;i++){
			//taking 1 and shifting left i-1 times: as 1 will already occupy one range
			int mask=1<<(i-1);
			// if the ith bit of a is set then we wont zero if we do a&mask:
			if ((a&mask)!=0){
				//if it set then copy the masked bit to b:
				b=b|mask;
			}
		}
		//returning b
		return b;
	}

}
