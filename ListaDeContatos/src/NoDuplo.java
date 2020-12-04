public class NoDuplo {

	public NoDuplo ant, prox;
	public String dado;

	public NoDuplo(String nome, String tel, String cel, String end) {
		dado = nome + " " + tel + " " + cel + " " + end;
		ant = null;
		prox = null;
	}
}