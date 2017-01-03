import java.util.ArrayList;
import java.util.List;

public class Vertice implements Comparable<Vertice> {

	private String name;
	private boolean visitado = false;
	private List<Vertice> adj;

	public Vertice(String name) {
		this.name = name;
		this.adj = new ArrayList<>();
	}

	public String getName() {
		return this.name;
	}

	public boolean isVisitado() {
		return this.visitado;
	}

	public List<Vertice> getAdj() {
		return this.adj;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public void adicionar(Vertice e) {
		this.adj.add(e);
	}

	public void imprimirAdj() {
		for (Vertice n : this.adj) {
			System.out.println(n);

		}
	}

	@Override
	public String toString() {

		return "Nome -> " + this.name + " Visitado :" + this.visitado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adj == null) ? 0 : adj.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (visitado ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertice other = (Vertice) obj;
		if (adj == null) {
			if (other.adj != null)
				return false;
		} else if (!adj.equals(other.adj))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (visitado != other.visitado)
			return false;
		return true;
	}

	@Override
	public int compareTo(Vertice arg0) {
		int res = 0;
		if (this.name.equals(arg0.getName())) {
			res = 0;
		} else
			res = -1;

		return res;

	}
}
