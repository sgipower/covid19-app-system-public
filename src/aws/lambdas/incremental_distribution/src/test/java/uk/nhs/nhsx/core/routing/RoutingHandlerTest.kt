package uk.nhs.nhsx.core.routing

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.google.common.collect.Maps
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import uk.nhs.nhsx.core.HttpResponses
import uk.nhs.nhsx.testhelper.ContextBuilder.TestContext
import java.util.*

class RoutingHandlerTest {

    @Test
    fun noHeaders() {
        assertThrows(RuntimeException::class.java) {
            MyRoutingHandler("content-type").handleRequest(APIGatewayProxyRequestEvent(), TestContext())
        }
    }

    @Test
    fun lowercase() {
        val request = APIGatewayProxyRequestEvent()
        val headers = Maps.newHashMap<String, String>()
        headers["Content-Type"] = "something"
        request.headers = headers
        MyRoutingHandler("content-type").handleRequest(request, TestContext())
    }

    @Test
    fun uppercase() {
        val request = APIGatewayProxyRequestEvent()
        val headers = Maps.newHashMap<String, String>()
        headers["content-type"] = "something"
        request.headers = headers
        MyRoutingHandler("Content-Type").handleRequest(request, TestContext())
    }

    private class MyRoutingHandler(val header: String) : RoutingHandler() {
        override fun handler(): Routing.Handler =
            Routing.Handler { request ->
                Optional.ofNullable(request.headers[header])
                    .map { HttpResponses.ok() }
                    .orElseThrow { RuntimeException("not there") }
            }
    }
}