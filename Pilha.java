
public class Pilha {
	int n = 0;
	int top = -1;
	int[] S = null;

	public Pilha(int n) {
		this.n = n;
		this.top = -1;
		this.S = new int[n];
	}

	public void push(int x) {

		this.top++;
		this.S[top] = x;
	}

	public boolean stack_empty() {
		if (this.top == -1) {
			return true;
		} else {
			return false;
		}
	}

	public int pop() {
		if (stack_empty()) {
			System.err.println("underflow");
			return 0;
		} else {
			this.top--;
			return this.S[this.top + 1];
		}

	}
	@Override public String toString(){
		StringBuilder res = new StringBuilder();
		for(int x : this.S){
			res.append(x);
			res.append(" ");
			
		}
		return res.toString();
	}
}
