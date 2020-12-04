import javax.swing.JOptionPane;

/* 
 * @author Diego Lins
 * @author Gustavo lino
 * @author Juliane Galdino
*/
public class Main {

	public static void main(String[] args) {

		Contatos l = new Contatos();
		String menu = "Menu de Opções criando Nota fiscal\n1 - Adicionar contato\n2- Remover contato\n3 - Ver lista de contatos ";
		int op = 0;
		String telefone, nome, cel, end, remove;
		while (op != 99) {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op) {
			case 1:
				nome = JOptionPane.showInputDialog("Digite o nome do contato: ");
				telefone = JOptionPane.showInputDialog("Digite o telefone fixo: ");
				cel = JOptionPane.showInputDialog("Digite o celular: ");
				end = JOptionPane.showInputDialog("Digite o seu endereço: ");
				l.adiciona(nome, telefone, cel, end);
				JOptionPane.showMessageDialog(null, l.toString());
				System.out.println(l.toString());
				break;
			case 2:
				remove = JOptionPane.showInputDialog("Qual contato deseja apagar: ");
				l.remove(remove);
				JOptionPane.showMessageDialog(null, l.toString());
				break;
			case 3:
				JOptionPane.showMessageDialog(null, l.toString());
			}

		}
	}

}
