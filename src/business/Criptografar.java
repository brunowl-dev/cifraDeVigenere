package business;

public class Criptografar 
{
    protected String mensagem;
    protected Chave chave;

    public Criptografar(String mensagem)
    {
        this.mensagem = mensagem.toUpperCase().replaceAll("\\s+", "");
    }

    public void setChave(String chave)
    {
        this.chave = new Chave(chave.toUpperCase().replaceAll("\\s+", ""));
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
            resultado += (char) letra;
        }
        return resultado;
    }

    public String getMensagemDescriptografada()
    {
        int letra;
        String resultado = "";
        String criptografada = this.getMensagemCriptografada();

        for (int i = 0; i < mensagem.length(); i++)
        {
            letra = (criptografada.charAt(i) - chave.getChave().charAt(i)) + 65;
            if (letra < 65)
            {
                letra += 26;
            }
            resultado += (char) letra;
        }

        return resultado;
    }
}
