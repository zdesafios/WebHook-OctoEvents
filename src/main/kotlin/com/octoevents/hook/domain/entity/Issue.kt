package com.octoevents.hook.domain.entity

import java.util.*

data class Issue(val id: Int,
                 val action: String,
                 val url: String,
                 val title: String,
                 val user: String,
                 val number: Int,
                 val createdAt: Date,
                 val updatedAt: Date,
                 val closedAt: Date) {}