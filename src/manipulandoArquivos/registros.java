package manipulandoArquivos;

public interface registros {
    public byte[] toByteArray() throws Exception;
    public void fromByteArray(byte[] ba) throws Exception;
    void setId(int proximoID);

    public int getID();
}
