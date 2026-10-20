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

    public void criaChave(String chave)
    {
        this.chave = new Chave(chave);
        if (chave.length() < mensagem.length())
        {
            this.chave.igualaChave(mensagem);
        }
    }

    public String getMensagemCriptografada()
    {
        return resultado;
    }

    public String getMensagem()
    {
        return mensagem;
    }
}
