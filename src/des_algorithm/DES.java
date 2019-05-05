package des_algorithm;

import java.util.Scanner;

public class DES {
	
	static int CYCLE = 1;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] key = new char[7];
		int[] key_code_64bit = new int[64];
		int[] key_code_48bit = new int[48];
		
		//키 입력
		while(true) {
			System.out.print("what's your key?(Please, under 7 texts) : ");
			String key_enter = scan.nextLine();
			if(key_enter.length()<=0|key_enter.length()>7)
				continue;
			for(int z=0; z<key_enter.length(); z++) {
				key[z] = key_enter.charAt(z);
			}
			break;
		}
		
		//키 -> 코드변환
		key_code_64bit = transfer_code.transfer(key);
		
		//PC-1전치 (void)
		PC_1.permutation(key_code_64bit);
		
		for(int z=1; z<=16; z++) {
		//PC-2전치
		key_code_48bit = PC_2.permutation();
		
			System.out.println("====="+(CYCLE-1)+"회 사이클 암호문입니다. =====");
			for(int y=0; y<48; y++) {
				System.out.print(key_code_48bit[y]);
				if(y!=0&y%6==0)
					System.out.print(" ");
			}
			System.out.println();
		}
		
	}
}