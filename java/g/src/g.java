import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class g {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = in.nextInt();

		int[] p = new int[n];
		int[] v = new int[n/2];
		int s = 0;
		for(int i = 0; i < n; i++){
			p[i] = in.nextInt();
		}
		
		Arrays.sort(p);

		for (int i=0; i<n/2; i++) {
			v[i] = - p[i*2] + p[i*2+1]; 
			s+= v[i];
		}
		Arrays.sort(v);

		if (v[n/2-1] == 0) {
			System.out.println(-1);
			return;
		
		}
		for (int i=0; i<n/2; i++) {

			s -= 2*v[i];	
			if (s <= 0) {
				System.out.println(i);
				return;
			}
		}
		
	}
	
	}
