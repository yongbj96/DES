package des_algorithm;

public class Output {
	public static void Function(int[] code) {
		int[] Output = {0, 0, 0, 0, 0, 0, 0, 0};
		
		for(int z=0; z<8; z++)
			for(int y=0; y<8; y++)
				Output[z]+=(code[z*8+y]*Math.pow(2, 7-y));
		
		for(int z=0; z<8; z++)
			System.out.print(Output[z]+" ");
		System.out.println();
		
		for(int z=0; z<8; z++)
			System.out.print((char)Output[z]);
	}
}
