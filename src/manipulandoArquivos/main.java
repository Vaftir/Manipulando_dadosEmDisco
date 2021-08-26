package manipulandoArquivos;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class main {

	public static void main(String[] args) {
		
		
		byte[] ba;
		FileOutputStream arq;
		DataOutputStream dos;
		FileInputStream arqL;
		DataInputStream dis;
		
		Livro l1 = new Livro(1, "Harry Potter e a pedra fliosofal", "J.K.Roling", 47.90F);
		Livro l2 = new Livro(2, "Harry Potter e a camara secreta (Exclusivo)", "J.K.Roling", 91.50F);
		Livro l3 = new Livro(3, "Harry Potter e o calice de fogo (Vers. Illustrada)", "J.K.Roling e Martin robin", 159.99F);
		Livro l4 = new Livro();
		Livro l5 = new Livro();
		

	
	
		try {
			
			//escrita
			
			arq = new FileOutputStream("dados/livros.db");
			dos = new DataOutputStream(arq);
			
			ba = l1.toByteArray();
			dos.writeInt(ba.length);
			dos.write(ba);
			
			ba = l2.toByteArray();
			dos.writeInt(ba.length);
			dos.write(ba);
		
				
				
			//leitura
			int tam;
			arqL = new FileInputStream("dados/livros.db");
			dis = new DataInputStream(arqL);
			
			tam = dis.readInt();
			ba = new byte [tam];
			dis.read(ba);
			l4.fromByteArray(ba);
			
			tam = dis.readInt();
			ba = new byte [tam];
			dis.read(ba);
			l5.fromByteArray(ba);
			
			System.out.println(l3);
			System.out.println(l4);
				
		    
		    
		    	
				
				
				
			arq.close();
		    
		 
		
			
			
			} catch (IOException e) {e.printStackTrace();}

	}
	

}
