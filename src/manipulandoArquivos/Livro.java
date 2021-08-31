package manipulandoArquivos;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Livro implements registros{
	protected int idLivro;
	protected String titulo;
	protected String nome;
	protected float preco;

	DecimalFormat df = new DecimalFormat("#,##0.00");

	public Livro( String t, String a, float p) {
		idLivro = -1;
		titulo = t;
		nome = a;
		preco = p;
	}

	public Livro() {
		idLivro = -1;
		titulo = "";
		nome = "";
		preco = 0F;
	}

	public String toString() {

		return "\nID: " + idLivro +
				"\nTitulo: " + titulo +
				"\nNome: " + nome +
				"\nPreco: R$" + df.format(preco);
	}

	public byte[] toByteArray() throws IOException { /// cria um vetor de bytes e escreve no arquivo

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream das = new DataOutputStream(baos);

		das.writeInt(idLivro);
		das.writeUTF(titulo);
		das.writeUTF(nome);
		das.writeFloat(preco);

		return baos.toByteArray();

	}

	public void fromByteArray(byte[] ba) throws IOException {/// CARREAGA OS VALORES DOS ARQUIVOS NO VETOR

		ByteArrayInputStream bais = new ByteArrayInputStream(ba);
		DataInputStream dis = new DataInputStream(bais);

		idLivro = dis.readInt();
		titulo = dis.readUTF();
		nome = dis.readUTF();
		preco = dis.readFloat();

	}

	public void setId(int id){
		this.idLivro =id;
	}

	public int getID() {
		return this.idLivro;
	}

}