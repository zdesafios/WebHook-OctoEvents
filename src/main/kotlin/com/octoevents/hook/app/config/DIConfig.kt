package com.octoevents.hook.app.config

import com.octoevents.hook.app.web.Router
import org.koin.core.KoinComponent
import org.koin.core.inject

class DIConfig: KoinComponent {
    val router: Router by inject<Router>()
}