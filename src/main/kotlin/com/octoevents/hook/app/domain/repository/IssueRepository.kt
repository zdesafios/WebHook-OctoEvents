package com.octoevents.hook.app.domain.repository

import com.octoevents.hook.app.domain.entity.Issue
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import javax.sql.DataSource

private object Issues: Table() {
    val id: Column<Long> = long(name = "id")
    val action: Column<String> = varchar(name = "action", length = 255)
    val url: Column<String> = varchar(name = "url", length = 255)
    val title: Column<String> = varchar(name = "title", length = 255)
    val user: Column<String> = varchar(name = "user", length = 255)
    val number: Column<Long> = long(name = "number")
    val createdAt: Column<DateTime> = date(name="create_at")
    val updatedAt: Column<DateTime> = date(name="updated_at")
    val closedAt: Column<DateTime?> = date(name="closed_at").nullable()

    fun loadFromRow(row: ResultRow): Issue {
        return Issue(
            row[id],
            row[action],
            row[url],
            row[title],
            row[user],
            row[number],
            row[createdAt],
            row[updatedAt],
            row[closedAt]
        );
    }
}

class IssueRepository(private val dataSource: DataSource) {
    init {
        transaction(Database.connect(dataSource)) {
            SchemaUtils.create(Issues)
        }
    }

    fun save(issue: Issue) {
        transaction(Database.connect(dataSource)) {
            Issues.insert { row ->
                row[id] = issue.id
                row[number] = issue.number
                row[title] = issue.title
                row[action] = issue.action
                row[user] = issue.user
                row[url] = issue.url
                row[createdAt] = issue.createdAt
                row[updatedAt] = issue.updatedAt
                row[closedAt] = issue.closedAt
            }
            commit()
        }
    }

    fun findByNumber(number: Long): List<Issue> {
        return transaction(Database.connect(dataSource)) {
            Issues.select{Issues.number eq number}.map { row->
                Issues.loadFromRow(row)
            }
        }
    }
}