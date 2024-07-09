package Telas;

import ABC.Aluno;
import JFrameEx.JFrameEx;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAluno extends JPanel {

    private JTextField txtPesquisar;
    private JButton btnPesquisar;
    private JButton btnVoltar;
    private JButton btnCadastrar;
    private JTable tableAluno;
    private DefaultTableModel modelTable;
    private JFrameEx frame;

    public TelaAluno(JFrameEx frame) {
        this.frame = frame;
        showLayout();

    }

    private void showLayout() {
        setLayout(null);

        // Labels
        JLabel lblFuncionario = new JLabel("ABC.Aluno");
        lblFuncionario.setBounds(510, 50, 200, 27);
        lblFuncionario.setFont(new Font("Arial", Font.BOLD, 30));
        add(lblFuncionario);

        JLabel lblPesquisar = new JLabel("Pesquisar:");
        lblPesquisar.setBounds(50, 100, 100, 27);
        lblPesquisar.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblPesquisar);

        // Text Field
        txtPesquisar = new JTextField();
        txtPesquisar.setBounds(160, 100, 200, 27);
        add(txtPesquisar);

        // Button
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setBounds(380, 100, 100, 27);
        add(btnPesquisar);

        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(50, 570, 100, 27);
        add(btnVoltar);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(930, 570, 100, 27);
        add(btnCadastrar);

        // Action Buttons
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPesquisar.setText("");
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { cadastrarAluno(); }
        });


        // Table Aluno
        modelTable = new DefaultTableModel();
        modelTable.addColumn("ID");
        modelTable.addColumn("ABC.Aluno");
        modelTable.addColumn("CGM");
        modelTable.addColumn("Detalhes");
        tableAluno = new JTable(modelTable);
        JScrollPane sp = new JScrollPane(tableAluno);
        sp.setBounds(50, 150, 980, 400);
        add(sp);
    }

    public void cadastrarAluno(){
        JDialog dialog = new JDialog();
        dialog.setSize(350, 400);
        dialog.setLocationRelativeTo(this);

        JPanel panelDialog = new JPanel();
        panelDialog.setLayout(null);
        dialog.add(panelDialog);

        // Labels
        JLabel lblAluno = new JLabel("ABC.Aluno");
        lblAluno.setBounds(150, 20, 200, 27);
        lblAluno.setFont(new Font("Arial", Font.BOLD, 18));
        panelDialog.add(lblAluno);

        JLabel lblNomeAluno = new JLabel("Nome: ");
        lblNomeAluno.setBounds(20, 100, 100, 27);
        panelDialog.add(lblNomeAluno);

        JLabel lblCgmAluno = new JLabel("CGM: ");
        lblCgmAluno.setBounds(20, 150, 100, 27);
        panelDialog.add(lblCgmAluno);

        // Text Field
        JTextField txtNomeAluno = new JTextField();
        txtNomeAluno.setBounds(80, 100, 200, 27);
        panelDialog.add(txtNomeAluno);

        JTextField txtCgmAluno = new JtextFieldSomenteNumeros();
        txtCgmAluno.setBounds(80, 150, 200, 27);
        panelDialog.add(txtCgmAluno);

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
                String nomeAluno = txtNomeAluno.getText().trim();
                String cgmAluno = txtCgmAluno.getText().trim();

                if(nomeAluno.isEmpty() || cgmAluno.isEmpty()){
                    JOptionPane.showMessageDialog( panelDialog,"Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Aluno aluno = new Aluno(nomeAluno, cgmAluno);

                System.out.println("Nome ABC.Aluno: " + nomeAluno + "    CGM: " + cgmAluno + "    " + aluno); // --------> Tirar

                txtNomeAluno.setText("");
                txtCgmAluno.setText("");

                dialog.dispose();
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { dialog.dispose(); }
        });

        dialog.setVisible(true);
    }
}
