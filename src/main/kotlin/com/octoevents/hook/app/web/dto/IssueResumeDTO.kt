package com.octoevents.hook.app.web.dto

import org.joda.time.DateTime

data class IssueResumeDTO(
    val id: Long,
    val action: String,
    val title: String,
    val number: Long,
    val createdAt: String,
    val updatedAt: String,
    val closedAt: String?
)