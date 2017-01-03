
public class ListaLigada {
	MemoriaLL m = null;
	final int NIL = Integer.MAX_VALUE;
	int head = NIL;

	public ListaLigada(int n) {
		this.m = new MemoriaLL(n);
		this.head = NIL;

	}

	public void insert(int chave) {
		int x = this.m.allocate_object();
		this.m.next[x] = this.head;
		this.m.key[x] = chave;
		if (this.head != NIL) {
			this.m.prev[head] = x;
		}
		this.head = x;
		this.m.prev[x] = NIL;

	}

	public void delete(int x) {
		if (this.m.prev[x] != NIL) {
			this.m.next[this.m.prev[x]] = this.m.next[x];
		} else {
			this.head = this.m.next[x];
		}

		if (this.m.next[x] != NIL) {
			this.m.prev[this.m.next[x]] = this.m.prev[x];
		}
		this.m.free_object(x);
	}

	public int search(int k) {
		int x = this.head;
		System.out.println("head -> " + x);
		while (x != NIL && this.m.key[x] != k) {
			x = this.m.next[x];
			System.out.println(x);
		}
		return x;

	}

	@Override
	public String toString() {

		String s = this.m.toString() + "head -> " + this.head;
		return s;
	}
}
