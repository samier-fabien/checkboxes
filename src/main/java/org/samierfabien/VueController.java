package org.samierfabien;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class VueController {
    private TextModel textModel;
    @FXML
    public AnchorPane root;
    @FXML
    public TextField textField;
    @FXML
    public Label label;
    @FXML
    public TitledPane menuChoix;
    @FXML
    public TitledPane menuFond;
    @FXML
    public TitledPane menuTexte;
    @FXML
    public TitledPane menuCasse;
    @FXML
    public CheckBox choixFond;
    @FXML
    public CheckBox choixTexte;
    @FXML
    public CheckBox choixCasse;
    @FXML
    public RadioButton fondRouge;
    @FXML
    public RadioButton fondVert;
    @FXML
    public RadioButton fondBleu;
    @FXML
    public RadioButton texteRouge;
    @FXML
    public RadioButton texteBlanc;
    @FXML
    public RadioButton texteNoir;
    @FXML
    public RadioButton casseMinuscule;
    @FXML
    public RadioButton casseMajuscule;
    @FXML
    public ToggleGroup goupeFond;
    @FXML
    public ToggleGroup groupeText;
    @FXML
    public ToggleGroup groupeCasse;

    public VueController() {
        this.textModel = new TextModel();
    }
    @FXML
    public void initialize() {
        ajoutTextEvenements();
    }

    public void ajoutTextEvenements() {
        /*
        -Evénementiel via des EventHandler.
        -Possible aussi de le faire via fxml avec scenebuilder. Dans ce cas là, pas besoin de coder ce qui suit, ça sera
        dans le fxml.
        texte.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                System.out.println("Key Pressed: " + ke.getCode());
            }
        });
        */

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            textChanged(newValue);
        });
    }

    public void textChanged (String newValue) {
        System.out.println("text changé");
        textModel.setTexteOriginal(newValue);
        textModel.setTexteMinuscule(textModel.getTexteOriginal());
        textModel.setTexteMajuscule(textModel.getTexteOriginal());
    }

}