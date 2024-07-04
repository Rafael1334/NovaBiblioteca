import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JPanel {

    private JButton btnFuncionario;
    private JButton btnAluno;
    private JButton btnLivro;
    private JButton btnEmprestimo;
    private JButton btnLogOut;


    public TelaPrincipal(TelaLogin telaLogin) {
        setLayout(null);

        // Buttons
        btnFuncionario = new JButton("Funcionário");
        btnFuncionario.setBounds(200, 100, 300, 200);
        btnFuncionario.setFont(new Font("Arial", Font.BOLD, 24));
        add(btnFuncionario);

        btnAluno = new JButton("Aluno");
        btnAluno.setBounds(550, 100, 300, 200);
        btnAluno.setFont(new Font("Arial", Font.BOLD, 24));
        add(btnAluno);

        btnLivro = new JButton("Livro");
        btnLivro.setBounds(200, 350, 300, 200 );
        btnLivro.setFont(new Font("Arial", Font.BOLD, 24));
        add(btnLivro);

        btnEmprestimo = new JButton("Empréstimo");
        btnEmprestimo.setBounds(550, 350, 300, 200);
        btnEmprestimo.setFont(new Font("Arial", Font.BOLD, 24));
        add(btnEmprestimo);

        btnLogOut = new JButton("Sair");
        btnLogOut.setBounds(50, 600, 100, 27);
        add(btnLogOut);

        //Action Buttons
        btnFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaLogin.trocarTela(TelaLogin.FUNCIONARIOPANEL);
            }
        });

        btnAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaLogin.trocarTela(TelaLogin.ALUNOPANEL);
            }
        });

        btnLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaLogin.trocarTela(TelaLogin.LIVROPANEL);
            }
        });

        btnEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaLogin.trocarTela(TelaLogin.EMPRESTIMOPANEL);
            }
        });

        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaLogin.trocarTela(TelaLogin.LOGINPANEL);
            }
        });

    }
}