
public class Main {

	public static void main(String[] args) {
		/*
		 * // pilha Pilha pilha = new Pilha(2); pilha.push(5); pilha.push(7);
		 * //System.out.println(pilha.pop());
		 * 
		 * //fila de espera FilaEspera fila = new FilaEspera(3);
		 * fila.enqueue(2); fila.enqueue(3); fila.enqueue(5);
		 * System.out.println(fila.dequeue());
		 * System.out.println(fila.dequeue());
		 * System.out.println(fila.dequeue());
		 */
		// lista ligada
		ListaLigada ligada = new ListaLigada(3);
		ligada.insert(4);
		ligada.insert(2);
		ligada.insert(7);
		System.out.println(ligada.search(7));
		// ligada.insert(1);

	}
}
