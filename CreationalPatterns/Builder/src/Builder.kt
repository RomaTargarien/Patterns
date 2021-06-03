import java.io.File

data class Mail1(val to: String,
                val cc: List<String>,
                val bcc: List<String>,
                val title: String?,
                val message: String?,
                val attachments: List<File>?)

data class Mail2(private var _message: String = "",
                 private var _cc: List<String> = listOf(),
                 private var _bcc: List<String> = listOf(),
                 private var _title: String = "",
                 private var _attachments: List<File> = listOf()) {

    fun message(message: String) : Mail2 {
        _message = message
        return this
    }
    fun cc(cc: List<String>) : Mail2 {
        _cc = cc
        return this
    }
    fun bcc(bcc: List<String>) : Mail2 {
        _bcc = bcc
        return this
    }
    fun title(title: String) : Mail2 {
        _title = title
        return this
    }
}

data class Mail3(var to: String,
                var title: String = "",
                var message: String = "",
                var cc: List<String> = listOf(),
                var bcc: List<String> = listOf(),
                var attachments: List<java.io.File> = listOf())

class MailBuilder(val to: String) {

    private var mail: Mail3 = Mail3(to)
    fun title(title: String): MailBuilder {
        mail.title = title
        return this
    }
    fun message(message: String): MailBuilder {
        mail.message = message
        return this
    }
    // Repeated for other properties
    fun build(): Mail3 {
        return mail
    }
}


fun main() {
    val mail1 = Mail1("manager@company.com", // TO
        listOf(), // CC
        listOf(), // BCC
        "Ping", // Title
        null,
        null) // Message

    val mail2 = Mail2().message("Ping").cc(listOf()) //and so on

    val mail3 = Mail3("hello@mail.com").apply {
        message = "Ping"
    }

    val builder = MailBuilder("manager@company.com").title("Ping").message("hello").build()
}