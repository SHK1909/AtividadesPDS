package Tarefa2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestauranteQuilo extends JFrame {

    private JTextField textFieldPesoPrato;
    private JTextField textFieldValorQuilo;
    private JLabel labelValorTotal;

    public RestauranteQuilo() {
        setTitle("Calculadora de Refeição - Fomelândia");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margem interna
        
        // Configura o título
        JLabel labelTitulo = new JLabel("Calculadora de Refeição");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(labelTitulo, gbc);
        
        // Label e campo para o peso do prato
        JLabel labelPesoPrato = new JLabel("Peso do prato (kg):");
        labelPesoPrato.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(labelPesoPrato, gbc);
        
        textFieldPesoPrato = new JTextField(10);
        gbc.gridx = 1;
        add(textFieldPesoPrato, gbc);
        
        // Label e campo para o valor do quilo
        JLabel labelValorQuilo = new JLabel("Valor do quilo (R$):");
        labelValorQuilo.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(labelValorQuilo, gbc);
        
        textFieldValorQuilo = new JTextField(10);
        textFieldValorQuilo.setText("9.95"); // Valor padrão
        gbc.gridx = 1;
        add(textFieldValorQuilo, gbc);

        // Botão para calcular
        JButton buttonCalcular = new JButton("Calcular");
        buttonCalcular.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(buttonCalcular, gbc);

        // Label para exibir o valor total
        labelValorTotal = new JLabel("Valor total: R$ --");
        labelValorTotal.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 4;
        add(labelValorTotal, gbc);

        // Ação para o botão de calcular
        buttonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Lê o peso do prato e o valor do quilo inseridos pelo usuário
                    double pesoPrato = Double.parseDouble(textFieldPesoPrato.getText());
                    double valorQuilo = Double.parseDouble(textFieldValorQuilo.getText());
                    // Calcula o valor total a pagar
                    double valorTotal = pesoPrato * valorQuilo;
                    // Exibe o resultado
                    labelValorTotal.setText("Valor total: R$ " + String.format("%.2f", valorTotal));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores numéricos válidos.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RestauranteQuilo().setVisible(true);
            }
        });
    }
}
