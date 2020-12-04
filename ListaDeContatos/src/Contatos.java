
public class Contatos {

	private NoDuplo inicio, fim;

	public Contatos() {
		inicio = null;
		fim = null;
	}

	public void adicionaInicio(String nome, String telefone, String cel, String end) {
		NoDuplo novo = new NoDuplo(nome, telefone, cel, end);
		if (inicio == null) {
			inicio = novo;
			fim = novo;
		} else {
			novo.prox = inicio;
			inicio.ant = novo;
			inicio = novo;
		}
	}

	public void adicionaFinal(String nome, String telefone, String cel, String end) {
		NoDuplo novo = new NoDuplo(nome, telefone, cel, end);
		if (inicio == null) {
			inicio = novo;
			fim = novo;
		} else {
			fim.prox = novo;
			novo.ant = fim;
			fim = novo;
		}
	}

	public void adiciona(String p, String telefone, String cel, String end){
		if (inicio == null)
            adicionaInicio(p, telefone, cel, end);
        else
            if (p.substring(0,1).compareToIgnoreCase(inicio.dado.substring(0,1)) < inicio.dado.substring(0,1).compareToIgnoreCase(p.substring(0, 1))){
                adicionaInicio(p, telefone, cel, end);
            } else if (p.substring(0,1).compareToIgnoreCase(fim.dado.substring(0,1)) > fim.dado.substring(0,1).compareToIgnoreCase(p.substring(0,1))){
                adicionaFinal(p, telefone, cel, end);
            } else{
                NoDuplo aux1=inicio, aux2=inicio;
                NoDuplo novo = new NoDuplo(p, telefone, cel, end);
                int auxiliar = aux1.dado.substring(0,1).compareToIgnoreCase(p);
                while (aux1!=null && auxiliar > p.substring(0,1).compareToIgnoreCase(aux1.dado.substring(0,1))){
                    aux2=aux1;
                    aux1=aux1.prox;
                }
                aux1.ant = novo;
                aux2.prox = novo;
                novo.ant = aux2;
                novo.prox = aux1;
            }
    }
	
	public String remove(String codigo){
        String p="";
        codigo = codigo.substring(0,1);
        if (inicio==null){
            System.out.println("ERRO! Lista Vazia");
        } else {
            if (inicio.prox==null){
                if (inicio.dado.substring(0,1).compareToIgnoreCase(codigo) == 0){
                    p=inicio.dado;
                    inicio=null;
                    fim=null;
                }
            } else {
                if (fim.dado.substring(0,1).compareToIgnoreCase(codigo) == 0){
                    p=fim.dado;
                    fim=fim.ant;
                    fim.prox=null;
                }else
                if (inicio.dado.substring(0,1).compareToIgnoreCase(codigo) == 0){
                    p=inicio.dado;
                    inicio=inicio.prox;
                    inicio.ant=null;
                } else {
                    NoDuplo aux1=inicio,aux2=null;
                    while (aux1.prox!=null && aux1.dado.substring(0,1).compareToIgnoreCase(codigo) != 0){
                        aux2=aux1;
                        aux1=aux1.prox;
                    }
                    if (aux1.dado.substring(0,1).compareToIgnoreCase(codigo) == 0){
                        p=aux1.dado;
                        aux2.prox=aux1.prox;
                    } else {
                        System.out.println("Produto nao encontrado");
                    }
                }
             }
          }
        System.out.println("Produto excluido: "  + p );
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
