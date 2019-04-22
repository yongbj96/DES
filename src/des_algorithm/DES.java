package des_algorithm;

import java.util.Scanner;

public class DES {
	
	static int CYCLE = 0;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] key = {' ', ' ', ' ', ' ', ' ', ' ', ' '};
		int[] parity_code = new int[64];
		int[] key_code = new int[56];
		
		//키 입력
		while(true) {
			System.out.print("what's your key?(Please, under 7 texts) : ");
			String key_enter = scan.nextLine();
			if(key_enter.length()>7)
				continue;
			for(int z=0; z<key_enter.length(); z++) {
				key[z] = key_enter.charAt(z);
			}
			break;
		}
		
		//키 -> 코드변환
		int count=0;
		for(int z=0; z<key.length; z++) {
			int key_num=key[z];
			for(int y=7; y>=0; y--) {
				if(key_num-(int)Math.pow(2,y)>=0) {
					parity_code[count]=1;
					key_num-=(int)Math.pow(2,y);
				} else {
					parity_code[count]=0;
				}
				count++;
				if(count%8==7) {
					parity_code[count]=5;
					count++;
				}
			}
		}
		
		//PC-1전치
		key_code = PC_1.permutation(parity_code);
		
		PC_2.permutation(key_code);
		
	}
}