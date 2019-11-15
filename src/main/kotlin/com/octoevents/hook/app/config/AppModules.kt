package com.octoevents.hook.app.config

import com.octoevents.hook.app.domain.repository.IssueRepository
import com.octoevents.hook.app.domain.service.IssueService
import com.octoevents.hook.app.utils.IssueConverter
import com.octoevents.hook.app.web.Router
import com.octoevents.hook.app.web.controllers.IssueController
import org.koin.dsl.module

object AppModules {

    private val configModule = module {
        single { DIConfig() }
        single { Router(get()) }
    }

    private val webModule = module {
        single { IssueController(get(), get()) }
        single { IssueConverter() }
    }

    private val domainModule = module {
        single { IssueRepository() }
        single { IssueService(get()) }
    }

    internal val allModules = listOf(configModule, webModule, domainModule)
}