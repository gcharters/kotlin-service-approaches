package gcc.demos.kotlin.ktor

import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main(args: Array<String>) {
    embeddedServer(Netty, commandLineEnvironment(args)).start()
}