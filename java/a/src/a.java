import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class a {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = in.nextInt();
		int valor;
		int k = -1;
		String palo = "";
		String u = ".";
		int fin = 0;
		while(n-->0){
			valor = in.nextInt();
			palo = in.next();
			if (fin==1) continue;
			if((valor == k) || palo.equals(u)){
				System.out.println("M");
				fin = 1;
				return;
			}		
			k = valor;
			u = palo;
		}
		System.out.println("B");

	}

}
