package Tarefa1_Tabuada;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class GerarTabuada {

    public static void main(String[] args) {
        try {
            // Leitura do número através de uma caixa de diálogo
            String input = JOptionPane.showInputDialog("Digite um número para gerar sua tabuada:");
            int num = Integer.parseInt(input);

            // Nome do arquivo a ser gerado
            String nomeArquivo = "tabuada_" + num + ".txt";

            // Gera a tabuada e escreve no arquivo
            FileWriter writer = new FileWriter(nomeArquivo);
            for (int i = 1; i <= 10; i++) {
                writer.write(num + " x " + i + " = " + (num * i) + "\n");
            }

            writer.close();

            JOptionPane.showMessageDialog(null, "Tabuada do " + num + " foi gerada com sucesso no arquivo: " + nomeArquivo);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo.");
        }
    }
}
