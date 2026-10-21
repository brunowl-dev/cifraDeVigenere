package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import business.*;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

public class Formulario 
{
	private JFrame frame;
	private JLabel lblTitulo, lblMensagem, lblChave, lblResultado, lblCripto;
	private JTextField ftxtMensagem, ftxtChave;
	private JButton btnCriptografar, btnDescriptografar;
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
		lblMensagem.setBounds(50, 50, 150, 20);
        lblMensagem.setFont(new Font("Arial", Font.PLAIN, 12));
        painelDeConteudo.add(lblMensagem);

        ftxtMensagem = new JTextField();
		ftxtMensagem.setBounds(150, 50, 300, 20);
		ftxtMensagem.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();

		        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
		            e.consume();
		        }
		    }
		});
		painelDeConteudo.add(ftxtMensagem);

        lblChave = new JLabel("Chave");
		lblChave.setBounds(50, 100, 150, 20);
        lblChave.setFont(new Font("Arial", Font.PLAIN, 12));
        painelDeConteudo.add(lblChave);

        ftxtChave = new JTextField();
		ftxtChave.setBounds(150, 100, 300, 20);
		ftxtChave.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();

		        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
		            e.consume();
		        }
		    }
		});
		painelDeConteudo.add(ftxtChave);

        btnCriptografar = new JButton("CRIPTOGRAFAR");
		btnCriptografar.setBounds(25, 150, 215, 25);
		btnCriptografar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				criptografar = new Criptografar(ftxtMensagem.getText());
                criptografar.setChave(ftxtChave.getText());
                lblCripto.setText(criptografar.getMensagemCriptografada());
			}
		});
		painelDeConteudo.add(btnCriptografar);

		btnDescriptografar = new JButton("DESCRIPTOGRAFAR");
		btnDescriptografar.setBounds(240, 150, 215, 25);
		btnDescriptografar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				criptografar = new Criptografar(ftxtMensagem.getText());
                criptografar.setChave(ftxtChave.getText());
                lblCripto.setText(criptografar.getMensagemDescriptografada());
			}
		});
		painelDeConteudo.add(btnDescriptografar);

        lblResultado = new JLabel("RESULTADO:");
        lblResultado.setFont(new Font("Arial", Font.BOLD, 16));
        lblResultado.setBounds(200, 200, 400, 25);
        painelDeConteudo.add(lblResultado);

		lblCripto = new JLabel();
        lblCripto.setFont(new Font("Arial", Font.BOLD, 16));
        lblCripto.setBounds(25, 250, 400, 50);
        painelDeConteudo.add(lblCripto);

		frame.setVisible(true);
	}
}
