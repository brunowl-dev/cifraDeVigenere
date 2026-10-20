package business;

public class Criptografar 
{
    protected String mensagem;
    protected String resultado;
    protected Chave chave;

    public Criptografar(String Mensagem)
    {
        Mensagem.toUpperCase().replaceAll("\\s+", "");
        this.mensagem = Mensagem;
    }

    public String getMensagemCriptografada(String chave)
    {
        return resultado;
    }

    public String getMensagem()
    {
        return mensagem;
    }
}
