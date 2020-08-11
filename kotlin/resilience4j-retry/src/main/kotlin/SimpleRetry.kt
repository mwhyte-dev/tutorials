import io.github.resilience4j.retry.Retry
import io.github.resilience4j.retry.RetryConfig
import io.github.resilience4j.retry.RetryRegistry
import java.time.Duration
import java.util.function.Supplier


var x = 0

fun main() {
    getWithRetry()
}

fun getWithRetry(): String {
    val config = createRetryConfig()
    val registry = RetryRegistry.of(config)
    val retry: Retry = registry.retry("my-first-retry")
    val decorateFunction: Supplier<String> = Retry.decorateSupplier(retry) {
        get()
    }

    return decorateFunction.get()
}

private fun createRetryConfig(): RetryConfig {
    return RetryConfig.custom<Any>()
        .maxAttempts(3)
        .waitDuration(Duration.ofMillis(100))
        .retryExceptions(NullPointerException::class.java)
        .retryOnResult { response -> checkResult(response as String) }
        .build()
}

private fun checkResult(response: String): Boolean {
    return response == "error response"
}

private fun get(): String {
    x++
    println("called with x=${x}")
    return when (x) {
        1 -> throw java.lang.NullPointerException("really!!!")
        2 -> "error response"
        else -> { // Note the block
            return "winner"
        }
    }

}