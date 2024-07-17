package view.telas;

import model.Funcionario;
import Constantes.ConstatsName;
import JFrameEx.JFramePrincipal;
import repository.database.DataBaseFuncionario;
import view.dialog.DialogNovoFuncionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaFuncionario extends JPanel {

    private JTextField txtPesquisar;
    private JButton btnPesquisar;
    private JButton btnVoltar;
    private JButton btnCadastrar;
    private JTable tableFuncionario;
    private DefaultTableModel modelTable;
    private JFramePrincipal frame;
    private DataBaseFuncionario dataBaseFuncionario = new DataBaseFuncionario();

    public TelaFuncionario(JFramePrincipal frame) {
        this.frame = frame;
        showLayout();
    }

    private void showLayout() {
        setLayout(null);

        // Labels
        JLabel lblFuncionario = new JLabel("Funcionário");
        lblFuncionario.setBounds(470, 50, 200, 27);
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
                frame.voltar(ConstatsName.FUNCIONARIO);
            }
        });

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarFuncionario();
            }
        });


        // Table Funcionario
        modelTable = new DefaultTableModel();
        modelTable.addColumn("ID");
        modelTable.addColumn("Funcionário");
        modelTable.addColumn("Detalhes");
        tableFuncionario = new JTable(modelTable);
        JScrollPane sp = new JScrollPane(tableFuncionario);
        sp.setBounds(50, 150, 980, 400);
        add(sp);
    }

    private DialogNovoFuncionario dialogNovoFuncionario = new DialogNovoFuncionario(TelaFuncionario.this);

    public void cadastrarFuncionario() {
        dialogNovoFuncionario.dialogSetVisible();
    }

    public void salvarFuncionario(Funcionario funcionario) {
        try {
            dataBaseFuncionario.salvar(funcionario);
        } catch (Exception exception) {
            //TODO tratamento de erro
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar Funcionário no Banco de Dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        dialogNovoFuncionario.dialogDisposible();
    }

}
