package com.houarizegai.helloworld

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.stage.Stage

class HelloWorld : Application() {

    override fun start(stage: Stage) {
        var lbl = Label("Hello World!")
        var btn = Button("Say Hello!")

        btn.setOnAction {
            println("Hello Kotlin Everywhere Tiaret!")
        }

        var root = VBox()
        root.children.addAll(lbl, btn)

        var scene = Scene(root, 600.0, 200.0)
        stage.scene = scene
        stage.title = "My First App"
        stage.show()
    }
}

fun main() {
    Application.launch(HelloWorld::class.java)
}
