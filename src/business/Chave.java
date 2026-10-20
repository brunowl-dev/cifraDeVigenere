package business;

public class Chave 
{
    protected String chave;

    protected void igualaChave(String mensagem)
    {
        for (int i = 0; chave.length() < mensagem.length(); i++)
        {
            this.chave += chave.charAt(i);
        }
    }

    public Chave(String chave)
    {
        this.chave = chave;
    }

    protected String getChave()
    {
        return chave;
    }
}
