package com.houarizegai.firstfxml

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class App : Application() {
    override fun start(stage: Stage) {
        var root: Parent? = FXMLLoader.load(javaClass.getResource("FirstFXML.fxml"))
        stage.scene = Scene(root)
        stage.title = "First App"
        stage.show()
    }
}

fun main() {
    Application.launch(App::class.java)
}