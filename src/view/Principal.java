package view;
import business.*;

public class Principal {
    public static void main(String[] args)
    {
        Criptografar mensagem = new Criptografar("maria luiza");
        System.out.println("MENSAGEM ORIGINAL: " + mensagem.getMensagem());
        mensagem.criaChave("mochi");
        System.out.println("resultado: " + mensagem.getMensagemCriptografada());
    }
}
