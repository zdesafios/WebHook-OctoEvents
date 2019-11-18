package com.octoevents.hook.app.utils

import com.octoevents.hook.app.domain.entity.Issue
import com.octoevents.hook.app.web.dto.IssueDTO
import com.octoevents.hook.app.web.dto.IssueResumeDTO
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import java.text.SimpleDateFormat


class IssueConverter() {
    private val formatter: DateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
    private val f = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")

    fun toIssue(issueDTO: IssueDTO?): Issue {
        var closedAt: DateTime? = null;
        if(issueDTO?.issue?.closed_at != null) {
            closedAt = formatter.parseDateTime(issueDTO?.issue?.closed_at!!)
        }
        return Issue(
            id = issueDTO?.issue?.id!!,
            action = issueDTO?.action!!,
            url = issueDTO?.issue.url!!,
            title = issueDTO?.issue.title!!,
            user = issueDTO?.issue.user?.login!!,
            number = issueDTO?.issue.number!!,
            createdAt = formatter.parseDateTime(issueDTO.issue.created_at),
            updatedAt = formatter.parseDateTime(issueDTO.issue.updated_at),
            closedAt = closedAt
         )
    }

    fun toIssueResume(issues: List<Issue>): List<IssueResumeDTO> {
        return issues.map {i-> toIssueResume(i) }.sortedBy(IssueResumeDTO::createdAt)
    }

    fun toIssueResume(issue: Issue): IssueResumeDTO {
        return IssueResumeDTO(
            id = issue.id,
            number = issue.number,
            action = issue.action,
            title = issue.title,
            createdAt = f.format(issue.createdAt.toDate()),
            updatedAt = f.format(issue.updatedAt.toDate()),
            closedAt = f.format(issue.createdAt.toDate())
        )
    }

}