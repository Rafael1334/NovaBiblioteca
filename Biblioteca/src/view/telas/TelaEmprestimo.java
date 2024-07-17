package view.telas;

import Constantes.ConstatsName;
import model.Emprestimo;
import JFrameEx.JFramePrincipal;
import repository.database.DataBaseEmprestimo;
import view.componentes.JtextFieldSomenteNumeros;
import view.dialog.DialogNovoEmprestimo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEmprestimo extends JPanel {

    private JTextField txtPesquisar;
    private JButton btnPesquisar;
    private JButton btnVoltar;
    private JButton btnCadastrar;
    private JTable tableEmprestimo;
    private DefaultTableModel modelTable;
    private JFramePrincipal frame;
    private DataBaseEmprestimo dataBaseEmprestimo = new DataBaseEmprestimo();

    public TelaEmprestimo(JFramePrincipal frame) {
        this.frame = frame;
        showLayout();
    }

    private void showLayout() {
        setLayout(null);

        // Labels
        JLabel lblFuncionario = new JLabel("Empréstimo");
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
                frame.voltar(ConstatsName.EMPRESTIMO);
            }
        });

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarEmprestimo();
            }
        });


        // Table Emprestimo
        modelTable = new DefaultTableModel();
        modelTable.addColumn("ID");
        modelTable.addColumn("Livro");
        modelTable.addColumn("Código Livro");
        modelTable.addColumn("Usuário");
        modelTable.addColumn("Código Usuário");
        modelTable.addColumn("Detalhes");
        tableEmprestimo = new JTable(modelTable);
        JScrollPane sp = new JScrollPane(tableEmprestimo);
        sp.setBounds(50, 150, 980, 400);
        add(sp);
    }

    DialogNovoEmprestimo dialogNovoEmprestimo = new DialogNovoEmprestimo(TelaEmprestimo.this);

    public void realizarEmprestimo() {
        dialogNovoEmprestimo.dialogSetVisible();
    }

    public void salvarEmprestimo(Emprestimo emprestimo) {
        try {
            dataBaseEmprestimo.salvar(emprestimo);
        } catch (Exception exception) {
            //TODO tratamento erro
            JOptionPane.showMessageDialog(this, "Erro ao realizar Empréstimo no Banco de Dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
