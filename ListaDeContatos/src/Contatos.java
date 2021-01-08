
public class Contatos {

	private NoDuplo inicio, fim;

	public Contatos() {
		inicio = null;
		fim = null;
	}

	public void adiciona(Contato e) {
		NoDuplo novo = new NoDuplo(e);
		if (inicio == null) {
			inicio = novo;
			fim = novo;
		} else if (inicio.dado.getNome().compareToIgnoreCase(e.getNome()) < 0) {
			NoDuplo aux = inicio;
			while (aux.prox != null && aux.prox.dado.getNome().compareToIgnoreCase(e.getNome()) < 0) {
				aux = aux.prox;
			}
			novo.prox = aux.prox;
			novo.ant = aux;
			aux.prox = novo;
		} else {
			novo.prox = inicio;
			inicio.ant = novo;
			inicio = novo;
		}
	}

	public Contato remove(String nome) {
		Contato p = null;
		if (inicio == null) {
			System.out.println("ERRO! Lista Vazia");
		} else {
			if (inicio.prox == null) {
				if (inicio.dado.getNome().compareToIgnoreCase(nome) == 0) {
					p = inicio.dado;
					inicio = null;
					fim = null;
				}
			} else {
				if (fim.dado.getNome().compareToIgnoreCase(nome) == 0) {
					p = fim.dado;
					fim = fim.ant;
					fim.prox = null;

				} else {
					if (inicio.dado.getNome().compareToIgnoreCase(nome) == 0) {
						p = inicio.dado;
						inicio = inicio.prox;
						inicio.ant = null;
					} else {
						NoDuplo aux1 = inicio, aux2 = null;
						while (aux1.prox != null && aux1.dado.getNome().compareToIgnoreCase(nome) != 0) {
							aux2 = aux1;
							aux1 = aux1.prox;
						}
						if (aux1.dado.getNome().compareToIgnoreCase(nome) == 0) {
							p = aux1.dado;
							aux2.prox = aux1.prox;
						} else {
							System.out.println("Contato nao encontrado");
						}
					}
				}
			}
		}
		System.out.println("Produto excluido: " + p);
		return p;
	}

	public String toString() {
		String r = "";
		NoDuplo aux = inicio;
		while (aux != null) {
			r = r + aux.dado + " \n";
			aux = aux.prox;
		}
		return r;
	}
}