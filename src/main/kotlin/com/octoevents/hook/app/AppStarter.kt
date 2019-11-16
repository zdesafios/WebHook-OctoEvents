package com.octoevents.hook.app

import com.octoevents.hook.app.web.Router
import org.koin.core.KoinComponent
import org.koin.core.inject

class AppStarter: KoinComponent {
    val router: Router by inject<Router>()
}