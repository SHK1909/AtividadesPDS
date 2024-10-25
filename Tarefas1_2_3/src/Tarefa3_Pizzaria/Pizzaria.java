package Tarefa3_Pizzaria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pizzaria extends JFrame {
    // Limite de sabores de pizza selecionáveis
    private static final int MAX_SABORES = 3;
    private static final int MIN_SABORES = 1;

    // Preços
    private static final double PRECO_PIZZA_BASE = 30.00;  // Preço base da pizza
    private static final double PRECO_BORDA = 5.00;        // Preço adicional para borda
    private static final double PRECO_OPCIONAIS = 2.00;    // Preço de cada opcional
    private static final double PRECO_ENTREGA = 8.00;      // Preço de tele entrega
    private static final double PRECO_SABOR_ADICIONAL = 3.00; // Preço por sabor adicional além do primeiro

    public Pizzaria() {
        setTitle("Pizzaria");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        // Painel para os sabores da pizza (JCheckBox)
        JPanel panelSabores = new JPanel();
        panelSabores.setBorder(BorderFactory.createTitledBorder("Escolha até 3 sabores"));
        JCheckBox sabor1 = new JCheckBox("Calabresa");
        JCheckBox sabor2 = new JCheckBox("Mussarela");
        JCheckBox sabor3 = new JCheckBox("Frango com Catupiry");
        JCheckBox sabor4 = new JCheckBox("Marguerita");
        JCheckBox sabor5 = new JCheckBox("Pepperoni");

        panelSabores.add(sabor1);
        panelSabores.add(sabor2);
        panelSabores.add(sabor3);
        panelSabores.add(sabor4);
        panelSabores.add(sabor5);
        add(panelSabores);

        // Painel para borda (JRadioButton)
        JPanel panelBorda = new JPanel();
        panelBorda.setBorder(BorderFactory.createTitledBorder("Borda"));
        ButtonGroup bordaGroup = new ButtonGroup();
        JRadioButton comBorda = new JRadioButton("Com borda");
        JRadioButton semBorda = new JRadioButton("Sem borda");
        bordaGroup.add(comBorda);
        bordaGroup.add(semBorda);
        panelBorda.add(comBorda);
        panelBorda.add(semBorda);
        add(panelBorda);

        // Painel para opções de entrega (JComboBox)
        JPanel panelEntrega = new JPanel();
        panelEntrega.setBorder(BorderFactory.createTitledBorder("Opção de Entrega"));
        String[] opcoesEntrega = {"Tele Entrega", "Retira no local"};
        JComboBox<String> comboBoxEntrega = new JComboBox<>(opcoesEntrega);
        panelEntrega.add(comboBoxEntrega);
        add(panelEntrega);

        // Painel para opcionais (JCheckBox)
        JPanel panelOpcionais = new JPanel();
        panelOpcionais.setBorder(BorderFactory.createTitledBorder("Opcionais"));
        JCheckBox opcional1 = new JCheckBox("Azeitona");
        JCheckBox opcional2 = new JCheckBox("Bacon");
        JCheckBox opcional3 = new JCheckBox("Cebola");
        JCheckBox opcional4 = new JCheckBox("Catupiry");

        panelOpcionais.add(opcional1);
        panelOpcionais.add(opcional2);
        panelOpcionais.add(opcional3);
        panelOpcionais.add(opcional4);
        add(panelOpcionais);

        // Botão de confirmação de pedido
        JButton confirmar = new JButton("Confirmar Pedido");
        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pedido = "Pedido:\n";
                double total = PRECO_PIZZA_BASE; // Começa com o preço base da pizza

                // Sabores selecionados
                int saboresSelecionados = 0;
                pedido += "Sabores: ";
                if (sabor1.isSelected()) {
                    pedido += "Calabresa, ";
                    saboresSelecionados++;
                }
                if (sabor2.isSelected()) {
                    pedido += "Mussarela, ";
                    saboresSelecionados++;
                }
                if (sabor3.isSelected()) {
                    pedido += "Frango com Catupiry, ";
                    saboresSelecionados++;
                }
                if (sabor4.isSelected()) {
                    pedido += "Marguerita, ";
                    saboresSelecionados++;
                }
                if (sabor5.isSelected()) {
                    pedido += "Pepperoni, ";
                    saboresSelecionados++;
                }
                pedido = pedido.replaceAll(", $", "") + "\n";

                // Validação para garantir que pelo menos 1 sabor seja selecionado
                if (saboresSelecionados < MIN_SABORES || saboresSelecionados > MAX_SABORES) {
                    JOptionPane.showMessageDialog(null, "Selecione entre 1 e 3 sabores de pizza.");
                    return;
                }

                // Adicionar preço adicional para sabores extras
                if (saboresSelecionados > 1) {
                    total += (saboresSelecionados - 1) * PRECO_SABOR_ADICIONAL;
                }

                // Borda
                if (comBorda.isSelected()) {
                    pedido += "Borda: Com borda (+R$ " + PRECO_BORDA + ")\n";
                    total += PRECO_BORDA;
                } else if (semBorda.isSelected()) {
                    pedido += "Borda: Sem borda\n";
                } else {
                    // Validação para garantir que o tipo de borda seja selecionado
                    JOptionPane.showMessageDialog(null, "Selecione o tipo de borda.");
                    return;
                }

                // Opção de entrega
                String opcaoEntrega = comboBoxEntrega.getSelectedItem().toString();
                pedido += "Entrega: " + opcaoEntrega + "\n";
                if (opcaoEntrega.equals("Tele Entrega")) {
                    pedido += "(+R$ " + PRECO_ENTREGA + " pela entrega)\n";
                    total += PRECO_ENTREGA;
                }

                // Opcionais
                pedido += "Opcionais: ";
                int opcionaisCount = 0;
                if (opcional1.isSelected()) {
                    pedido += "Azeitona, ";
                    opcionaisCount++;
                }
                if (opcional2.isSelected()) {
                    pedido += "Bacon, ";
                    opcionaisCount++;
                }
                if (opcional3.isSelected()) {
                    pedido += "Cebola, ";
                    opcionaisCount++;
                }
                if (opcional4.isSelected()) {
                    pedido += "Catupiry, ";
                    opcionaisCount++;
                }
                pedido = pedido.replaceAll(", $", "") + "\n";

                // Cálculo dos opcionais
                total += opcionaisCount * PRECO_OPCIONAIS;

                // Exibe o pedido e o valor total
                pedido += "Valor total: R$ " + String.format("%.2f", total);
                JOptionPane.showMessageDialog(null, pedido);
            }
        });
        add(confirmar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Pizzaria pizzaria = new Pizzaria();
            pizzaria.setVisible(true);
        });
    }
}
