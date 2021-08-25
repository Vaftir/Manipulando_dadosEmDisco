package manipulandoArquivos;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class main {

	public static void main(String[] args) {
		
	Livro l1 = new Livro(1, "Harry Potter e a pedra fliosofal", "J.K.Roling", 47.90F);
	Livro l2 = new Livro(2, "Harry Potter e a camara secreta (Exclusivo)", "J.K.Roling", 91.50F);
	Livro l3 = new Livro(3, "Harry Potter e o calice de fogo (Vers. Illustrada)", "J.K.Roling e Martin robin", 159.99F);
	
	System.out.println(l1);
	System.out.println(l2);
	System.out.println(l3);
	
	
	try {
		
		FileOutputStream arq = new FileOutputStream("dados/livros.db");
		
		DataOutputStream dos = new DataOutputStream(arq);
		
		dos.writeInt(l1.idLivro);
		dos.writeUTF(l1.titulo);
		dos.writeUTF(l1.nome);
		dos.writeFloat(l1.preco);
		
		
		dos.writeInt(l2.idLivro);
		dos.writeUTF(l2.titulo);
		dos.writeUTF(l2.nome);
		dos.writeFloat(l2.preco);
		
		dos.writeInt(l3.idLivro);
		dos.writeUTF(l3.titulo);
		dos.writeUTF(l3.nome);
		dos.writeFloat(l3.preco);
		
	
		
		dos.close();
	    arq.close();
	
	
		
		
	} catch (IOException e) {e.printStackTrace();}

	}
	

}
