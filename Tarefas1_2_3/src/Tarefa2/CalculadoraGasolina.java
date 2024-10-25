package Tarefa2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGasolina extends JFrame {

    private JTextField textFieldValorPagamento;
    private JLabel labelResultadoLitros;

    // Preço fixo da gasolina
    private static final double PRECO_GASOLINA = 4.50;

    public CalculadoraGasolina() {
        setTitle("Calculadora de Gasolina");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Componentes de entrada para o valor de pagamento
        JLabel labelValorPagamento = new JLabel("Valor em R$:");
        textFieldValorPagamento = new JTextField(10);
        JButton buttonCalcular = new JButton("Calcular");

        // Label para exibir a quantidade de litros de gasolina
        labelResultadoLitros = new JLabel("Litros: --");

        // Adiciona os componentes à janela
        add(labelValorPagamento);
        add(textFieldValorPagamento);
        add(buttonCalcular);
        add(labelResultadoLitros);

        // Ação para o botão de calcular
        buttonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Lê o valor de pagamento inserido pelo usuário
                    double valorPagamento = Double.parseDouble(textFieldValorPagamento.getText());
                    // Calcula a quantidade de litros
                    double litros = valorPagamento / PRECO_GASOLINA;
                    // Exibe o resultado
                    labelResultadoLitros.setText("Litros: " + String.format("%.2f", litros));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um valor numérico válido.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraGasolina().setVisible(true);
            }
        });
    }
}
