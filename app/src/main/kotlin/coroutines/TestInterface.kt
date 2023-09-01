package coroutines

interface TestInterface {

    val value: String
}

public fun TestInterface(s: String): TestInterface {
    return TestInterface("default$s")
}