package com.houarizegai.firstfxml

import javafx.fxml.FXML
import javafx.fxml.Initializable
import java.net.URL
import java.util.*
import javafx.scene.control.Label

class FirstFXMLController : Initializable {

    @FXML var lbl: Label? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {

    }

    @FXML
    fun onSayHello() {
        lbl?.text = "Hello World!"
    }
}