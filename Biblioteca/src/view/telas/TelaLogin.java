package view.telas;

import model.Login;
import JFrameEx.JFramePrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JPanel {

    private JTextField txtUsuario;
    private JPasswordField pwdSenha;
    private JButton btnLogin;
    private JFramePrincipal frame;

    public TelaLogin(JFramePrincipal frame) {
        this.frame = frame;
        showLayout();
    }

    private void showLayout(){
        setLayout(null);

        //Labels
        JLabel lblLogin = new JLabel("Login");
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
    }

    //Login
    private void getDataForLogin(){
        String usuario = txtUsuario.getText().trim();
        String senha = String.valueOf(pwdSenha.getPassword());

        if(usuario.isEmpty() || senha.isEmpty()){
            showMessage("Preencha todos os campos");
            return;
        }

        Login login = new Login(usuario, senha);

        System.out.println("Usuario: " + usuario + "    Senha: " + senha + "    " + login); // --------> Tirar

        txtUsuario.setText("");
        pwdSenha.setText("");

        frame.validaLogin(login);

    }

    public void showMessage(String message){
        JOptionPane.showMessageDialog( this, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }

}