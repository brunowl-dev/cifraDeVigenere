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

public class FormularioDescobreChave {
    private JFrame frame;
	private JLabel lblTitulo, lblMensagem, lblCriptografada, lblResultado, lblChave;
	private JTextField ftxtMensagem, ftxtCriptografada;
	private JButton btnDescobreChave;
	private Criptografar criptografar = null;
	
	public FormularioDescobreChave()
	{
		InicializaComponentes();
	}

    private void InicializaComponentes()
    {
        frame = new JFrame("Descobre Chave");
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        Container painelDeConteudo = frame.getContentPane();

        lblTitulo = new JLabel("Descobre chave");
        lblTitulo.setBounds(175, 0, 200, 20);
        lblTitulo.setFont(new Font("Consolas", Font.BOLD, 14));
        painelDeConteudo.add(lblTitulo);

        lblMensagem = new JLabel("Mensagem");
		lblMensagem.setBounds(50, 50, 150, 20);
        lblMensagem.setFont(new Font("Arial", Font.PLAIN, 12));
        painelDeConteudo.add(lblMensagem);

        ftxtMensagem = new JTextField();
		ftxtMensagem.setBounds(150, 50, 300, 20);
		painelDeConteudo.add(ftxtMensagem);

        lblCriptografada = new JLabel("Criptografada");
		lblCriptografada.setBounds(50, 100, 150, 20);
        lblCriptografada.setFont(new Font("Arial", Font.PLAIN, 12));
        painelDeConteudo.add(lblCriptografada);

        ftxtCriptografada = new JTextField();
		ftxtCriptografada.setBounds(150, 100, 300, 20);
		painelDeConteudo.add(ftxtCriptografada);

        btnDescobreChave = new JButton("DESCOBRIR CHAVE");
		btnDescobreChave.setBounds(25, 150, 150, 30);
		btnDescobreChave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				criptografar = new Criptografar(ftxtMensagem.getText());
                criptografar.setMensagemCriptografada(ftxtCriptografada.getText());
                lblChave.setText(criptografar.descobreChave());
			}
		});
		painelDeConteudo.add(btnDescobreChave);

        lblResultado = new JLabel("RESULTADO:");
        lblResultado.setFont(new Font("Arial", Font.BOLD, 16));
        lblResultado.setBounds(200, 200, 400, 25);
        painelDeConteudo.add(lblResultado);

		lblChave = new JLabel();
        lblChave.setFont(new Font("Arial", Font.BOLD, 16));
        lblChave.setBounds(25, 250, 400, 50);
        painelDeConteudo.add(lblChave);

        frame.setVisible(true);
    }
}
