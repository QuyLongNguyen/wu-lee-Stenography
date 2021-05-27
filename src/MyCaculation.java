import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;



public class MyCaculation {
	public static int[] inRange(int x) {
		int[] range = {0,7};
		if(x >= 8 && x <= 15) {
			range[0] = 8;
			range[1] = 15;
		}
		else if(x >= 16 && x <= 31) {
			range[0] = 16;
			range[1] = 31;
		}
		else if(x >= 32 && x <= 63) {
			range[0] = 31;
			range[1] = 63;
		}else if(x >= 64 && x <= 127) {
			range[0] = 64;
			range[1] = 127;
		}else if(x >= 128 && x <= 255) {
			range[0] = 128;
			range[1] = 255;
		}
		return range;
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
	
    public static String convertStringToBinary(String input) {

    	char[] messChar = input.toCharArray();
    	String result = "";
        for (int i = 0; i < messChar.length; i++) {
            result += Integer.toBinaryString(messChar[i]);
        }

        return result;
    }
    
    
	public static void main(String[] args) {
		System.out.println(convertStringToBinary("Hello"));
	}
}
	

