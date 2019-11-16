package com.octoevents.hook.app.utils

import com.octoevents.hook.app.domain.entity.Issue
import com.octoevents.hook.app.web.dto.IssueDTO
import java.util.*

class IssueConverter {

    fun toIssue(issueDTO: IssueDTO?): Issue {
        return Issue(
            0,
            "",
            "",
            "",
            "",
            200,
            Date(),
            Date(),
            Date()
         );
    }

}