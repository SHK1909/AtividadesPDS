package Tarefa2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NomeCompleto extends JFrame {

    private JTextField textFieldNome;
    private JTextField textFieldSobrenome;
    private JLabel labelNomeCompleto;

    public NomeCompleto() {
        setTitle("Nome Completo");
        setSize(600, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Labels e TextFields para nome e sobrenome
        JLabel labelNome = new JLabel("Nome:");
        textFieldNome = new JTextField(10);
        JLabel labelSobrenome = new JLabel("Sobrenome:");
        textFieldSobrenome = new JTextField(10);
        JButton buttonMostrar = new JButton("Mostrar Nome Completo");
        labelNomeCompleto = new JLabel("Nome completo: --");

        // Adiciona os componentes à janela
        add(labelNome);
        add(textFieldNome);
        add(labelSobrenome);
        add(textFieldSobrenome);
        add(buttonMostrar);
        add(labelNomeCompleto);

        // Ação para o botão de mostrar nome completo
        buttonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNome.getText();
                String sobrenome = textFieldSobrenome.getText();
                String nomeCompleto = nome + " " + sobrenome;
                labelNomeCompleto.setText("Nome completo: " + nomeCompleto);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NomeCompleto().setVisible(true);
            }
        });
    }
}
