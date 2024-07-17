package view.dialog;

import model.Funcionario;
import view.telas.TelaFuncionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogNovoFuncionario {

    private JDialog dialog = new JDialog();

    public DialogNovoFuncionario(TelaFuncionario telaFuncionario) {

        dialog.setSize(350, 400);
        dialog.setLocationRelativeTo(telaFuncionario);
        dialog.setResizable(false);

        JPanel panelDialog = new JPanel();
        panelDialog.setLayout(null);
        dialog.add(panelDialog);

        // Labels
        JLabel lblFuncionario = new JLabel("Funcionário");
        lblFuncionario.setBounds(120, 20, 200, 27);
        lblFuncionario.setFont(new Font("Arial", Font.BOLD, 18));
        panelDialog.add(lblFuncionario);

        JLabel lblNomeFuncionario = new JLabel("Nome: ");
        lblNomeFuncionario.setBounds(20, 100, 100, 27);
        panelDialog.add(lblNomeFuncionario);

        JLabel lblCodigoFuncionario = new JLabel("Código: ");
        lblCodigoFuncionario.setBounds(20, 150, 100, 27);
        panelDialog.add(lblCodigoFuncionario);

        JLabel lblSenhaFuncionario = new JLabel("Senha: ");
        lblSenhaFuncionario.setBounds(20, 200, 100, 27);
        panelDialog.add(lblSenhaFuncionario);

        // Text Field
        JTextField txtNomeFuncionario = new JTextField();
        txtNomeFuncionario.setBounds(80, 100, 200, 27);
        panelDialog.add(txtNomeFuncionario);

        JTextField txtCodigoFuncionario = new JTextField();
        txtCodigoFuncionario.setBounds(80, 150, 200, 27);
        panelDialog.add(txtCodigoFuncionario);

        // Password Field
        JPasswordField pwdSenhaFuncionario = new JPasswordField();
        pwdSenhaFuncionario.setBounds(80, 200, 200, 27);
        panelDialog.add(pwdSenhaFuncionario);

        // Button
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(180, 300, 100, 27);
        panelDialog.add(btnSalvar);

        JButton btnCancelar = new JButton("Voltar");
        btnCancelar.setBounds(20, 300, 100, 27);
        panelDialog.add(btnCancelar);

        // Action Button
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeFuncionario = txtCodigoFuncionario.getText().trim();
                String senhaFuncionario = String.valueOf(pwdSenhaFuncionario.getPassword());

                if (nomeFuncionario.isEmpty() || senhaFuncionario.isEmpty()) {
                    JOptionPane.showMessageDialog(panelDialog, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Funcionario funcionario = new Funcionario(nomeFuncionario, senhaFuncionario);

                System.out.println("Nome Funcionário: " + nomeFuncionario + "    Senha: " + senhaFuncionario + "    " + funcionario); // --------> Tirar

                txtCodigoFuncionario.setText("");
                pwdSenhaFuncionario.setText("");

                telaFuncionario.salvarFuncionario(funcionario);
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

    }

    public void dialogSetVisible() {
        dialog.setVisible(true);
    }

    public void dialogDisposible() {
        dialog.dispose();
    }

}
