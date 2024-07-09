package Telas;

import Constantes.ConstatsName;
import JFrameEx.JFrameEx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JPanel {

    private JButton btnFuncionario;
    private JButton btnAluno;
    private JButton btnLivro;
    private JButton btnEmprestimo;
    private JButton btnLogOut;
    private JFrameEx frame;


    public TelaPrincipal(JFrameEx frame) {
        this.frame = frame;
        showLayout();
    }

    private void showLayout(){
        setLayout(null);

        // Buttons
        btnFuncionario = new JButton(ConstatsName.FUNCIONARIO);
        btnFuncionario.setBounds(200, 100, 300, 200);
        btnFuncionario.setFont(new Font("Arial", Font.BOLD, 24));
        add(btnFuncionario);

        btnAluno = new JButton(ConstatsName.ALUNO);
        btnAluno.setBounds(550, 100, 300, 200);
        btnAluno.setFont(new Font("Arial", Font.BOLD, 24));
        add(btnAluno);

        btnLivro = new JButton(ConstatsName.LIVRO);
        btnLivro.setBounds(200, 350, 300, 200);
        btnLivro.setFont(new Font("Arial", Font.BOLD, 24));
        add(btnLivro);

        btnEmprestimo = new JButton(ConstatsName.EMPRESTIMO);
        btnEmprestimo.setBounds(550, 350, 300, 200);
        btnEmprestimo.setFont(new Font("Arial", Font.BOLD, 24));
        add(btnEmprestimo);

        btnLogOut = new JButton(ConstatsName.SAIR);
        btnLogOut.setBounds(50, 600, 100, 27);
        add(btnLogOut);

        //Action Buttons
        btnFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.sairAndEntra(ConstatsName.FUNCIONARIO);
            }
        });

        btnAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.sairAndEntra(ConstatsName.ALUNO);
            }
        });

        btnLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.sairAndEntra(ConstatsName.LIVRO);

            }
        });

        btnEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.sairAndEntra(ConstatsName.EMPRESTIMO);
            }
        });

        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.sairAndEntra(ConstatsName.SAIR);
            }
        });
    }

}