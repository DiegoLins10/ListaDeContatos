
public class Contato {

	private String nome;
	private String cel;
	private String tel;
	private String end;

	public Contato(String nome, String cel, String tel, String end) {
		this.nome = nome;
		this.cel = cel;
		this.tel = tel;
		this.end = end;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String toString() {
		return nome + " " + cel + " " + tel + " " + end;
	}
}
