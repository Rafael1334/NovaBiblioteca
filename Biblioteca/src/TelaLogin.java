import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField pwdSenha;
    private JButton btnLogin;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    final static String LOGINPANEL = "Tela Login";
    final static String PRINCIPALPANEL = "Tela Principal";
    final static String FUNCIONARIOPANEL = "Tela Funcionario";
    final static String ALUNOPANEL = "Tela Aluno";
    final static String LIVROPANEL = "Tela Livro";
    final static String EMPRESTIMOPANEL = "Tela Emprestimo";


    public TelaLogin() {
        setSize(1080, 675);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);


        //Configuration CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        //Panel Login
        JPanel loginPanel = new JPanel(null);

        //Labels
        JLabel lblLogin = new JLabel("Login");
        lblLogin.setBounds(510, 50, 200, 40);
        lblLogin.setFont(new Font("Arial", Font.BOLD, 30));
        loginPanel.add(lblLogin);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(410, 200, 100, 27);
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 18));
        loginPanel.add(lblUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(410, 250, 100, 27);
        lblSenha.setFont(new Font("Arial", Font.BOLD, 18));
        loginPanel.add(lblSenha);

        //Text Field
        txtUsuario = new JTextField();
        txtUsuario.setBounds(510, 200, 200, 27);
        loginPanel.add(txtUsuario);

        //Password Field
        pwdSenha = new JPasswordField();
        pwdSenha.setBounds(510, 250, 200, 27);
        loginPanel.add(pwdSenha);

        // Button login
        btnLogin = new JButton("Entrar");
        btnLogin.setBounds(510, 300, 100, 27);
        loginPanel.add(btnLogin);

        // Add panel to CardLayout
        mainPanel.add(loginPanel, LOGINPANEL);
        mainPanel.add(new TelaPrincipal(this), PRINCIPALPANEL);
        mainPanel.add(new TelaFuncionario(this), FUNCIONARIOPANEL);
        mainPanel.add(new TelaAluno(this), ALUNOPANEL);
        mainPanel.add(new TelaLivro(this), LIVROPANEL);
        mainPanel.add(new TelaEmprestimo(this), EMPRESTIMOPANEL);

        // Add panel principal to JFrame
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Action button login
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtUsuario.setText("");
                pwdSenha.setText("");
                cardLayout.show(mainPanel, PRINCIPALPANEL);
            }
        });

        setVisible(true);
    }

    //Change telas
    public void trocarTela(String nomeTela){
        cardLayout.show(mainPanel, nomeTela);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaLogin::new);
    }
}