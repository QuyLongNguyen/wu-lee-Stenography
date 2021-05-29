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
    public static String fixLengthOfBin(String input,int n) {
    	while(input.length() < n) {
    		input = "0"+input;
    	}
    	return input;
    }
    public static int[] convertTextStringToDecArray(String input) {
    	int[] dec = new int[input.length()-1];
    	for(int i=0;i<dec.length;i++) {
    		dec[i] = input.charAt(i);
    	}
    	return dec;
    }
    public static String convertDecArrayToTextString(int[] input) {
    	String result = "";
    	for(int i=0;i<input.length;i++) {
    		result += (char)input[i];
    	}
    	return result;
    }
    public static String convertDecArrayToBin(int[] input) {
    	String result = "";
    	for(int i=0;i<input.length;i++) {
    		String t =  Integer.toBinaryString(input[i]);
    		t = fixLengthOfBin(t, 8);
    		result += t; 
    	}
    	return result;
    }
    public static int[] convertBinToDecArray(String input) {
    	int[] dec = new int[input.length()/8];
    	for(int i = dec.length-1 ; i >= 0 ; i--) {
    		String t = input.substring(i*8,(i+1)*8);
    		dec[i] = Integer.parseInt(t, 2);
    	}
    	return dec;
    }
	public static void main(String[] args) {
		
	
	}
}
	

