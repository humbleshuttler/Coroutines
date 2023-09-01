/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package coroutines

import kotlinx.coroutines.*

fun main() {
  runBlocking(context = CoroutineName("testing-main")) {
    println(coroutineContext[CoroutineName])
    val parentJob = coroutineContext.job
    println("parent job = $parentJob")
    launch(CoroutineName("greeting-scope")) {
      println(coroutineContext[CoroutineName])
      println("child job = ${coroutineContext.job}")
      println(parentJob == coroutineContext.job.parent)
      delay(2000L)
      println("done")
    }
  }
}