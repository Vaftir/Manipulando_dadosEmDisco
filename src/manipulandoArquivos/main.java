package manipulandoArquivos;

import java.io.IOException;


public class main {



    public static void main(String[] args) {


        byte[] ba;
        
        Arrquivo<Livro> arqLivros;
        Arrquivo<Cliente> arqCliente;

       //Livro l = new Livro ("Harry Potter e a camara secreta (Exclusivo)", "J.K.Roling", 91.50F);
       //Livro l1 = new Livro("Harry Potter e o calice de fogo (Vers. Illustrada)", "J.K.Roling e Martin robin", 159.99F);

        Cliente c = new Cliente( "Robson","robson@gmail.com");
        Cliente c1 = new Cliente( "Pedro","pedro@gmail.com");

        try {


            arqLivros = new Arrquivo<>("livros",Livro.class.getConstructor());
            arqCliente = new Arrquivo<>("clientes",Cliente.class.getConstructor());

            int i,j;
            
           //arqLivros.create(l);
           //arqLivros.create(l1);

          i = arqCliente.create(c);
          c.setId(i);

          j =arqCliente.create(c1);
          c.setId(j);//arqCliente.delete(j);



            //Livro l3 = arqLivros.read(2);
           // Livro l4 = arqLivros.read(1);

            Cliente c2 = arqCliente.read(i);
            Cliente c3 = arqCliente.read(j);

            System.out.println(c3);
            System.out.println(c2);



        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
