package manipulandoArquivos;

import java.text.DecimalFormat;


public class Livro {
	protected int idLivro;
	protected String titulo;
	protected String nome;
	protected float preco;
	
	DecimalFormat df = new DecimalFormat("#,##0.00");
	
	
	public Livro(int i, String t, String a, float p) {
		idLivro =i;
		titulo = t;
		nome = a;
		preco = p;
	}
	
	public Livro() {
		idLivro =-1;
		titulo = "";
		nome = "";
		preco = 0F;
	}
	
	
	public String toString() {
		
		return "\nID: " + idLivro +
				"\nTitulo: "+titulo+
				"\nNome: " + nome +
				"\nPreco: R$"+ df.format(preco);
	}
	
}