import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {

	int[] array = null;
	LinkedList[] T = null;
	int m = 0;
	int n = 0;

	public HashTable(int m, int n) {

		this.array = new int[m];
		this.m = m;
		this.n = n;
		this.T = new LinkedList[m];

		for (int k = 0; k < m; k++) {
			this.T[k] = new LinkedList<Integer>();
		}

	}

	private int hash_function_division(int k) {

		return k % this.m;
	}

	private int hash_function_mul(int k) {
		final double A = Math.sqrt(5) - 1 / 2.0;
		return (int) Math.floor(this.m * (k * A) % 1);
	}

	public void insert(int key) {
		int h = this.hash_function_division(key);
		System.out.println("chave -> " + key + "hash = " + h);
		this.T[h].add(key);
	}

	public String search(int k) {
		int h = this.hash_function_division(k);
		Integer K = k;
		Integer x = (Integer) this.T[h].get(K);
		return "----\nh = " + h + " x = " + x;

	}
}
