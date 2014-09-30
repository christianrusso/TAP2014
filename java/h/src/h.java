import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeSet;


public class h {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n, valor;
		TreeSet<Integer> arbol = new TreeSet<Integer>();
		n = in.nextInt();
		while(n-->0){
			valor = in.nextInt();
			Integer bajo = arbol.lower(valor);
			if(bajo != null) {
				arbol.remove(bajo);
			}
			arbol.add(valor);
		}
		System.out.println(arbol.size());
	}

}
