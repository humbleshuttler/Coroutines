import kotlinx.coroutines.*


suspend fun doNetworkCall(): String {
    coroutineScope {
        launch(context = CoroutineName("network-call-scope")) {
            log("performing network operation")
            delay(5000L) // n/w operation
        }
    }
    return "response from network call"
}

suspend fun doIO(): String {
    delay(1000L)
    return "response from io"
}


fun main() {
    runBlocking(CoroutineName("Main")) {
        log("started")
        launch {
            log("calling network")
            println(doNetworkCall())
        }
        launch {
            println(doIO())
        }
    }
}

fun CoroutineScope.log(msg: String) {
    val name = coroutineContext[CoroutineName]?.name
    println("[$name] $msg")
}