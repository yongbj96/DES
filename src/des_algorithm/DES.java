package des_algorithm;

public class DES {
	
	static int CYCLE = 1;
	
	static int[] text_left = new int[32];
	static int[] text_right = new int[32];
	
	
	public static void main(String[] args) {
		int[] key_code_48bit = new int[48];
		
		//키 생성, PC-1전치까지 연산
		Make_Key.Create_Key();
		
		//평문입력, 8bits까지 연산
		Make_plain_text.Plain_text();
		
		//싸이클 연산
		for(int z=1; z<=16; z++) {
			
			//PC-2전치
			key_code_48bit = PC_2.permutation();
		
			System.out.println("===== Cycle Number : "+CYCLE+" =====");
			System.out.printf("Key%d: ", CYCLE);
			for(int y=0; y<48; y++) {
				System.out.print(key_code_48bit[y]);
				if(y!=0&y%6==0)
					System.out.print(" ");
			}
			System.out.println();
			
			CYCLE++;
		}
	}
}