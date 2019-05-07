package des_algorithm;

import java.util.Scanner;

public class Make_plain_text {
	
	static final int[] IP = {58, 50, 42, 34, 26, 18, 10, 2,
							60, 52, 44, 36, 28, 20, 12, 4,
							62, 54, 46, 38, 30, 22, 14, 6,
							64, 56, 48, 40, 32, 24, 16, 8,
							57, 49, 41, 33, 25, 17, 9, 1,
							59, 51, 43, 35, 27, 19, 11, 3,
							61, 53, 45, 37, 29, 21, 13, 5,
							63, 55, 47, 39, 31, 23, 15, 7};
	
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
			if(text_enter.length()<8) //평문의 길이를 수정할 수 있는 코드3 (현재 8bits)
				for(int z=text_enter.length(); z<8; z++)
					text[z] = ' ';
			break;
		}
		
		//평문 -> 코드변환
		int count=0;
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
		System.out.print("Input Text: ");
		for(int z=0; z<64; z++) {
			if(z!=0&z%8==0)
				System.out.print(" ");
			System.out.print(text_code_64bit[z]);
		}
		System.out.print("\n\n");
		
//		절대적인 텍스트 입력 (**************************************************)
//		String Abs_text = "";
//		for(int z=0; z<64; z++)
//			text_code_64bit[z] = (int)Abs_text.charAt(z);
		
		//IP전치, 64bit -> left_32bit, right_32bit
		for(int z=0; z<64; z++) {
			if(z<32)
				DES.text_left[z] = text_code_64bit[IP[z]-1];
			else
				DES.text_right[z-32] = text_code_64bit[IP[z]-1];
		}
		
		//Plain_text_left 출력
		System.out.print("┌User's Plaintext┐\nL0 = ");
		for(int z=0; z<32; z++) {
			if(z!=0&z%7==0)
				System.out.print(" ");
			System.out.print(DES.text_left[z]);
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
