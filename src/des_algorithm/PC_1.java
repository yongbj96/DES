package des_algorithm;

//permutation 1
public class PC_1 {
	//Permuted choice 1
	static final int[] PC_1 = {57, 49, 41, 33, 25, 17, 9,
								1, 58, 50, 42, 34, 26, 18,
								10, 2, 59, 51, 43, 35, 27,
								19, 11, 3, 60, 52, 44, 36,
								63, 55, 47, 39, 31, 23, 15,
								7, 62, 54, 46, 38, 30, 22,
								14, 6, 61, 53, 45, 37, 29,
								21, 13, 5, 28, 20, 12, 4};
	
	static int[] key_left = new int[28];
	static int[] key_right = new int[28];
	
	//PC-1전치
	public static final void permutation(int[] key_code_64bit) {
		for(int z=0; z<56; z++) {
			if(z<=27)
				key_left[z] = key_code_64bit[PC_1[z]-1];
			else
				key_right[z-28] = key_code_64bit[PC_1[z]-1];
		}
	}
}
