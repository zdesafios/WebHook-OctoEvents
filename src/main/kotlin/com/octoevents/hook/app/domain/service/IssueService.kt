package com.octoevents.hook.app.domain.service

import com.octoevents.hook.app.domain.entity.Issue
import com.octoevents.hook.app.domain.repository.IssueRepository

class IssueService(private val issueRepository: IssueRepository) {

    fun create(issue: Issue) : Unit {
        issueRepository.save(issue)
    }

    fun getByNumber(number: Long): List<Issue> {
        return issueRepository.findByNumber(number)
    }


}