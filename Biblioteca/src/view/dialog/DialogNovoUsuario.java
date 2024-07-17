package view.dialog;

import model.Usuario;
import view.componentes.JtextFieldSomenteNumeros;
import view.telas.TelaUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogNovoUsuario {

    private JDialog dialog = new JDialog();

    public DialogNovoUsuario(TelaUsuario telaUsuario) {

        dialog.setSize(350, 400);
        dialog.setLocationRelativeTo(telaUsuario);
        dialog.setResizable(false);

        JPanel panelDialog = new JPanel();
        panelDialog.setLayout(null);
        dialog.add(panelDialog);

        // Labels
        JLabel lblUsuario = new JLabel("Usuário");
        lblUsuario.setBounds(150, 20, 200, 27);
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 18));
        panelDialog.add(lblUsuario);

        JLabel lblNomeUsuario = new JLabel("Nome: ");
        lblNomeUsuario.setBounds(20, 100, 100, 27);
        panelDialog.add(lblNomeUsuario);

        JLabel lblResponsavelUsuario = new JLabel("Responsável: ");
        lblResponsavelUsuario.setBounds(20, 150, 100, 27);
        panelDialog.add(lblResponsavelUsuario);

        JLabel lblCodigoUsuario = new JLabel("Código: ");
        lblCodigoUsuario.setBounds(20, 200, 100, 27);
        panelDialog.add(lblCodigoUsuario);

        // Text Field
        JTextField txtNomeUsuario = new JTextField();
        txtNomeUsuario.setBounds(100, 100, 200, 27);
        panelDialog.add(txtNomeUsuario);

        JTextField txtResponsavelUsuario = new JtextFieldSomenteNumeros();
        txtResponsavelUsuario.setBounds(100, 150, 200, 27);
        panelDialog.add(txtResponsavelUsuario);

        JTextField txtCodigoUsuario = new JTextField();
        txtCodigoUsuario.setBounds(100, 200, 200, 27);
        panelDialog.add(txtCodigoUsuario);

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
                String nomeUsuario = txtNomeUsuario.getText().trim();
                String nomeResponsavel = txtResponsavelUsuario.getText().trim();

                if (nomeUsuario.isEmpty()) {
                    JOptionPane.showMessageDialog(panelDialog, "Preencha o campo Nome.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Usuario usuario = new Usuario(nomeUsuario, nomeResponsavel);

                System.out.println("Nome Aluno: " + nomeUsuario + "    Nome Responsavel: " + nomeResponsavel + "    " + usuario); // --------> Tirar

                txtNomeUsuario.setText("");
                txtResponsavelUsuario.setText("");

                telaUsuario.salvarUsuario(usuario);

            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

    }

    public void dialogSetVisible(){
        dialog.setVisible(true);
    }

    public void dialogDisposible(){
        dialog.dispose();
    }

}

