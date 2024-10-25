package Tarefa1_Contatos;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Agenda {
    private List<Contatinho> contatinhos;

    public Agenda() {
        this.contatinhos = new ArrayList<>();
    }

    // Método para adicionar um contatinho à lista
    public void addContatinho(Contatinho contatinho) {
        contatinhos.add(contatinho);
    }

    // Método para ordenar a lista de contatinhos por nome
    public void ordenarLista() {
        Collections.sort(contatinhos, Comparator.comparing(Contatinho::getNome));
    }

    // Método para salvar a lista ordenada num arquivo de texto
    public void salvarLista(String nomeArquivo) throws IOException {
        ordenarLista();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Contatinho contatinho : contatinhos) {
                writer.write(contatinho.toString());
                writer.newLine();
            }
        }
    }

    // Método para ler um contatinho pelo nome a partir do arquivo
    public Contatinho lerContatinho(String nome, String nomeArquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Contatinho contatinho = Contatinho.fromString(linha);
                if (contatinho.getNome().equalsIgnoreCase(nome)) {
                    return contatinho;
                }
            }
        }
        return null; // Caso não encontre o contatinho
    }

    // Método para carregar todos os contatinhos a partir de um arquivo
    public void carregarContatinhos(String nomeArquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                contatinhos.add(Contatinho.fromString(linha));
            }
        }
    }
}
