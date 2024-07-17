package view.telas;

import Constantes.ConstatsName;
import model.Usuario;
import JFrameEx.JFramePrincipal;
import repository.database.DataBaseUsuario;
import view.dialog.DialogNovoUsuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaUsuario extends JPanel {

    private JTextField txtPesquisar;
    private JButton btnPesquisar;
    private JButton btnVoltar;
    private JButton btnCadastrar;
    private JTable tableUsuario;
    private DefaultTableModel modelTable;
    private JFramePrincipal frame;
    private DataBaseUsuario dataBaseUsuario = new DataBaseUsuario();

    public TelaUsuario(JFramePrincipal frame) {
        this.frame = frame;
        showLayout();
    }

    private void showLayout() {
        setLayout(null);

        // Labels
        JLabel lblUsuario = new JLabel("Usuário");
        lblUsuario.setBounds(510, 50, 200, 27);
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 30));
        add(lblUsuario);

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
                frame.voltar(ConstatsName.USUARIO);
            }
        });

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });


        // Table Usuário
        modelTable = new DefaultTableModel();
        modelTable.addColumn("ID");
        modelTable.addColumn("Usuário");
        modelTable.addColumn("Responsável");
        modelTable.addColumn("Código");
        modelTable.addColumn("Detalhes");
        tableUsuario = new JTable(modelTable);
        JScrollPane sp = new JScrollPane(tableUsuario);
        sp.setBounds(50, 150, 980, 400);
        add(sp);
    }

    private DialogNovoUsuario dialogNovoUsuario = new DialogNovoUsuario(TelaUsuario.this);

    public void cadastrarUsuario() {
        dialogNovoUsuario.dialogSetVisible();
    }

    public void salvarUsuario(Usuario usuario){
        try {
            dataBaseUsuario.salvar(usuario);
        } catch (Exception exception){
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar Usuário no Banco de Dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        dialogNovoUsuario.dialogDisposible();
    }
}