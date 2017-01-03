
public class Main {

	public static void main(String[] args) {

		HashTable h = new HashTable(5, 10);

		for (int k = 0; k < 34; k++) {
			h.insert(k);
		}

		System.out.println(h.search(6));
	}
}
