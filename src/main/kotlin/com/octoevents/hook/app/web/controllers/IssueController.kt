package com.octoevents.hook.app.web.controllers

import com.octoevents.hook.app.domain.service.IssueService
import com.octoevents.hook.app.utils.IssueConverter
import com.octoevents.hook.app.web.dto.IssueDTO
import io.javalin.http.Context
import org.eclipse.jetty.http.HttpStatus

class IssueController(private val issueService: IssueService, private val issueConverter: IssueConverter) {

    // Verificar se o webhook qual status deve voltar
    fun save(context: Context) {
        context.bodyValidator<IssueDTO>()
            .check({dto->
                dto?.action.isBlank()
            }).also { validator ->
                val issueForSave = issueConverter.toIssue(validator.value)
                issueService.create(issueForSave)
                context.res.status = HttpStatus.CREATED_201;
                context.result("")
            }
    }
}