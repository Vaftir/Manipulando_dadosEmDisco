package manipulandoArquivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

public class Arrquivo <T extends registros> {//obs tipos genericos sao interfaces n classes a classe que implementa a interface
    RandomAccessFile arquivo;
    Constructor<T> constructor;
    final int TAM_CABECALHO = 4;

    public Arrquivo(String nomeArquivo, Constructor<T> c) throws Exception {
        File f = new File("dados");
        if (!f.exists()) {
            f.mkdir();
        }
        f = new File("dados/" + nomeArquivo);
        if (!f.exists()) {
            f.mkdir();
        }
        arquivo = new RandomAccessFile("dados/" + nomeArquivo + "/arquivo.db", "rw");
        constructor = c;
        if (arquivo.length() == 0) {
            arquivo.writeInt(0);
        }

    }

    public int create(T object) throws  Exception {

        arquivo.seek(0);
        int ultimoID = arquivo.readInt();
        int proximoID = ultimoID + 1;
        arquivo.seek(0);
        arquivo.writeInt(proximoID);

        arquivo.seek(arquivo.length());

        object.setId(proximoID);
        byte[] ba = object.toByteArray();
        arquivo.writeByte(' ');
        arquivo.writeInt(ba.length);
        arquivo.write(ba);

        return proximoID;
    }

    public T read (int idProcurado) throws Exception {

        arquivo.seek(TAM_CABECALHO);//Pular o cabecalho e ir para o registro;
        T object= constructor.newInstance();
        byte lapide;
        int tam;
        byte[] ba;

        while(arquivo.getFilePointer() < arquivo.length()){

            lapide = arquivo.readByte();
            tam = arquivo.readInt();

            if(lapide == ' ') {

                ba = new byte[tam];
                arquivo.read(ba);
                object.fromByteArray(ba);

                if(object.getID() == idProcurado)
                    return object;
            } else
                arquivo.skipBytes(tam);

        }

        return null;
    }

    /**
    * @param ld - Id de do objeto que sera excluido
    * @return true- se ofi excluido ou false se o objeto nao foi encontrado
    */
    public boolean delete(int ld) throws Exception {
        // Movendo o ponteiro para primeiro registro (após cabeçalho).
        arquivo.seek(TAM_CABECALHO);

        while(arquivo.getFilePointer() < arquivo.length()) {
            // Salvando posição do ponteiro.
            long pos = arquivo.getFilePointer();
            // Leitura de Lapide & Tamanho do Registro.
            byte lapide = arquivo.readByte();
            int tam = arquivo.readInt();

            if(lapide == ' ') {
                // extraindo obj.
                T obj = constructor.newInstance();
                byte[] ba = new byte[tam];
                arquivo.read(ba);
                obj.fromByteArray(ba); // criação do obj.
                if(obj.getID() == ld) {
                    // Retornando a posicao da lapide e marcando como excluido.
                    arquivo.seek(pos);
                    arquivo.writeByte('*');
                    return true;
                }
            }
        }
        return false;
    }

    public boolean update(T newObject) throws Exception {
        arquivo.seek(TAM_CABECALHO);//Pular o cabecalho e ir para o registro;

        T objLido = constructor.newInstance();
        int tam;
        byte lapide;
        byte[] ba;
        long position;

        while (arquivo.getFilePointer() < arquivo.length()){
            //pega a posicao do ponteiro
            position = arquivo.getFilePointer();

            //le os dados necessarios tamanho e o lapide
            lapide= arquivo.readByte();
            tam = arquivo.readInt();

            if(lapide == ' '){

                //Tira o objeto desatualizado do registro
                ba = new byte[tam];
                arquivo.read(ba);
                objLido.fromByteArray(ba);

                //verifica se e o objeto necessario
                if(objLido.getID() == newObject.getID()){

                    //cria um novo registro para o Novo objeto
                    byte[] ba2 = newObject.toByteArray();
                    newObject.fromByteArray(ba2);//Novo objeto ok

                    //se o tamanho for menor ou igual ele ocupa o mesmo espaço
                    if(ba2.length <= ba.length){

                        arquivo.seek(position);
                        arquivo.write(ba2[ba2.length-1]);
                   //se nao ele exclui esse registro e coloca no final do arquivo
                    }else{

                        arquivo.seek(position);
                        arquivo.writeByte('*');//marca como deletado aquela pos

                        arquivo.seek(arquivo.length());
                        arquivo.writeByte(ba2[ba2.length -1]);
                    }

                    return true;
                }
            }
        }
        return false;
    }



}
