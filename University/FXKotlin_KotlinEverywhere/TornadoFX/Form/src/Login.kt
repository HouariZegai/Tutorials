import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import javafx.application.Application
import javafx.beans.property.StringProperty
import javafx.geometry.Orientation
import javafx.scene.layout.VBox
import tornadofx.*

class User {
    var username by property<String>()
    fun usernameProperty() = getProperty(User::username)

    var password by property<String>()
    fun passwordProperty() = getProperty(User::password)

    override fun toString() = username
}

class UserModel : ItemViewModel<User>(User()) {
    val username: StringProperty = bind {item?.usernameProperty()}
    val password: StringProperty = bind {item?.passwordProperty()}
}

class Login: View("Login") {
    val user: UserModel by inject()

    override val root = VBox(
        fieldset("Login", FontAwesomeIconView(FontAwesomeIcon.USER), labelPosition = Orientation.VERTICAL) {
            field("Username") {
                textfield(user.username)
            }

            field("Password")  {
                passwordfield(user.password)
            }

            button("Login") {
                action {
                    print("Hello World!")
                }
            }
        }
    )
}

class LoginApp: App(Login::class)

fun main() {
    Application.launch(LoginApp::class.java)
}