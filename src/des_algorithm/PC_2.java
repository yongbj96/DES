package des_algorithm;

//permutation 2
public class PC_2 {
	//Permuted choice 2
	static final int[] PC_2 = {14, 17, 11, 24, 1, 5,
								3, 28, 15, 6, 21, 10,
								23, 19, 12, 4, 26, 8,
								16, 7, 27, 20, 13, 2,
								41, 52, 31, 37, 47, 55,
								30, 40, 51, 45, 33, 48,
								44, 49, 39, 56, 34, 53,
								46, 42, 50, 36, 29, 32};
	
	public static final int[] permutation() {
		int[] key_code_56bit = new int[56];
		int[] result = new int[48];
		int left_0 = 0, right_0 = 0;
		
		//좌측 순환이동 (1, 2, 9, 16일 때는 1회 이동)
		if(DES.CYCLE==1 | DES.CYCLE==2 | DES.CYCLE==9 | DES.CYCLE==16) {
			left_0 = PC_1.left[0];
			right_0 = PC_1.right[0];
			for(int z=0; z<27; z++) {
				PC_1.left[z] = PC_1.left[z+1];
				PC_1.right[z] = PC_1.right[z+1];
			}
			PC_1.left[27] = left_0;
			PC_1.right[27] = right_0;
		} else {
			for(int y=0; y<=1; y++) {
				left_0 = PC_1.left[0];
				right_0 = PC_1.right[0];
				for(int z=0; z<27; z++) {
					PC_1.left[z] = PC_1.left[z+1];
					PC_1.right[z] = PC_1.right[z+1];
				}
				PC_1.left[27] = left_0;
				PC_1.right[27] = right_0;
			}
		}
		
		for(int z=0; z<56; z++) {
			if(z<28)
				key_code_56bit[z] = PC_1.left[z];
			else
				key_code_56bit[z] = PC_1.right[z-28];
		}
		
		DES.CYCLE++;
		
		for(int z=0; z<48; z++) {
			result[z] = key_code_56bit[PC_2[z]-1];
		}
		
		return result;
	}
	
}
