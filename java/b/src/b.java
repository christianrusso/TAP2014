import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class b {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = in.nextInt();
		String s = "";
		while(n > 0){
			if(n%3 == 0){
				s = "0" + s;
				n = n/3;
			}else if(n%3 == 1){
				s = "+" + s;
				n = n/3;
			}else if(n%3 == 2){
				s = "-" + s;
				n = (n+1)/3;
			}
			
		}
		
		System.out.println(s);
		

	}

}
