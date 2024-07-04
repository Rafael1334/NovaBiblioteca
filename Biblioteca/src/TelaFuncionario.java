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

    public TelaFuncionario(TelaLogin telaLogin) {
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
                telaLogin.trocarTela(TelaLogin.PRINCIPALPANEL);
            }
        });

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { cadastrarFuncionario(); }
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

    public void cadastrarFuncionario(){
        JDialog dialog = new JDialog();
        dialog.setSize(350, 400);
        dialog.setLocationRelativeTo(this);

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

        JLabel lblSenhaFuncionario = new JLabel("Senha: ");
        lblSenhaFuncionario.setBounds(20, 150, 100, 27);
        panelDialog.add(lblSenhaFuncionario);

        // Text Field
        JTextField txtNomeFuncionario = new JTextField();
        txtNomeFuncionario.setBounds(80, 100, 200, 27);
        panelDialog.add(txtNomeFuncionario);

        // Password Field
        JPasswordField pwdSenhaFuncionario = new JPasswordField();
        pwdSenhaFuncionario.setBounds(80, 150, 200, 27);
        panelDialog.add(pwdSenhaFuncionario);

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
                String nomeFuncionario = txtNomeFuncionario.getText().trim();
                String senhaFuncionario = String.valueOf(pwdSenhaFuncionario.getPassword());

                if(nomeFuncionario.isEmpty() || senhaFuncionario.isEmpty()){
                    JOptionPane.showMessageDialog( panelDialog,"Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Funcionario funcionario = new Funcionario(nomeFuncionario, senhaFuncionario);

                System.out.println("Nome Funcionário: " + nomeFuncionario + "    Senha: " + senhaFuncionario + "    " + funcionario); // --------> Tirar

                txtNomeFuncionario.setText("");
                pwdSenhaFuncionario.setText("");

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
