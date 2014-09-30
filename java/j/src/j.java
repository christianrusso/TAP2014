import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class j {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = in.nextInt();
		int[] v = new int[n+1];
		for(int i = 0; i < n; i++){
			v[i] = in.nextInt();
		}
		
		for(int c = 1; c <= n; c++) {
			int k = c;
			
			while (k < n) {
				k += v[k] + 1;
			}
			
			if (k == n) {
				System.out.println(c);
			
			}
		}

		
		
		
		
		
		
		/*
		for(int i = n-1; i >= 0; --i){
			if((i + valores[i] + 1 <= n) && (valores[i+valores[i] + 1] == 0)){
				valores[i] = 0;
			}
		}
		
		for(int i =0; i <= n; i++){
			if(valores[i] == 0){
				System.out.println(i);
			}
		}*/
	}

	
}
