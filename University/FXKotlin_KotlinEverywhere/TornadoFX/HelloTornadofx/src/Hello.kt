import javafx.application.Application
import javafx.scene.control.Label
import javafx.scene.layout.StackPane
import tornadofx.*

class HelloWorld: View() {
    override val root = StackPane(Label("Hello TornadoFX!"))
}

class HelloWorldApp : App(HelloWorld::class)

fun main() {
    Application.launch(HelloWorldApp::class.java)
}