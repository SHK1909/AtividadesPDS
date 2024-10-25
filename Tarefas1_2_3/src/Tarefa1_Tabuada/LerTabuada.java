package Tarefa1_Tabuada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class LerTabuada {

    public static void main(String[] args) {
        try {
            // Leitura do número através de uma caixa de diálogo
            String input = JOptionPane.showInputDialog("Digite um número para ler sua tabuada:");
            int num = Integer.parseInt(input);

            // Nome do arquivo esperado
            String nomeArquivo = "tabuada_" + num + ".txt";

            // Lê o arquivo
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            StringBuilder conteudo = new StringBuilder();

            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }

            reader.close();

            // Exibe o conteúdo da tabuada
            JOptionPane.showMessageDialog(null, "Conteúdo do arquivo:\n" + conteudo.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "O arquivo não existe.");
        }
    }
}
