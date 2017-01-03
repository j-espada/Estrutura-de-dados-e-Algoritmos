
public class FilaEspera {
	int length = 0;
	int[] Q = null;
	int tail = 0;
	int head = 0;

	public FilaEspera(int n) {
		this.length = n ;
		this.Q = new int[this.length];
		this.tail = 0;
		this.head = 0;
	}

	public void enqueue(int x) {
		this.Q[this.tail] = x;

		if (this.tail == this.Q.length) {
			this.tail = 0;
		} else {
			this.tail = this.tail + 1;
		}
	}

	public int dequeue() {
		int x = this.Q[this.head];
		if (this.head == this.length) {
			this.head = 0;
		} else {
			this.head = this.head + 1;
		}
		return x;
	}

}
