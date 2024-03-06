package dev.reimer.elasticsearch.ktx.util

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.suspendCancellableCoroutine
import org.elasticsearch.action.ActionListener
import org.elasticsearch.client.Response
import org.elasticsearch.client.ResponseListener
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

@JvmName("awaitResponseReceiver")
suspend inline fun ((ResponseListener) -> Unit).await(): Response = coroutineScope {
    suspendCancellableCoroutine<Response> { continuation ->
        invoke(object : ResponseListener {
            override fun onSuccess(response: Response) = continuation.resume(response)
            override fun onFailure(exception: Exception) = continuation.resumeWithException(exception)
        })
    }
}

suspend inline fun awaitResponse(crossinline block: (ResponseListener) -> Unit): Response = coroutineScope {
    suspendCancellableCoroutine<Response> { continuation ->
        block(object : ResponseListener {
            override fun onSuccess(response: Response) = continuation.resume(response)
            override fun onFailure(exception: Exception) = continuation.resumeWithException(exception)
        })
    }
}

@JvmName("awaitActionReceiver")
suspend inline fun <T> ((ActionListener<T>) -> Unit).await(): T = coroutineScope {
    suspendCancellableCoroutine<T> { continuation ->
        invoke(object : ActionListener<T> {
            override fun onResponse(response: T) = continuation.resume(response)
            override fun onFailure(exception: Exception) = continuation.resumeWithException(exception)
        })
    }
}

suspend inline fun <T> awaitAction(crossinline block: (ActionListener<T>) -> Unit): T = coroutineScope {
    suspendCancellableCoroutine<T> { continuation ->
        block(object : ActionListener<T> {
            override fun onResponse(response: T) = continuation.resume(response)
            override fun onFailure(exception: Exception) = continuation.resumeWithException(exception)
        })
    }
}