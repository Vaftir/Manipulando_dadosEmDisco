package manipulandoArquivos;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class main {

	public static void main(String[] args) {
		
	Livro l1 = new Livro(1, "Harry Potter e a pedra fliosofal", "J.K.Roling", 47.90F);
	Livro l2 = new Livro(2, "Harry Potter e a camara secreta (Exclusivo)", "J.K.Roling", 91.50F);
	Livro l3 = new Livro(3, "Harry Potter e o calice de fogo (Vers. Illustrada)", "J.K.Roling e Martin robin", 159.99F);
	Livro l4 = new Livro();
	Livro l5 = new Livro();
	
	
	//System.out.println(l1);
	//System.out.println(l2);
	//System.out.println(l3);
	
	
		try {
			
				//escrita
				FileOutputStream arq = new FileOutputStream("dados/livros.db");
				DataOutputStream dos = new DataOutputStream(arq);
				
				//leitura
				FileInputStream arq_leitura = new FileInputStream("dados/livros.db");
				DataInputStream dos_leitura = new DataInputStream(arq_leitura);
				
			
		//		ESCRITA
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
						
			
			
			
			    l4.idLivro = dos_leitura.readInt();
			    l4.titulo = dos_leitura.readUTF();
			    l4.nome = dos_leitura.readUTF();
			    l4.preco = dos_leitura.readFloat();
			    System.out.println(l4);
		    
		    	l5.idLivro = dos_leitura.readInt();
		    	l5.titulo = dos_leitura.readUTF();
		    	l5.nome = dos_leitura.readUTF();
		    	l5.preco = dos_leitura.readFloat();
		    	System.out.println(l5);
		    
	
	//	   		 System.out.println(l5);
		    
		    	dos.close();
		    	arq.close();
		    
		    	dos_leitura.close();
		
			
			
			} catch (IOException e) {e.printStackTrace();}

	}
	

}
