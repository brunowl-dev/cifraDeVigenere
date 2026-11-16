package business;

public class Criptografar 
{
    protected String mensagem;
    protected Chave chave;
    protected String resultado;

    public Criptografar(String mensagem)
    {
        this.mensagem = mensagem.toUpperCase().replaceAll("\\s+", "");
    }

    public void setChave(String chave)
    {
        this.chave = new Chave(chave.toUpperCase().replaceAll("\\s+", ""));
        if (this.chave.getChave().length() < mensagem.length())
        {
            this.chave.igualaChave(mensagem);
        }
    }

    public void setMensagemCriptografada(String mensagemCriptografada)
    {
        this.resultado = mensagemCriptografada.toUpperCase().replaceAll("\\s+", "");
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
        this.resultado = resultado;
        return resultado;
    }

    public String getMensagemDescriptografada()
    {
        int letra;
        String criptografada = this.getMensagemCriptografada();
        String resultado = "";

        for (int i = 0; i < criptografada.length(); i++)
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

    public String descobreChave()
    {
        int letra;
        String resultado = "", criptografada = this.resultado;

        for (int i = 0; i < mensagem.length(); i++)
        {
            letra = (criptografada.charAt(i) - mensagem.charAt(i)) + 65;
            if (letra < 65)
            {
                letra += 26;
            }
            resultado += (char) letra;
        }

        return reduzChave(resultado);
    }

    private String reduzChave(String chave)
    {
        //LIMAOLIMA
        int i;
        boolean continuar = false;
        for (i = 1; i < chave.length(); i++)
        {
            continuar = true;
            for (int j = i; j < chave.length(); j++)
            {
                if (chave.charAt(i) != chave.charAt(j - i))
                {
                    continuar = false;
                    break;
                }
            }

            if (continuar == true)
            {
            return chave.substring(0, i);
            }
        }
        
        return chave;
    }
}
