package JFrameEx;

import Telas.*;
import ABC.*;

import javax.swing.*;
import java.awt.*;

public class JFrameEx extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;
    final static String LOGINPANEL = "Tela Login";
    final static String PRINCIPALPANEL = "Tela Principal";
    final static String FUNCIONARIOPANEL = "Tela Funcionario";
    final static String ALUNOPANEL = "Tela Aluno";
    final static String LIVROPANEL = "Tela Livro";
    final static String EMPRESTIMOPANEL = "Tela Emprestimo";

    private TelaLogin telaLogin;

    public JFrameEx() {
        setSize(1080, 675);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        //Configuration CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add panel to CardLayout
        mainPanel.add(new TelaLogin(this), LOGINPANEL);
        mainPanel.add(new TelaPrincipal(this), PRINCIPALPANEL);
        mainPanel.add(new TelaFuncionario(this), FUNCIONARIOPANEL);
        mainPanel.add(new TelaAluno(this), ALUNOPANEL);
        mainPanel.add(new TelaLivro(this), LIVROPANEL);
        mainPanel.add(new TelaEmprestimo(this), EMPRESTIMOPANEL);


        // Add panel principal to JFrame
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void trocarTela(String nomeTela) {
        cardLayout.show(mainPanel, nomeTela);
    }

    public void validaLogin(Login login) {
        if (login.getUsuario().equals("admin") && login.getSenha().equals("admin123")) {
            trocarTela(PRINCIPALPANEL);
        } else {
            telaLogin.showMessage("Usuário ou senha inválidos");
        }
    }

    public void sairAndEntra(String simpleName) {
        switch (simpleName) {
            case "Funcionário": {
                trocarTela(FUNCIONARIOPANEL);
                break;
            }

            case "Aluno": {
                trocarTela(ALUNOPANEL);
                break;
            }

            case "Livro": {
                trocarTela(LIVROPANEL);
                break;

            }

            case "Empréstimo": {
                trocarTela(EMPRESTIMOPANEL);
                break;
            }

            case "Sair": {
                trocarTela(LOGINPANEL);
                break;
            }

            case "Voltar": {
                trocarTela(PRINCIPALPANEL);
                break;
            }
            
        }

        System.out.println("nome da classe:  " + simpleName);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JFrameEx::new);
    }
}
