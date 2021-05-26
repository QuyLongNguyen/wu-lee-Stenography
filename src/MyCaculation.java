import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;



public class MyCaculation {
	public static int[] inRange(int x) {
		
		int[]range = {0,7,8,15,16,31,32,63,64,127,128,255};
		int i = 0;
		int []in_range = {0,7};
		while(x > range[i]) {
			i++;
		}
		/*
		if(x == range[i+1]) {
			if(i % 2 == 0) {
				in_range[0] = range[i+1];
				in_range[1] = range[i+2];
				return in_range ;
			}
			else {
				in_range[0] = range[i];
				in_range[1] = range[i+1];
				return in_range ;
			}
		}
		in_range[0] = range[i-1];
		in_range[1] = range[i];
		*/
		return in_range ;
	}
	public static int roundUp(double number) {
		if(number <= 0){
			return (int)number;
		}
		else {
			return (int)number+1;
		}
	}
	public static int roundDown(double number) {
		if(number >= 0 ) {
			return (int)number;
		}
		else {
			return (int)number-1;
		}	
	}
	public static int log2(double number) {
		return (int) (Math.log(number)/Math.log(2));
	}
	
	public static void main(String[] args) {
		
		
			
		}
	}
	

