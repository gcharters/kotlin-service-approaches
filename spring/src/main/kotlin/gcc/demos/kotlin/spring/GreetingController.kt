package gcc.demos.kotlin.spring

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/greeting")
class GreetingController {

    var greet = "Hello"

    @GetMapping("{name}")
    fun greeting(@PathVariable name: String) =
            Greeting("$greet", "$name")

    @PostMapping
    fun greeting(@RequestBody greeting: Greeting) {
        greet = greeting.message
    }

}