package gcc.demos.kotlin.spring

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/greeting")
class GreetingController {

    val counter = AtomicLong()
    var greet = "Hello"

    @GetMapping
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "$greet", "$name")

    @PostMapping
    fun greeting(@RequestBody greeting: Greeting) {
        greet = greeting.greet
    }

}