package des_algorithm;

import java.util.Scanner;

public class Input {
	
	@SuppressWarnings("resource")
	public static final void Function() {
		Scanner scan = new Scanner(System.in);
		char[] key = new char[8];
		int[] key_code_64bit = new int[64];
		
		//키 입력
		while(true) {
			System.out.print("what's your key? (Please, under 8 texts) : ");
			String key_enter = scan.nextLine();
			if(key_enter.length()<=0|key_enter.length()>8)
				continue;
			for(int z=0; z<key_enter.length(); z++)
				key[z] = key_enter.charAt(z);
			if(key_enter.length()<8) //평문의 길이를 수정할 수 있는 코드3 (현재 8bits)
				for(int z=key_enter.length(); z<8; z++)
					key[z] = ' ';
			break;
		}
		
		//키 -> 코드변환
		int count=0;
		for(int z=0; z<key.length; z++) {
			int key_num = key[z];
			int parity_bit=0;
			for(int y=6; y>=0; y--) {
				if(key_num-(int)Math.pow(2,y)>=0) {
					key_code_64bit[count]=1;
					key_num-=(int)Math.pow(2,y);
					parity_bit++;
				} else
					key_code_64bit[count]=0;
				count++;
				if(count%8==7) {
					if(parity_bit%2==1) //홀수 패리티비트 사용
						key_code_64bit[count]=1;
					else
						key_code_64bit[count]=0;
					count++;
				}
			}
		}
		
		//입력된 Key + parity bits 출력
		System.out.print("Input Key: ");
		for(int z=0; z<64; z++) {
			if(z!=0&z%8==0)
				System.out.print(" ");
			System.out.print(key_code_64bit[z]);
		}
		System.out.println();
		
		//PC-1전치 (void)
		PC_1.permutation(key_code_64bit);
	}
}
