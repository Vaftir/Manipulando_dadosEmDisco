package manipulandoArquivos;

import java.io.RandomAccessFile;

import java.io.IOException;


public class main {

    public static void main(String[] args) {


        byte[] ba;
        RandomAccessFile arq;

        Livro l1 = new Livro(1, "Harry Potter e a pedra fliosofal", "J.K.Roling", 47.90F);
        Livro l2 = new Livro(2, "Harry Potter e a camara secreta (Exclusivo)", "J.K.Roling", 91.50F);
        Livro l3 = new Livro(3, "Harry Potter e o calice de fogo (Vers. Illustrada)", "J.K.Roling e Martin robin", 159.99F);
        Livro l4 = new Livro();
        Livro l5 = new Livro();
        Livro l6 = new Livro();


        try {

            //escrita

            arq = new RandomAccessFile("dados/livros.db", "rw");

            long p1 = arq.getFilePointer();
            ba = l1.toByteArray();
            arq.writeInt(ba.length);
            arq.write(ba);

            long p2 = arq.getFilePointer();
            ba = l2.toByteArray();
            arq.writeInt(ba.length);
            arq.write(ba);

            long p3 = arq.getFilePointer();
            ba = l3.toByteArray();
            arq.writeInt(ba.length);
            arq.write(ba);


            //leitura
            int tam;
            arq.seek(p3);

            tam = arq.readInt();
            ba = new byte[tam];
            arq.read(ba);
            l4.fromByteArray(ba);


            arq.seek(p2);
            tam = arq.readInt();
            ba = new byte[tam];
            arq.read(ba);
            l5.fromByteArray(ba);

            arq.seek(p1);
            tam = arq.readInt();
            ba = new byte[tam];
            arq.read(ba);
            l6.fromByteArray(ba);

            System.out.println(l4);
            System.out.println(l5);
            System.out.println(l6);


            arq.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
