package des_algorithm;

public class DES {
	
	static int CYCLE = 1;
	
	static int[] text_left = new int[32];
	static int[] text_right = new int[32];
	
	
	public static void main(String[] args) {
		int[] E_text_right_48bit = new int[48];
		int[] key_code_48bit = new int[48];
		int[] XOR_48bit = new int[48];
		int[] XOR_32bit = new int[32];
		int[] Sbox_P_32bit = new int[32];
		int[] Output_code = new int[56];
		
		//키 생성, PC-1전치까지 연산
		Input.Function();
		
		//평문입력,IP전치까지 연산 , 길이 : 8bits
		Make_plain_text.Plain_text();
		
		//싸이클 연산
		for(int z=1; z<=16; z++) {
			
			//text_right 확장전치
			E_text_right_48bit = Function.Expansion();
			
			//PC-2전치
			key_code_48bit = PC_2.permutation();
			
			//XOR연산
			XOR_48bit = Function.XOR(E_text_right_48bit, key_code_48bit);
			
			//S-box
			Sbox_P_32bit = S_box.function(XOR_48bit);
			
			//P 전치
			Sbox_P_32bit = Function.Permutation(Sbox_P_32bit);
			
			//text_left = text_right, text_right = text_left XOR text_right
			XOR_32bit = Function.XOR(Sbox_P_32bit, text_left);
			text_left = text_right;
			text_right = XOR_32bit;
			
			System.out.println("===== Cycle Number : "+CYCLE+" =====");
			
			System.out.printf("Expansion R%d: ", CYCLE);
			for(int y=0; y<48; y++) {
				if(y!=0&y%6==0)
					System.out.print(" ");
				System.out.print(E_text_right_48bit[y]);
			}
			System.out.println();
			
			System.out.printf("    Key%d   : ", CYCLE);
			for(int y=0; y<48; y++) {
				if(y!=0&y%6==0)
					System.out.print(" ");
				System.out.print(key_code_48bit[y]);
			}
			System.out.println();
			
			System.out.printf("R%d XOR Key%d: ", CYCLE, CYCLE);
			for(int y=0; y<48; y++) {
				if(y!=0&y%6==0)
					System.out.print(" ");
				System.out.print(XOR_48bit[y]);
			}
			System.out.print("\n\n");
			
			CYCLE++;
		}
		
		Output_code = Function.Permuted();
		Output.Function(Output_code);
	}
}