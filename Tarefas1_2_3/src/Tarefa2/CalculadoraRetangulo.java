package Tarefa2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Classe para realizar os cálculos de área e perímetro
class Retangulo {
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    public double calcularArea() {
        return base * altura;
    }
}

// Classe principal para a interface gráfica
public class CalculadoraRetangulo extends JFrame {

    private JTextField textFieldBase;
    private JTextField textFieldAltura;
    private JLabel labelResultadoPerimetro;
    private JLabel labelResultadoArea;

    public CalculadoraRetangulo() {
        setTitle("Calculadora de Retângulo");
        setSize(400, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Componentes de entrada para base e altura
        JLabel labelBase = new JLabel("Base:");
        textFieldBase = new JTextField(10);
        JLabel labelAltura = new JLabel("Altura:");
        textFieldAltura = new JTextField(10);
        JButton buttonCalcular = new JButton("Calcular");

        // Labels para exibir os resultados
        labelResultadoPerimetro = new JLabel("Perímetro: --");
        labelResultadoArea = new JLabel("Área: --");

        // Adiciona os componentes à janela
        add(labelBase);
        add(textFieldBase);
        add(labelAltura);
        add(textFieldAltura);
        add(buttonCalcular);
        add(labelResultadoPerimetro);
        add(labelResultadoArea);

        // Ação para o botão de calcular
        buttonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double base = Double.parseDouble(textFieldBase.getText());
                    double altura = Double.parseDouble(textFieldAltura.getText());
                    Retangulo retangulo = new Retangulo(base, altura);
                    double perimetro = retangulo.calcularPerimetro();
                    double area = retangulo.calcularArea();
                    labelResultadoPerimetro.setText("Perímetro: " + String.format("%.2f", perimetro));
                    labelResultadoArea.setText("Área: " + String.format("%.2f", area));
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
                new CalculadoraRetangulo().setVisible(true);
            }
        });
    }
}
