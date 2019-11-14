package com.octoevents.hook.app.web.dto

data class IssueDTO (
    val action : String?,
    val issue: Issue?,
    val repository: Repository?
)

data class Issue (
    val id : Int,
    val url : String,
    val number : Int,
    val title : String,
    val body : String,
    val user : User?,
    val state : String,
    val locked : Boolean,
    val assignee : String,
    val milestone : String,
    val comments : Int,
    val created_at : String,
    val updated_at : String,
    val closed_at : String
)

data class Repository (
    val id : Int,
    val name : String
)

data class User (
    val login : String,
    val id : Int
)