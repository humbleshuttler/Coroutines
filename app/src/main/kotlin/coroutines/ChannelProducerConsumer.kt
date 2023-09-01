package coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlin.random.Random

val random = Random(100)

fun main() = runBlocking {
    val channel = Channel<Int>()
    launch {
        repeat(5) {
            delay(1000L)
            println("Producing next")
            channel.send(random.nextInt())
        }
    }
    launch {
        while (!channel.isClosedForSend)
    }
}