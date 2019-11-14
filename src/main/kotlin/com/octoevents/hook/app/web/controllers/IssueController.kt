package com.octoevents.hook.app.web.controllers

import com.octoevents.hook.app.domain.service.IssueService
import com.octoevents.hook.app.utils.IssueConverter
import com.octoevents.hook.app.web.dto.IssueDTO
import io.javalin.http.Context

class IssueController(private val issueService: IssueService, private val issueConverter: IssueConverter) {

    // Verificar se o webhook qual status deve voltar
    fun save(context: Context) {
        context.bodyValidator<IssueDTO>()
            .check({it?.action.isNullOrBlank()})

        val issueForSave = issueConverter.toIssue(context.body<IssueDTO>())
        issueService.create(checkNotNull(issueForSave))
        context.res.status = 202;
        context.result("")
    }
}