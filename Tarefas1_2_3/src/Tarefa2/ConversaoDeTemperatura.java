package Tarefa2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Classe responsável pela conversão de temperatura
class Conversao {
    public double calcularTemperatura(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}

// Classe principal para a interface gráfica
public class ConversaoDeTemperatura extends JFrame {

    private JTextField textFieldFahrenheit;
    private JLabel labelCelsius;

    public ConversaoDeTemperatura() {
        setTitle("Conversão de Temperatura");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel labelInput = new JLabel("Fahrenheit:");
        textFieldFahrenheit = new JTextField(10);
        JButton buttonConverter = new JButton("Converter");
        labelCelsius = new JLabel("Celsius: --");

        // Adiciona os componentes à janela
        add(labelInput);
        add(textFieldFahrenheit);
        add(buttonConverter);
        add(labelCelsius);

        // Adiciona ação ao botão de conversão
        buttonConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double fahrenheit = Double.parseDouble(textFieldFahrenheit.getText());
                    Conversao conversao = new Conversao();
                    double celsius = conversao.calcularTemperatura(fahrenheit);
                    labelCelsius.setText("Celsius: " + String.format("%.2f", celsius));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConversaoDeTemperatura().setVisible(true);
            }
        });
    }
}
