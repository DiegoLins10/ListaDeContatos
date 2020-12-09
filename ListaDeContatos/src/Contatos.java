
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
	
	public Contato remove(String codigo){
        Contato p= null;
        if (inicio==null){
            System.out.println("ERRO! Lista Vazia");
        } else {
        	NoDuplo aux = inicio;
            while (aux != null) {
                if (aux.dado.getNome().equalsIgnoreCase(codigo)) {
                    p = aux.dado;
                    if (aux.prox == null && aux.ant == null) {
                        inicio = null;
                        fim = null;

                    } else if (aux.prox == null) {
                        fim = aux.ant;
                        fim.prox = null;
                    } else if (aux.ant == null) {
                        inicio = aux.prox;
                        inicio.ant = null;
                    } else {
                        aux.ant.prox = aux.prox;
                        aux.prox.ant = aux.ant;
                    }
                    break;
                }
                aux = aux.prox;
            }
        }
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