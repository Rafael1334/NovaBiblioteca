package view.dialog;

import model.Livro;
import view.componentes.JtextFieldSomenteNumeros;
import view.telas.TelaLivro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogNovoLivro {

    private JDialog dialog = new JDialog();

    public DialogNovoLivro(TelaLivro telaLivro) {

        dialog.setSize(350, 400);
        dialog.setLocationRelativeTo(telaLivro);
        dialog.setResizable(false);

        JPanel panelDialog = new JPanel();
        panelDialog.setLayout(null);
        dialog.add(panelDialog);

        // Labels
        JLabel lblLivro = new JLabel("Livro");
        lblLivro.setBounds(140, 20, 200, 27);
        lblLivro.setFont(new Font("Arial", Font.BOLD, 18));
        panelDialog.add(lblLivro);

        JLabel lblNomeLivro = new JLabel("Livro: ");
        lblNomeLivro.setBounds(20, 70, 100, 27);
        panelDialog.add(lblNomeLivro);

        JLabel lblNomeAutor = new JLabel("Autor: ");
        lblNomeAutor.setBounds(20, 120, 100, 27);
        panelDialog.add(lblNomeAutor);

        JLabel lblCodigoLivro = new JLabel("Código: ");
        lblCodigoLivro.setBounds(20, 170, 100, 27);
        panelDialog.add(lblCodigoLivro);

        JLabel lblAnoLivro = new JLabel("Ano: ");
        lblAnoLivro.setBounds(20, 220, 100, 27);
        panelDialog.add(lblAnoLivro);

        JLabel lblCopiasLivro = new JLabel("Cópias: ");
        lblCopiasLivro.setBounds(150, 220, 100, 27);
        panelDialog.add(lblCopiasLivro);

        JLabel lblEstanteLivro = new JLabel("Estante: ");
        lblEstanteLivro.setBounds(20, 270, 100, 27);
        panelDialog.add(lblEstanteLivro);

        JLabel lblPrateleiraLivro = new JLabel("Prateleira: ");
        lblPrateleiraLivro.setBounds(150, 270, 100, 27);
        panelDialog.add(lblPrateleiraLivro);

        // TextField
        JTextField txtNomeLivro = new JTextField();
        txtNomeLivro.setBounds(80, 70, 200, 27);
        panelDialog.add(txtNomeLivro);

        JTextField txtNomeAutor = new JTextField();
        txtNomeAutor.setBounds(80, 120, 200, 27);
        panelDialog.add(txtNomeAutor);

        JTextField txtCodigoLivro = new JTextField();
        txtCodigoLivro.setBounds(80, 170, 200, 27);
        panelDialog.add(txtCodigoLivro);

        JTextField txtAnoLivro = new JtextFieldSomenteNumeros();
        txtAnoLivro.setBounds(80, 220, 70, 27);
        panelDialog.add(txtAnoLivro);

        JTextField txtCopiasLivro = new JtextFieldSomenteNumeros();
        txtCopiasLivro.setBounds(210, 220, 70, 27);
        panelDialog.add(txtCopiasLivro);

        JTextField txtEstanteLivro = new JtextFieldSomenteNumeros();
        txtEstanteLivro.setBounds(80, 270, 70, 27);
        panelDialog.add(txtEstanteLivro);

        JTextField txtPrateleiraLivro = new JtextFieldSomenteNumeros();
        txtPrateleiraLivro.setBounds(210, 270, 70, 27);
        panelDialog.add(txtPrateleiraLivro);

        // Button
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(180, 320, 100, 27);
        panelDialog.add(btnSalvar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(20, 320, 100, 27);
        panelDialog.add(btnVoltar);

        // Action Button
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeLivro = txtNomeLivro.getText().trim();
                String nomeAutor = txtNomeAutor.getText().trim();
                String codigoLivro = txtCodigoLivro.getText().trim();
                String copiaLivro = txtCopiasLivro.getText().trim();
                String anoLivro = txtAnoLivro.getText().trim();
                String estanteLivro = txtEstanteLivro.getText().trim();
                String prateleiraLivro = txtPrateleiraLivro.getText().trim();

                if (nomeLivro.isEmpty() || nomeAutor.isEmpty() || codigoLivro.isEmpty() || copiaLivro.isEmpty()) {
                    JOptionPane.showMessageDialog(panelDialog, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Livro livro = new Livro(nomeLivro, nomeAutor, anoLivro, codigoLivro, estanteLivro, prateleiraLivro, copiaLivro);

                System.out.println("Nome ABC.Livro: " + nomeLivro + "    Nome Autor: " + nomeAutor + "  Codigo: " + codigoLivro + "     Copias: " + copiaLivro + "      " + livro); // --------> Tirar

                txtNomeLivro.setText("");
                txtNomeAutor.setText("");
                txtCodigoLivro.setText("");
                txtCopiasLivro.setText("");
                txtAnoLivro.setText("");
                txtEstanteLivro.setText("");
                txtPrateleiraLivro.setText("");

                telaLivro.salvarLivro(livro);

            }
        });

        btnVoltar.addActionListener(new ActionListener() {
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

