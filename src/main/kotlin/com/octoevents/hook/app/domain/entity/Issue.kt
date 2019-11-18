package com.octoevents.hook.app.domain.entity

import org.joda.time.DateTime

data class Issue(
    val id: Long,
    val action: String,
    val url: String,
    val title: String,
    val user: String,
    val number: Long,
    val createdAt: DateTime,
    val updatedAt: DateTime,
    val closedAt: DateTime?)