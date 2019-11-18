package com.octoevents.hook.app.web

import com.octoevents.hook.app.web.controllers.IssueController
import io.javalin.Javalin

class Router(private val issueController: IssueController) {

    fun register(app: Javalin) {
        app.post("/payload", issueController::save)
        app.get("/issue/:number", issueController::getByNumber)
    }

}