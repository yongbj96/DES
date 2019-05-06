package des_algorithm;

import java.util.Scanner;

public class Input {
	
	@SuppressWarnings("resource")
	public static final void Function() {
		Scanner scan = new Scanner(System.in);
		char[] key = new char[7];
		int[] key_code_64bit = new int[64];
		
		//키 입력
		while(true) {
			System.out.print("what's your key? (Please, under 7 texts) : ");
			String key_enter = scan.nextLine();
			if(key_enter.length()<=0|key_enter.length()>7)
				continue;
			for(int z=0; z<key_enter.length(); z++)
				key[z] = key_enter.charAt(z);
			break;
		}
		
		//키 -> 코드변환
		int count=0;
		for(int z=0; z<key.length; z++) {
			int key_num = key[z];
			for(int y=7; y>=0; y--) {
				if(key_num-(int)Math.pow(2,y)>=0) {
					key_code_64bit[count]=1;
					key_num-=(int)Math.pow(2,y);
				} else {
					key_code_64bit[count]=0;
				}
				count++;
				if(count%8==7) {
					key_code_64bit[count]=5;
					count++;
				}
			}
		}
		
		//PC-1전치 (void)
		PC_1.permutation(key_code_64bit);
	}
}
