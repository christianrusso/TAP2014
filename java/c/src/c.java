import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;


public class c {
	
	public static boolean signoNorma(int p1, int p2, BigInteger[] px, BigInteger[] py) {
		BigInteger x1 = px[p1]; 
		BigInteger y1 = py[p1];
		BigInteger x2 = px[p2];
		BigInteger y2 = py[p2];
		
		if (x1.equals(x2)) return true;
		
		return (x1.compareTo(x2) > 0) ^ (y1.compareTo(y2) > 0);		
	}
	public static boolean colineales(int p0, int p1, int p2, BigInteger[] px, BigInteger[] py) {
		BigInteger x1 = px[p1].subtract(px[p0]); 
		BigInteger y1 = py[p1].subtract(py[p0]);
		BigInteger x2 = px[p2].subtract(px[p0]);
		BigInteger y2 = py[p2].subtract(py[p0]);
		
		boolean z1 = x1.equals(BigInteger.ZERO);
		boolean z2 = x2.equals(BigInteger.ZERO);
		
		if (z1 && z2) return true;
		if (z1 ^ z2) return false;
		
		BigInteger g1 = x1.gcd(y1);
		BigInteger g2 = x2.gcd(y2);
		x1 = x1.divide(g1);
		x2 = x2.divide(g2);
		if (!x1.equals(x2)) return false;
		
		y1 = y1.divide(g1);
		y2 = y2.divide(g2);
		if (!y1.equals(y2)) return false;
		
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int k = in.nextInt();
		BigInteger[] px = new BigInteger[k];
		BigInteger[] py = new BigInteger[k];
		BigInteger[][] n = new BigInteger[k][k];
		int suma = 0;

		for(int i = 0; i < k; i++){
			px[i] = in.nextBigInteger();
			py[i] = in.nextBigInteger();
		}

		for(int i = 0; i < k; i++){
		for(int j = i+1; j < k; j++){
				BigInteger x, y, x2, y2, norma;
				x = px[i].subtract(px[j]).abs();
				y = py[i].subtract(py[j]).abs();
				x2 = x.pow(2);
				y2 = y.pow(2);
				norma = x2.add(y2);
				//if (signoNorma(i, j, px, py)) norma = norma.negate();
				n[i][j] = norma;
				n[j][i] = norma;
		}}

		int a, b, c, d;

		for(int i = 0+0; i < k-3; i++){
			for(int j = i+1; j < k-2; j++){
				for(int g = j+1; g < k-1; g++){
					for(int h = g+1; h < k-0; h++){
						a = b = c = d = -1;

						if ((n[i][j].equals(n[g][h])) && (n[i][h].equals(n[j][g]))) { a = i; b = j; c = g; d = h; }
						if ((n[i][j].equals(n[g][h])) && (n[i][g].equals(n[j][h]))) { a = i; b = j; c = h; d = g; }
						if ((n[i][g].equals(n[j][h])) && (n[i][h].equals(n[j][g]))) { a = i; b = g; c = j; d = h; }

						if (a == -1) continue;


						if (	(colineales(i, j, g, px, py)) ||
								(colineales(i, j, h, px, py)) ||
								(colineales(i, g, h, px, py))

								)continue;

						if (signoNorma(a, b, px, py) != signoNorma(c, d, px, py)) continue;
						//if (signoNorma(a, d, px, py) != signoNorma(c, b, px, py)) continue;
						System.out.println("" + i + ", " + j + ", " + g + ", " + h);
						suma += 1;
					}}}}

		System.out.println(suma);
	}

}