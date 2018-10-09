package gcc.demos.kotlin.ktor

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.gson.*
import io.ktor.request.receive
import io.ktor.response.*
import io.ktor.http.*

var greet: String = "Hello"

fun Application.main() {

    install(DefaultHeaders)

    install(CallLogging)

    install(ContentNegotiation){
        gson {
            setPrettyPrinting()
        }
    }

    routing {

        get("/greeting/{name}") {
            val name = call.parameters["name"] ?: throw IllegalArgumentException("Path parameter 'name' not found")
            call.respond(Greeting("$greet", "$name"))
        }

        get("/greeting/") {
            call.respond(HttpStatusCode.MethodNotAllowed, mapOf("OK" to false, "error" to "Method not allowed"))
        }

        post("/greeting/") {
            greet = call.receive<Greeting>().message
        }
    }
}