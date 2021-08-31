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
        File f = new File(nomeArquivo);
        if(!f.exists()){
            f.mkdir();
        }
        arquivo = new RandomAccessFile( nomeArquivo +"/dados.db","rw");
        constructor = c;

        if(arquivo.length() == 0){
            arquivo.write(0);
        }

    }

    public int create(T object) throws  Exception {

        arquivo.seek(0);

        int ultimoID = arquivo.read();
        int nextID = ultimoID + 1;

        arquivo.seek(0);
        arquivo.writeInt(nextID);

        arquivo.seek(arquivo.length());

        object.setId(nextID);

        byte[] ba = object.toByteArray();

        arquivo.writeByte(' ');
        arquivo.writeInt(ba.length);
        arquivo.write(ba);

        return nextID;
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
            }
            else
                arquivo.skipBytes(tam);

        }

        return null;
    }

}
