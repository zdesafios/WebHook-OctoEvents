package com.octoevents.hook.domain.service

import com.octoevents.hook.domain.entity.Issue
import com.octoevents.hook.domain.repository.IssueRepository

class IssueService(private val issueRepository: IssueRepository) {

    fun create(issue: Issue) : Unit {
        issueRepository.save(issue)
    }

}