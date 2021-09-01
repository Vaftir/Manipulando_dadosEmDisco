package manipulandoArquivos;

import java.io.File;
import java.io.IOException;


public class main {



    public static void main(String[] args) {


        byte[] ba;

        Arrquivo<Cliente> arqCliente;
        Arrquivo<Livro> arqLivro;

       Livro l = new Livro ("Harry Potter e a camara secreta (Exclusivo)", "J.K.Roling", 91.50F);
       Livro l1 = new Livro("Harry Potter e o calice de fogo (Vers. Illustrada)", "J.K.Roling e Martin robin", 159.99F);
       Livro l3 = new Livro("Harry potter e as reliquias da morte P1 e 2 (Vers. Illustrada)", "J.K.Roling e Martin robin", 359.99F);

       // Cliente c = new Cliente( "Robson Whishkaiser Yormugandir","godsnake21@gmail.com");
        //Cliente c1 = new Cliente( "Pedro Euzebio da silva","paodequeijo69@gmail.com");
       // Cliente c2 = new Cliente( "Marcio Cerviote de Nogueira","mcnogueirinha@gmail.com");

        try {

            File f = new File("dados/livros/arquivo.db");
            f.delete();


            int i,j,k; //ids

            arqLivro = new Arrquivo<>("livros", Livro.class.getConstructor());

            //cria os clientes
            i = arqLivro.create(l);
            l.setId(i);
            j =arqLivro.create(l1);
            l1.setId(j);
            k =arqLivro.create(l3);
            l3.setId(k);

            //Pesquisa os clientes
            Livro l4 = arqLivro.read(i);
            Livro l5 = arqLivro.read(j);
            Livro l6 = arqLivro.read(k);

            //mostra na tela os clientes pesquisados
            System.out.println("Resultado de Livros: ");
            System.out.println(l4);
            System.out.println(l5);
            System.out.println(l6);

            // Excluir um livro e mostra que não existe mais
            arqLivro.delete(k);
            l6 = arqLivro.read(k);

            if(l6 == null) {
                System.out.println("\nLivro "+k+" deletado: "+ l6);
            } else {
                System.out.println(l6);
            }

            //Update

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
