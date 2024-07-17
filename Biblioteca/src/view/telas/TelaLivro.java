package view.telas;

import Constantes.ConstatsName;
import model.Livro;
import JFrameEx.JFramePrincipal;
import repository.database.DataBaseLivro;
import view.componentes.JtextFieldSomenteNumeros;
import view.dialog.DialogNovoLivro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLivro extends JPanel {

    private JTextField txtPesquisar;
    private JButton btnPesquisar;
    private JButton btnVoltar;
    private JButton btnCadastrar;
    private JTable tableLivro;
    private DefaultTableModel modelTable;
    private JFramePrincipal frame;
    private DataBaseLivro dataBaseLivro = new DataBaseLivro();

    public TelaLivro(JFramePrincipal frame) {
        this.frame = frame;
        showLayout();
    }

    private void showLayout() {
        setLayout(null);

        // Labels
        JLabel lblLivro = new JLabel("Livro");
        lblLivro.setBounds(510, 50, 200, 27);
        lblLivro.setFont(new Font("Arial", Font.BOLD, 30));
        add(lblLivro);

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
                frame.voltar(ConstatsName.LIVRO);
            }
        });

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarLivro();
            }
        });


        // Table ABC.Livro
        modelTable = new DefaultTableModel();
        modelTable.addColumn("ID");
        modelTable.addColumn("Livro");
        modelTable.addColumn("Autor");
        modelTable.addColumn("Ano");
        modelTable.addColumn("Código");
        modelTable.addColumn("Estante");
        modelTable.addColumn("Prateleira");
        modelTable.addColumn("Cópias");
        modelTable.addColumn("Detalhes");
        tableLivro = new JTable(modelTable);
        JScrollPane sp = new JScrollPane(tableLivro);
        sp.setBounds(50, 150, 980, 400);
        add(sp);
    }

    DialogNovoLivro dialogNovoLivro = new DialogNovoLivro(TelaLivro.this);

    public void cadastrarLivro() {
        dialogNovoLivro.dialogSetVisible();
    }

    public void salvarLivro(Livro livro) {
        try {
            dataBaseLivro.salvar(livro);
        } catch (Exception exception) {
            //TODO tratamento erro
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar Livro no Banco de Dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        dialogNovoLivro.dialogDisposible();
    }

}
