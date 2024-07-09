package Telas;

import ABC.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelLogin extends JPanel {
    private final TelaLogin telaLogin;
    private JTextField txtUsuario;
    private JPasswordField pwdSenha;
    private JButton btnLogin;


    public JPanelLogin(TelaLogin telaLogin) {
        this.telaLogin = telaLogin;
        showLayout();

    }

    private void showLayout() {
        setLayout(null);
        JLabel lblLogin = new JLabel("Super ABC.Login");
        lblLogin.setBounds(510, 50, 200, 40);
        lblLogin.setFont(new Font("Arial", Font.BOLD, 30));
        add(lblLogin);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(410, 200, 100, 27);
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(410, 250, 100, 27);
        lblSenha.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblSenha);

        //Text Field
        txtUsuario = new JTextField();
        txtUsuario.setBounds(510, 200, 200, 27);
        add(txtUsuario);

        //Password Field
        pwdSenha = new JPasswordField();
        pwdSenha.setBounds(510, 250, 200, 27);
        add(pwdSenha);

        // Button login
        btnLogin = new JButton("Entrar");
        btnLogin.setBounds(510, 300, 100, 27);
        add(btnLogin);

        // Action button login
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDataForLogin();
            }
        });

        setVisible(true);
    }

    //ABC.Login
    private void getDataForLogin() {
        String usuario = txtUsuario.getText().trim();
        String senha = String.valueOf(pwdSenha.getPassword());

        if (usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Login login = new Login(usuario, senha);

        System.out.println("Usuario: " + usuario + "    Senha: " + senha + "    " + login); // --------> Tirar

        txtUsuario.setText("");
        pwdSenha.setText("");

        //telaLogin.validaLogin(login);

    }

    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message, "Erro de login", JOptionPane.ERROR_MESSAGE);
    }

}
