package des_algorithm;

public class transfer_code {
	static final int[] transfer(char[] key) {
		int[] result = new int[64];
		
		int count=0;
		for(int z=0; z<key.length; z++) {
			int key_num=key[z];
			for(int y=7; y>=0; y--) {
				if(key_num-(int)Math.pow(2,y)>=0) {
					result[count]=1;
					key_num-=(int)Math.pow(2,y);
				} else {
					result[count]=0;
				}
				count++;
				if(count%8==7) { //패리티비트 입력
					result[count]=5;
					count++;
				}
			}
		}
		
		return result;
	}
}
