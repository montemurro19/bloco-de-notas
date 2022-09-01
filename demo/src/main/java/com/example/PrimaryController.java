package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class PrimaryController {

    @FXML private TextArea textArea;
    
    public void salvar(){
        var texto = textArea.getText();

        FileChooser dialogoSalvar = new FileChooser();
        var file = dialogoSalvar.showSaveDialog(null);
        
        //String file = "C:\\Users\\Matheus\\Desktop\\bloco-de-notas\\arquivos\\texto.txt";
        try {
            PrintWriter out = new PrintWriter(file);
            out.write(texto);
            out.close();
        } catch (FileNotFoundException e) {
            var alerta = new Alert(AlertType.ERROR);
            alerta.setContentText("Arquivo não encontrado");
            alerta.show();
        }
        System.out.println("salvar o arquivo" + texto);
    }

    public void abrir(){
        FileChooser dialogoAbrir = new FileChooser();
        var file = dialogoAbrir.showOpenDialog(null);

        try {
            var path = file.toPath();
            //Path path = Path.of("C:\\Users\\Matheus\\Desktop\\bloco-de-notas\\arquivos\\texto.txt");
            String texto;
            texto = Files.readString(path);
            textArea.setText(texto);
        } catch (IOException e) {
            var alerta = new Alert(AlertType.ERROR);
            alerta.setContentText("Erro ao abrir arquivo");
            alerta.show();
        }
    };

}

