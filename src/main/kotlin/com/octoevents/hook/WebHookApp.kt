package com.octoevents.hook

import com.google.gson.GsonBuilder
import com.octoevents.hook.app.config.AppModules
import com.octoevents.hook.app.config.DIConfig
import com.octoevents.hook.app.domain.repository.IssueRepository
import com.octoevents.hook.app.domain.service.IssueService
import com.octoevents.hook.app.utils.IssueConverter
import com.octoevents.hook.app.web.Router
import com.octoevents.hook.app.web.controllers.IssueController
import io.javalin.Javalin
import io.javalin.plugin.json.FromJsonMapper
import io.javalin.plugin.json.JavalinJson
import java.util.*
import io.javalin.plugin.json.ToJsonMapper
import org.koin.core.context.startKoin


fun main(args: Array<String>) {
    startKoin {
        printLogger()
        modules(AppModules.allModules)
    }
    val gson = GsonBuilder().create()

    JavalinJson.fromJsonMapper = object: FromJsonMapper {
        override  fun <T> map(json: String, targetClass: Class<T>) = gson.fromJson(json, targetClass)
    }

    JavalinJson.toJsonMapper = object : ToJsonMapper {
        override fun map(obj: Any): String = gson.toJson(obj)
    }

    val app = Javalin.create().start(9000)
    DIConfig().router.register(app)

}

