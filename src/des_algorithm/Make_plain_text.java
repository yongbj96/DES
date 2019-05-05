package des_algorithm;

import java.util.Scanner;

public class Make_plain_text {
	
	@SuppressWarnings("resource")
	public static final void Plain_text() {
		Scanner scan = new Scanner(System.in);
		char[] text = new char[8];
		int[] text_code_64bit = new int[64];
		
		//평문 입력
		while(true) {
			System.out.print("what's your text? (Please, under 8 texts) : ");
			String text_enter = scan.nextLine();
			if(text_enter.length()<=0|text_enter.length()>8) //평문의 길이를 수정할 수 있는 코드1 (현재 8bits)
				continue;
			for(int z=0; z<text_enter.length(); z++) //평문의 길이를 수정할 수 있는 코드2 (현재 8bits)
				text[z] = text_enter.charAt(z);
			if(text_enter.length()<8) { //평문의 길이를 수정할 수 있는 코드3 (현재 8bits)
				for(int z=text_enter.length(); z<8; z++)
					text[z] = ' ';
			}
			break;
		}
		
		int count=0;
		
		//평문 -> 코드변환
		for(int z=0; z<text.length; z++) {
			int text_num = text[z];
			for(int y=7; y>=0; y--) {
				if(text_num-(int)Math.pow(2,y)>=0) {
					text_code_64bit[count]=1;
					text_num-=(int)Math.pow(2,y);
				} else {
					text_code_64bit[count]=0;
				}
				count++;
			}
		}
		
		//64bit -> left_32bit, right_32bit
		for(int z=0; z<64; z++) {
			if(z<32)
				DES.text_left[z] = text_code_64bit[z];
			else
				DES.text_right[z-32] = text_code_64bit[z];
		}
		
		System.out.println("┌User's Plaintext┐");
		//Plain_text_left 출력
		System.out.print("L0 = ");
		for(int z=0; z<32; z++) {
			System.out.print(DES.text_left[z]);
			if(z%8==7)
				System.out.print(" ");
		}
		System.out.println();
		
		//Plain_text_right 출력
		System.out.print("R0 = ");
		for(int z=0; z<32; z++) {
			System.out.print(DES.text_right[z]);
			if(z%8==7)
				System.out.print(" ");
		}
		System.out.print("\n\n");
	}
}
