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
	
	//PC-1전치(좌측순환이동 포함)
	public static final int[] permutation(int[] parity_code) {
		int[] result = new int[56];
		int[] left = new int[28];
		int[] right = new int[28];
		int left_0=0, right_0=0;
		
		for(int z=0; z<56; z++) {
			if(z==0) 
				left_0 = parity_code[PC_1[z]-1];
			else if(z<=27)
				left[z-1] = parity_code[PC_1[z]-1];
			else if(z==28)
				right_0 = parity_code[PC_1[z]-1];
			else
				right[z-29] = parity_code[PC_1[z]-1];
		}
		left[27] = left_0;
		right[27] = right_0;
		
		for(int z=0; z<56; z++) {
			if(z<=27)
				result[z] = left[z];
			else
				result[z] = right[z-28];
		}
		
		return result;
	}
}
