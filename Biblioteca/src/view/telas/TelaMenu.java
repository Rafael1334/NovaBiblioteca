package view.telas;

import Constantes.ConstatsName;
import JFrameEx.JFramePrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenu extends JPanel {

    private JButton btnFuncionario;
    private JButton btnUsuario;
    private JButton btnLivro;
    private JButton btnEmprestimo;
    private JButton btnLogOut;
    private JFramePrincipal frame;


    public TelaMenu(JFramePrincipal frame) {
        this.frame = frame;
        showLayout();
    }

    private void showLayout() {
        setLayout(null);

        // Buttons
        btnFuncionario = new JButton(ConstatsName.FUNCIONARIO);
        btnFuncionario.setBounds(200, 100, 300, 200);
        btnFuncionario.setFont(new Font("Arial", Font.BOLD, 24));
        add(btnFuncionario);

        btnUsuario = new JButton(ConstatsName.USUARIO);
        btnUsuario.setBounds(550, 100, 300, 200);
        btnUsuario.setFont(new Font("Arial", Font.BOLD, 24));
        add(btnUsuario);

        btnLivro = new JButton(ConstatsName.LIVRO);
        btnLivro.setBounds(200, 350, 300, 200);
        btnLivro.setFont(new Font("Arial", Font.BOLD, 24));
        add(btnLivro);

        btnEmprestimo = new JButton(ConstatsName.EMPRESTIMO);
        btnEmprestimo.setBounds(550, 350, 300, 200);
        btnEmprestimo.setFont(new Font("Arial", Font.BOLD, 24));
        add(btnEmprestimo);

        btnLogOut = new JButton(ConstatsName.VOLTAR);
        btnLogOut.setBounds(50, 600, 100, 27);
        add(btnLogOut);

        //Action Buttons
        btnFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.trocarTela(ConstatsName.FUNCIONARIO);
            }
        });

        btnUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.trocarTela(ConstatsName.USUARIO);
            }
        });

        btnLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.trocarTela(ConstatsName.LIVRO);
            }
        });

        btnEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.trocarTela(ConstatsName.EMPRESTIMO);
            }
        });

        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.voltar(ConstatsName.MENU);
            }
        });
    }

}