package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import business.*;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Formulario 
{
	private JFrame frame;
	private JLabel lblTitulo, lblMensagem, lblChave, lblResultado;
	private JTextField ftxtMensagem, ftxtChave;
	private JButton btnCriptografar;
	private Criptografar criptografar = null;
	
	public Formulario()
	{
		InicializaComponentes();
	}

	
	private void InicializaComponentes()
	{
		frame = new JFrame("Cifra de Vigenere");
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		Container painelDeConteudo = frame.getContentPane();
		
        lblTitulo = new JLabel("Cifra de Vigenere");
        lblTitulo.setBounds(175, 0, 200, 20);
        lblTitulo.setFont(new Font("Consolas", Font.BOLD, 14));
        painelDeConteudo.add(lblTitulo);

        lblMensagem = new JLabel("Mensagem");
		lblMensagem.setBounds(50, 150, 150, 20);
        lblMensagem.setFont(new Font("Arial", Font.PLAIN, 12));
        painelDeConteudo.add(lblMensagem);

        ftxtMensagem = new JTextField();
		ftxtMensagem.setBounds(150, 150, 300, 20);
		painelDeConteudo.add(ftxtMensagem);

        lblChave = new JLabel("Chave");
		lblChave.setBounds(50, 200, 150, 20);
        lblChave.setFont(new Font("Arial", Font.PLAIN, 12));
        painelDeConteudo.add(lblChave);

        ftxtChave = new JTextField();
		ftxtChave.setBounds(150, 200, 300, 20);
		painelDeConteudo.add(ftxtChave);

        btnCriptografar = new JButton("CRIPTOGRAFAR");
		btnCriptografar.setBounds(25, 250, 435, 25);
		btnCriptografar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				criptografar = new Criptografar(ftxtMensagem.getText());
                criptografar.setChave(ftxtChave.getText());
                lblResultado.setText("Resultado: " + criptografar.getMensagemCriptografada());
			}
		});
		painelDeConteudo.add(btnCriptografar);

        lblResultado = new JLabel("Resultado: ");
        lblResultado.setFont(new Font("Arial", Font.BOLD, 16));
        lblResultado.setBounds(25, 325, 400, 25);
        painelDeConteudo.add(lblResultado);

		frame.setVisible(true);
	}
}
