package manipulandoArquivos;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Cliente {


    protected String email;
    protected String nome;
    protected int idCliente;


    public Cliente() {
        idCliente = -1;
        nome = "";
        email = "";
    }

    public Cliente(int i, String n, String e) {
        idCliente = i;
        nome = n;
        email = e;
    }

    public byte[] toByteArray() throws IOException {

        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        DataOutputStream bs = new DataOutputStream(bas);
        bs.writeInt(this.idCliente);
        bs.writeUTF(this.nome);
        bs.writeUTF(this.email);

        return bas.toByteArray();
    }


    public void fromByteArray(byte[] ba) throws IOException {

        ByteArrayInputStream bti = new ByteArrayInputStream(ba);
        DataInputStream btCi = new DataInputStream(bti);

        idCliente = btCi.readInt();
        nome = btCi.readUTF();
        email = btCi.readUTF();

    }


    public String toString() {
        return "\nID: " + idCliente +
                "\nNome: " + nome +
                "\ne-mail: " + email;
    }


}
