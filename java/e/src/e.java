import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class e {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int a, n, i, j, k, autores, buff;
		
		a = in.nextInt();
		n = in.nextInt();
		

		ArrayList<Integer> aVisitar = new ArrayList<Integer>();
		HashMap<Integer, Integer> nErdos = new HashMap<Integer, Integer>();
		HashMap<Integer, Boolean> visitado = new HashMap<Integer, Boolean>();
		
		ArrayList<HashSet<Integer>> l = new ArrayList<HashSet<Integer>>();
		
		for(i = 0; i < a; i++){
			k = in.nextInt();
			HashSet<Integer> s = new HashSet<Integer>();
			for(j = 0; i < k; i++){
				k = in.nextInt();
				s.add(k);
			}
			l.add(s);
		}
		
		aVisitar.add(1); //erdos
		int numErdos = 0;
		int d =0 ;
		int sum = 0;
		
		while(aVisitar.size() > 0) {
			Integer visitando = aVisitar.get(0);
			aVisitar.remove(0);
			
			if (visitado.get(visitando) != null)
				continue;
			
			if (!nErdos.containsKey(visitando)) {
				nErdos.put(visitando, numErdos);
				sum += numErdos;
			}
			d += 1;
			for(i = 0; i < l.size(); i++) {
				HashSet<Integer> s = l.get(i);
				if (!s.contains(visitando)) continue;
				for (j=0; j< s.size(); j++) {
					Iterator<Integer> it = s.iterator();
					while(it.hasNext()) {
						aVisitar.add(it.next());
					}
				}
			}
			
			numErdos +=1;
		}

		System.out.println(d + " " + (numErdos -1) + " " + sum); 
	}

}
