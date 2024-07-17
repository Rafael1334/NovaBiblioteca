package view.dialog;

import model.Emprestimo;
import view.componentes.JtextFieldSomenteNumeros;
import view.telas.TelaEmprestimo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogNovoEmprestimo {

    private JDialog dialog = new JDialog();

    public DialogNovoEmprestimo(TelaEmprestimo telaEmprestimo){

        dialog.setSize(350, 400);
        dialog.setLocationRelativeTo(telaEmprestimo);
        dialog.setResizable(false);

        JPanel panelDialog = new JPanel();
        panelDialog.setLayout(null);
        dialog.add(panelDialog);

        // Labels
        JLabel lblEmprestimo = new JLabel("Empréstimo");
        lblEmprestimo.setBounds(120, 20, 200, 27);
        lblEmprestimo.setFont(new Font("Arial", Font.BOLD, 18));
        panelDialog.add(lblEmprestimo);

        JLabel lblCodigoUsuario = new JLabel("Código: ");
        lblCodigoUsuario.setBounds(20, 50, 100, 27);
        panelDialog.add(lblCodigoUsuario);

        JLabel lblResponsavelUsuario = new JLabel("Responsável: ");
        lblResponsavelUsuario.setBounds(20, 100, 100, 27);
        panelDialog.add(lblResponsavelUsuario);

        JLabel lblNomeUsuario = new JLabel("Usuário: ");
        lblNomeUsuario.setBounds(20, 150, 100, 27);
        panelDialog.add(lblNomeUsuario);

        JLabel lblCodigoLivro = new JLabel("Código: ");
        lblCodigoLivro.setBounds(20, 200, 100, 27);
        panelDialog.add(lblCodigoLivro);

        JLabel lblNomeLivro = new JLabel("Livro: ");
        lblNomeLivro.setBounds(20, 250, 100, 27);
        panelDialog.add(lblNomeLivro);

        // Text Field
        JTextField txtCodigoUsuario = new JtextFieldSomenteNumeros();
        txtCodigoUsuario.setBounds(100, 50, 200, 27);
        panelDialog.add(txtCodigoUsuario);

        JTextField txtResponsavelUsuario = new JTextField();
        txtResponsavelUsuario.setBounds(100, 100, 200, 27);
        panelDialog.add(txtResponsavelUsuario);

        JTextField txtNomeUsuario = new JTextField();
        txtNomeUsuario.setBounds(100, 150, 200, 27);
        txtNomeUsuario.setEditable(false);
        panelDialog.add(txtNomeUsuario);

        JTextField txtCodigoLivro = new JTextField();
        txtCodigoLivro.setBounds(100, 200, 200, 27);
        panelDialog.add(txtCodigoLivro);

        JTextField txtNomeLivro = new JTextField();
        txtNomeLivro.setBounds(100, 250, 200, 27);
        txtNomeLivro.setEditable(false);
        panelDialog.add(txtNomeLivro);

        // Button
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(180, 300, 100, 27);
        panelDialog.add(btnSalvar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(20, 300, 100, 27);
        panelDialog.add(btnVoltar);

        // Action Button
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cgmAluno = txtCodigoUsuario.getText().trim();
                String codigoLivro = txtCodigoLivro.getText().trim();

                if(codigoLivro.isEmpty() || cgmAluno.isEmpty()){
                    JOptionPane.showMessageDialog( panelDialog,"Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Emprestimo emprestimo = new Emprestimo(codigoLivro, cgmAluno);

                System.out.println("Código Livro: " + codigoLivro + "    CGM: " + cgmAluno + "    " + emprestimo); // --------> Tirar

                txtNomeUsuario.setText("");
                txtCodigoUsuario.setText("");

                telaEmprestimo.salvarEmprestimo(emprestimo);

            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { dialog.dispose(); }
        });

    }

    public void dialogSetVisible() {
        dialog.setVisible(true);
    }

    public void dialogDisposible() {
        dialog.dispose();
    }

}
