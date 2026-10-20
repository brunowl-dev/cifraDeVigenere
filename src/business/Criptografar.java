package business;

public class Criptografar 
{
    protected String mensagem;
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
        int letra;
        String resultado = "";
        for (int i = 0; i < mensagem.length(); i++)
        {
            letra = (mensagem.charAt(i) + chave.getChave().charAt(i)) - 65;
            if (letra > 90)
            {
                letra -= 26;
            }
            resultado += (char) (letra);
        }
        return resultado;
    }

    public String getMensagem()
    {
        return mensagem;
    }
}
