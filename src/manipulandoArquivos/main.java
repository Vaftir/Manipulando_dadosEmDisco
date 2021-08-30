package manipulandoArquivos;

import java.io.RandomAccessFile;

import java.io.IOException;


public class main {

    public static void main(String[] args) {


        byte[] ba;
        RandomAccessFile arq;
        RandomAccessFile arqCliente;

        Livro l1 = new Livro(1, "Harry Potter e a pedra fliosofal", "J.K.Roling", 47.90F);
        Livro l2 = new Livro(2, "Harry Potter e a camara secreta (Exclusivo)", "J.K.Roling", 91.50F);
        Livro l3 = new Livro(3, "Harry Potter e o calice de fogo (Vers. Illustrada)", "J.K.Roling e Martin robin", 159.99F);
        Livro l4 = new Livro();
        Livro l5 = new Livro();
        Livro l6 = new Livro();

        Cliente c = new Cliente(1, "Robson","robson@gmail.com");
        Cliente c1 = new Cliente(2, "Pedro","pedro@gmail.com");
        Cliente c2 = new Cliente(1, "Jao","jao@gmail.com");
        Cliente c3 = new Cliente();
        Cliente c4 = new Cliente();

        try {

            //escrita

            arq = new RandomAccessFile("dados/livros.db", "rw");
            arqCliente = new RandomAccessFile ("dados/clientes.db", "rw");

            long cs1 = arqCliente.getFilePointer();
            ba = c1.toByteArray();
            arqCliente.writeInt(ba.length);
            arqCliente.write(ba);

            long cs2 = arqCliente.getFilePointer();
            ba = c2.toByteArray();
            arqCliente.writeInt(ba.length);
            arqCliente.write(ba);

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
            arqCliente.seek(cs1);

            tam = arqCliente.readInt();
            ba = new byte[tam];
            arqCliente.read(ba);
            c3.fromByteArray(ba);

            arqCliente.seek(cs2);

            tam = arqCliente.readInt();
            ba = new byte[tam];
            arqCliente.read(ba);
            c4.fromByteArray(ba);

            arqCliente.seek(cs2);




            /*arq.seek(p2);
            tam = arq.readInt();
            ba = new byte[tam];
            arq.read(ba);
            l5.fromByteArray(ba);

            arq.seek(p1);
            tam = arq.readInt();
            ba = new byte[tam];
            arq.read(ba);
            l6.fromByteArray(ba);*/

            System.out.println(c4);
            System.out.println(c3);
            //System.out.println(l6);


            arq.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
