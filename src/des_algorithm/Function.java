package des_algorithm;

public class Function {
	static final int[] E = {32,1, 2, 3, 4, 5,
							4, 5, 6, 7, 8, 9,
							8, 9, 10, 11, 12, 13,
							12, 13, 14, 15, 16, 17,
							16, 17, 18, 19, 20, 21,
							20, 21, 22, 23, 24, 25,
							24, 25, 26, 27, 28, 29,
							28, 29, 30, 31, 32, 1};
	
	static final int[] P = {16, 7, 20, 21, 29, 12, 28, 17,
							1, 15, 23, 26, 5, 18, 31, 10,
							2, 8, 24, 14, 32, 27, 3, 9,
							19, 13, 30, 6, 22, 11, 4, 25};
	
	static final int[] Inverse_P = {57, 49, 41, 33, 25, 17, 9,
									1, 58, 50, 42, 34, 26, 18,
									10, 2, 59, 51, 43, 35, 27,
									19, 11, 3, 60, 52, 44, 36,
									63, 55, 47, 39, 31, 23, 15,
									7, 62, 54, 46, 38, 30, 22,
									14, 6, 61, 53, 45, 37, 29,
									21, 13, 5, 28, 20, 12, 4};
	
	public static int[] Expansion() {
		int[] result = new int[48];
		
		for(int z=0; z<48; z++)
			result[z] = DES.text_right[E[z]-1];
		
		return result;
	}
	
	public static int[] XOR(int[] a, int[] b) {
		int[] result = new int[a.length];
		
		for(int z=0; z<a.length; z++)
			result[z] = a[z]^b[z];
		
		return result;
	}

	public static int[] Permutation(int[] S_box) {
		int[] result = new int[32];
		
		for(int z=0; z<32; z++)
			result[z] = S_box[P[z]-1];
		
		return result;
	}

	public static int[] Permuted() {
		int[] _result = new int[64];
		int[] result = new int[56];
		
		for(int z=0; z<64; z++) {
			if(z<32)
				_result[z] = DES.text_right[z];
			else
				_result[z] = DES.text_left[z-32];
		}
		
		for(int z=0; z<56; z++)
			result[z] = _result[Inverse_P[z]-1];
		
		return result;
	}
}
