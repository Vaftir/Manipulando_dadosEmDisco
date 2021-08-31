package manipulandoArquivos;

import java.io.IOException;


public class main {



    public static void main(String[] args) {


        byte[] ba;
        
        Arrquivo<Livro> arqLivros;
        Arrquivo<Cliente> arqCliente;

       Livro l = new Livro ("Harry Potter e a camara secreta (Exclusivo)", "J.K.Roling", 91.50F);
       Livro l1 = new Livro("Harry Potter e o calice de fogo (Vers. Illustrada)", "J.K.Roling e Martin robin", 159.99F);

        Cliente c = new Cliente( "Robson","robson@gmail.com");
        Cliente c1 = new Cliente( "Pedro","pedro@gmail.com");

        try {


            arqLivros = new Arrquivo<>("livros",Livro.class.getConstructor());
            arqCliente = new Arrquivo<>("clientes",Cliente.class.getConstructor());

            int i;
            
           arqLivros.create(l);
           arqLivros.create(l1);
           arqCliente.create(c);
            arqCliente.create(c1);



            Livro l3 = arqLivros.read(2);
            Livro l4 = arqLivros.read(1);

            Cliente c2 = arqCliente.read(1);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
