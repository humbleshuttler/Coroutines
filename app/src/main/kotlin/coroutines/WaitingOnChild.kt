package coroutines

import kotlinx.coroutines.*

fun main(): Unit = runBlocking{
    val job1: Job = launch {
        delay(1000L)
        println("job1 done")
    }
    val job2: Job = launch {
        delay(5000L)
        println("job2 done")
    }
    coroutineContext.job.children?.forEach { it.join() }
    println("all jobs done")
}