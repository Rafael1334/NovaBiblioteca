package JFrameEx;

import model.*;
import view.telas.*;

import javax.swing.*;
import java.awt.*;

public class JFramePrincipal extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;
    final static String LOGINPANEL = "Tela Login";
    final static String MENUPANEL = "Tela Menu";
    final static String FUNCIONARIOPANEL = "Tela Funcionario";
    final static String USUARIOPANEL = "Tela Aluno";
    final static String LIVROPANEL = "Tela Livro";
    final static String EMPRESTIMOPANEL = "Tela Emprestimo";

    private TelaLogin telaLogin;

    public JFramePrincipal() {

        setSize(1080, 675);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        //Configuration CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add panel to CardLayout
        mainPanel.add(new TelaLogin(this), LOGINPANEL);
        mainPanel.add(new TelaMenu(this), MENUPANEL);
        mainPanel.add(new TelaFuncionario(this), FUNCIONARIOPANEL);
        mainPanel.add(new TelaUsuario(this), USUARIOPANEL);
        mainPanel.add(new TelaLivro(this), LIVROPANEL);
        mainPanel.add(new TelaEmprestimo(this), EMPRESTIMOPANEL);


        // Add panel principal to JFrame
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void validaLogin(Login login) {
        if (login.getUsuario().equals("123") && login.getSenha().equals("123")) {
            trocarTela(MENUPANEL);
        } else {
            JOptionPane.showMessageDialog(telaLogin, "Usuário ou senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void trocarTela(String nomeTela) {

        switch (nomeTela) {
            case "Funcionário":
                cardLayout.show(mainPanel, FUNCIONARIOPANEL);
                break;

            case "Usuário":
                cardLayout.show(mainPanel, USUARIOPANEL);
                break;

            case "Livro":
                cardLayout.show(mainPanel, LIVROPANEL);
                break;

            case "Empréstimo":
                cardLayout.show(mainPanel, EMPRESTIMOPANEL);
                break;

        }

        cardLayout.show(mainPanel, nomeTela);

        System.out.println("nome da tela:  " + nomeTela);
    }

    public void voltar(String simpleName) {
        switch (simpleName) {
            case "Menu":
                trocarTela(LOGINPANEL);
                break;

            default:
                trocarTela(MENUPANEL);
                break;
        }

        System.out.println("nome da classe:  " + simpleName);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JFramePrincipal::new);
    }
}
