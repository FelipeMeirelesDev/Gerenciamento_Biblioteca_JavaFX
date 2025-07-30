package com.felipemeireles.sistemadebiblioteca.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BibliotecaController {

    @FXML private Button btnSair;

    @FXML private Pane painelDeConteudo;

    // Botões que mudam a cor ao serem clicados:
    @FXML private Button btnCadastrarAluno;
    @FXML private Button btnInicio;
    @FXML private Button btnListarLivros;
    @FXML private Button btnEmprestarLivros, btnRelatorio;


    // Lista para facilitar resetar as cores dos botões:
    private List<Button> botoes;

    @FXML
    public void initialize() {
        Navegador.setPainel(painelDeConteudo); // registra o painel para acesso global

        // ✅ Inicializa lista de botões ANTES de usar setBotaoAtivo
        botoes = Arrays.asList(btnCadastrarAluno, btnInicio, btnListarLivros, btnEmprestarLivros, btnRelatorio);

        try {
            Pane dashboard = FXMLLoader.load(getClass().getResource("/com/felipemeireles/sistemadebiblioteca/view/Dashboard.fxml"));
            painelDeConteudo.getChildren().setAll(dashboard);
            setBotaoAtivo(btnInicio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setBotaoAtivo(Button botaoAtivo) {
        for (Button btn : botoes) {
            if (btn.equals(botaoAtivo)) {
                // Cor de botão ativo (exemplo: azul escuro com texto branco)
                btn.setStyle("-fx-border-color: white; -fx-background-color: white; -fx-text-fill: #0a6789;");
            } else {
                // Cor padrão do botão
                btn.setStyle("-fx-border-color: white; -fx-background-color: #0a6789; -fx-text-fill: white;");
            }
        }
    }

    @FXML
    private void abrirTelaListarLivros(ActionEvent event) throws IOException {
        Parent tela2 = FXMLLoader.load(getClass().getResource("/com/felipemeireles/sistemadebiblioteca/view/Livros.fxml"));
        painelDeConteudo.getChildren().setAll(tela2);
        setBotaoAtivo(btnListarLivros);
    }

    @FXML
    private void abrirDashboard(ActionEvent event) throws IOException {
        Parent tela2 = FXMLLoader.load(getClass().getResource("/com/felipemeireles/sistemadebiblioteca/view/Dashboard.fxml"));
        painelDeConteudo.getChildren().setAll(tela2);
        setBotaoAtivo(btnInicio);
    }

    @FXML
    private void abrirEmprestarLivro(ActionEvent event) throws IOException {
        Parent tela2 = FXMLLoader.load(getClass().getResource("/com/felipemeireles/sistemadebiblioteca/view/EmprestarLivro.fxml"));
        painelDeConteudo.getChildren().setAll(tela2);
        setBotaoAtivo(btnEmprestarLivros);
    }

    @FXML
    private void abrirTelaAlunos(ActionEvent event) throws IOException {
        Parent tela2 = FXMLLoader.load(getClass().getResource("/com/felipemeireles/sistemadebiblioteca/view/Alunos.fxml"));
        painelDeConteudo.getChildren().setAll(tela2);
        setBotaoAtivo(btnCadastrarAluno);
    }

    @FXML
    private void xa(ActionEvent event) throws IOException {
        Parent tela2 = FXMLLoader.load(getClass().getResource("/com/felipemeireles/sistemadebiblioteca/view/AdicionarAluno.fxml"));
        painelDeConteudo.getChildren().setAll(tela2);
    }

    @FXML
    public void sair() {
        javafx.application.Platform.exit();
    }

}
