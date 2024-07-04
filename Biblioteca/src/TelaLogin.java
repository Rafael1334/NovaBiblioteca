import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class TelaLogin extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField pwdSenha;
    private JButton btnLogin;
    private JPanel mainPanel;
    private JPanel loginPanel;
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
        loginPanel = new JPanel(null);

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
                getLogin();
            }
        });

        setVisible(true);
    }

    //Change telas
    public void trocarTela(String nomeTela){
        cardLayout.show(mainPanel, nomeTela);
    }

    //Login
    public void getLogin(){
        String usuario = txtUsuario.getText().trim();
        String senha = String.valueOf(pwdSenha.getPassword());

        if(usuario.isEmpty() || senha.isEmpty()){
            JOptionPane.showMessageDialog( loginPanel,"Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Login login = new Login(usuario, senha);

        System.out.println("Usuario: " + usuario + "    Senha: " + senha + "    " + login); // --------> Tirar

        txtUsuario.setText("");
        pwdSenha.setText("");

        cardLayout.show(mainPanel, PRINCIPALPANEL);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaLogin::new);
    }
}