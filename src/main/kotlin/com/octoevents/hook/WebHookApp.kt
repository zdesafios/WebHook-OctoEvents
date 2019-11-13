package com.octoevents.hook

import com.jayway.jsonpath.JsonPath
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.apibuilder.ApiBuilder.post
import io.javalin.plugin.json.JavalinJson
import java.util.*

fun main(args: Array<String>) {

    val app = Javalin.create().start(9000);
    app.post("events") { context ->
        val issueAsString = context.body()
        val json = JsonPath.parse(issueAsString)
        val action = json.read<String>("$.action")
        val id = json.read<Int>("$.number")
        val issueAsMap = json.read<Map<String, Object>>("$.issue")

    }
}

