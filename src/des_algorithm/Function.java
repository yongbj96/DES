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
	
	static final int[] Inverse_IP = {40, 8, 48, 16, 56, 24, 64, 32,
									39, 7, 47, 15, 55, 23, 63, 31,
									38, 6, 46, 14, 54, 22, 62, 30,
									37, 5, 45, 13, 53, 21, 61, 29,
									36, 4, 44, 12, 52, 20, 60, 28,
									35, 3, 43, 11, 51, 19, 59, 27,
									34, 2, 42, 10, 50, 18, 58, 26,
									33, 1, 41, 9, 49, 17, 57, 25};
	
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
		int[] result = new int[64];
		
		for(int z=0; z<64; z++) {
			if(z<32)
				_result[z] = DES.text_right[z];
			else
				_result[z] = DES.text_left[z-32];
		}
		
		for(int z=0; z<56; z++)
			result[z] = _result[Inverse_IP[z]-1];
		
		for(int z=0; z<64; z+=8)
			result[z] = 0;
		
		//강제로 Output 설정하기
		String text = "0110100100100000011011000110111101110110011001010010000001110101";
		for(int z=0; z<64; z++) {
			result[z] = Character.getNumericValue(text.charAt(z));
		}
		
		return result;
	}
}
