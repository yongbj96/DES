package des_algorithm;

public class Output {
	public static void Function(int[] code) {
		int[] Output = {0, 0, 0, 0, 0, 0, 0, 0};
		int a=0, b=0;
		for(int z=0; z<56; z++) {
			a=z/7;
			b=z%7;
			switch(b) {
			case 0:
				Output[a]+=(code[a*7+b]*64);
				break;
			case 1:
				Output[a]+=(code[a*7+b]*32);
				break;
			case 2:
				Output[a]+=(code[a*7+b]*16);
				break;
			case 3:
				Output[a]+=(code[a*7+b]*8);
				break;
			case 4:
				Output[a]+=(code[a*7+b]*4);
				break;
			case 5:
				Output[a]+=(code[a*7+b]*2);
				break;
			case 6:
				Output[a]+=(code[a*7+b]*1);
				break;
			}
		}
		for(int z=0; z<8; z++)
			System.out.print((char)Output[z]);
	}
}
