package org.samierfabien;

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
    public ToggleGroup groupeFond;
    @FXML
    public ToggleGroup groupeTexte;
    @FXML
    public ToggleGroup groupeCasse;

    public VueController() {
        this.textModel = new TextModel();
    }

    @FXML
    public void initialize() {
        modelMAJ("");
        evenementTexte();
        evenementMenuFond();
        evenementMenuTexte();
        evenementMenuCasse();
        evenementChoixFond();
        evenementChoixTexte();
        evenementChoixCasse();
    }

    public void evenementTexte() {
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
            modelMAJ(newValue);
            setLabel();
            menuChoixChanged();
        });
    }

    public void evenementMenuFond() {
        choixFond.selectedProperty().addListener((observable, oldValue, newValue) -> {
            menuFond.setDisable(!newValue);
        });
    }

    public void evenementMenuTexte() {
        choixTexte.selectedProperty().addListener((observable, oldValue, newValue) -> {
            menuTexte.setDisable(!newValue);
        });
    }

    public void evenementMenuCasse() {
        choixCasse.selectedProperty().addListener((observable, oldValue, newValue) -> {
            menuCasse.setDisable(!newValue);
            setLabel();
        });
    }

    public void evenementChoixFond() {
        groupeFond.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            try {
                RadioButton temp = (RadioButton)newValue.getToggleGroup().getSelectedToggle();
                setFond(temp.getText());
            } catch (Exception e) {}
        });
    }

    public void evenementChoixTexte() {
        groupeTexte.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            try {
                RadioButton temp = (RadioButton)newValue.getToggleGroup().getSelectedToggle();
                setColor(temp.getText());
            } catch (Exception e) {}
        });
    }

    public void evenementChoixCasse() {
        groupeCasse.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            try {
                RadioButton temp = (RadioButton)newValue.getToggleGroup().getSelectedToggle();
                setLabel();
            } catch (Exception e) {}
        });
    }

    public void setFond(String color) {
        switch (color) {
            case "Rouge" -> textModel.setFondCouleur("-fx-background-color: red;");
            case "Vert" -> textModel.setFondCouleur("-fx-background-color: green;");
            case "Bleu" -> textModel.setFondCouleur("-fx-background-color: blue;");
            default -> textModel.setFondCouleur("-fx-background-color: white;");
        }
        setLabel();
    }

    private void setColor(String color) {
        switch (color) {
            case "Rouge" -> textModel.setTexteCouleur("-fx-text-fill: red;");
            case "Blanc" -> textModel.setTexteCouleur("-fx-text-fill: white;");
            default -> textModel.setTexteCouleur("-fx-text-fill: black;");
        }
        setLabel();
    }

    public void setLabel() {
        label.setStyle(textModel.getFondCouleur()+textModel.getTexteCouleur());
        if (choixCasse.isSelected()) {
            try {
                RadioButton temp = (RadioButton)groupeCasse.getSelectedToggle();
                if (temp.getText().equals("Minuscule")) {
                    label.setText(textModel.getTexteMinuscule());
                } else if (temp.getText().equals("Majuscule")) {
                    label.setText(textModel.getTexteMajuscule());
                } else {
                    label.setText(textModel.getTexteOriginal());
                }
            } catch (Exception e) {

            }
        } else {
            label.setText(textModel.getTexteOriginal());
        }
    }

    public void modelMAJ(String newValue) {
        textModel.setTexteOriginal(newValue);
        textModel.setTexteMinuscule(textModel.getTexteOriginal());
        textModel.setTexteMajuscule(textModel.getTexteOriginal());
    }

    public void menuChoixChanged() {
        if (textModel.getTexteOriginal().equals("")) {
            remiseAZero();
        } else {
            menuChoix.setDisable(false);
        }
    }

    private void remiseAZero() {
        menuChoix.setDisable(true);
        menuFond.setDisable(true);
        menuTexte.setDisable(true);
        menuCasse.setDisable(true);
        choixFond.setSelected(false);
        choixTexte.setSelected(false);
        choixCasse.setSelected(false);
        fondRouge.setSelected(false);
        fondBleu.setSelected(false);
        fondVert.setSelected(false);
        texteRouge.setSelected(false);
        texteBlanc.setSelected(false);
        texteNoir.setSelected(false);
        casseMinuscule.setSelected(false);
        casseMajuscule.setSelected(false);
        textModel.setFondCouleur("-fx-background-color: #F4F4F4;");
        textModel.setTexteCouleur("-fx-text-fill: black;");
        setLabel();
    }

}
