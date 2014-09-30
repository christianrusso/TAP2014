/*
Ejemplo de ingreso:
3 5 
2 1 5
3 5 2 3 
3 3 2 4
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
static List< List< Integer > > ady;
	static int dist[];
	static int A,N;
	static boolean visitado[];

	
	public static void main( String args[] ){
				
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int c, u , v;
		A = in.nextInt();   //Numero de articulos
		N = in.nextInt();	//Numero de personas
		dist = new int[N+1];
		ady = new ArrayList< List< Integer > >();

		for(int i = 0; i <= N; ++i) ady.add(new ArrayList<Integer>());
	
		for( int i = 0 ; i < A ; ++i ){
			c = in.nextInt();
			int[] autores = new int[c];
			for (int j = 0; j < c; j++) {
				u = in.nextInt();
				autores[j] = u;
			}
			
			for (int j = 0; j < autores.length; j++) {
				for (int j2 = 0; j2 < autores.length; j2++) {
					ady.get(autores[j2]).add(autores[j]);
				}
				
			}
		}
		
		bfs();
		
		int D=0,M=0,S=0;
		for (int i = 0; i < visitado.length; i++) {
			if(visitado[i]){
				S += dist[i];
				M = Math.max(M, dist[i]);
				D++;
			}
		}
		
		System.out.print(D + " " + M + " " + S);
		
	}
	
	
	public static void bfs(){
		

		int ini, pasos = 0, max = 0, actual;
		visitado = new boolean[N+1];
		Arrays.fill( visitado , false );
		
		ini = 1; //nodo inciial
		
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add( ini );
		visitado[ini] = true;
		dist[ini] = 0;

		while( !Q.isEmpty() ){
			actual = Q.remove();
			
			for( int i = 0 ; i < ady.get(actual).size() ; ++i ){	    			
				int w = ady.get(actual).get(i);
				if( w != 0 && !visitado[w] ){			
					visitado[w] = true;
					Q.add(w);
					dist[w] = dist[actual] +1;
				}
			}
		}
	}
}



