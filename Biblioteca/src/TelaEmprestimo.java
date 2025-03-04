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

    public TelaEmprestimo(TelaLogin telaLogin) {
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
                telaLogin.trocarTela(TelaLogin.PRINCIPALPANEL);
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
        modelTable.addColumn("Código");
        modelTable.addColumn("Aluno");
        modelTable.addColumn("CGM");
        modelTable.addColumn("Detalhes");
        tableEmprestimo = new JTable(modelTable);
        JScrollPane sp = new JScrollPane(tableEmprestimo);
        sp.setBounds(50, 150, 980, 400);
        add(sp);

    }

    public void realizarEmprestimo(){
        JDialog dialog = new JDialog();
        dialog.setSize(350, 400);
        dialog.setLocationRelativeTo(this);

        JPanel panelDialog = new JPanel();
        panelDialog.setLayout(null);
        dialog.add(panelDialog);

        // Labels
        JLabel lblEmprestimo = new JLabel("Empréstimo");
        lblEmprestimo.setBounds(120, 20, 200, 27);
        lblEmprestimo.setFont(new Font("Arial", Font.BOLD, 18));
        panelDialog.add(lblEmprestimo);

        JLabel lblCgmAluno = new JLabel("CGM: ");
        lblCgmAluno.setBounds(20, 100, 100, 27);
        panelDialog.add(lblCgmAluno);

        JLabel lblNomeAluno = new JLabel("Nome: ");
        lblNomeAluno.setBounds(20, 150, 100, 27);
        panelDialog.add(lblNomeAluno);

        JLabel lblCodigoLivro = new JLabel("Código: ");
        lblCodigoLivro.setBounds(20, 200, 100, 27);
        panelDialog.add(lblCodigoLivro);

        JLabel lblNomeLivro = new JLabel("Livro: ");
        lblNomeLivro.setBounds(20, 250, 100, 27);
        panelDialog.add(lblNomeLivro);

        // Text Field
        JTextField txtCgmAluno = new JtextFieldSomenteNumeros();
        txtCgmAluno.setBounds(80, 100, 200, 27);
        panelDialog.add(txtCgmAluno);

        JTextField txtNomeAluno = new JTextField();
        txtNomeAluno.setBounds(80, 150, 200, 27);
        txtNomeAluno.setEditable(false);
        panelDialog.add(txtNomeAluno);

        JTextField txtCodigoLivro = new JTextField();
        txtCodigoLivro.setBounds(80, 200, 200, 27);
        panelDialog.add(txtCodigoLivro);

        JTextField txtNomeLivro = new JTextField();
        txtNomeLivro.setBounds(80, 250, 200, 27);
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
                String cgmAluno = txtCgmAluno.getText().trim();
                String codigoLivro = txtCodigoLivro.getText().trim();

                if(codigoLivro.isEmpty() || cgmAluno.isEmpty()){
                    JOptionPane.showMessageDialog( panelDialog,"Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Emprestimo emprestimo = new Emprestimo(codigoLivro, cgmAluno);

                System.out.println("Código Livro: " + codigoLivro + "    CGM: " + cgmAluno + "    " + emprestimo); // --------> Tirar

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
