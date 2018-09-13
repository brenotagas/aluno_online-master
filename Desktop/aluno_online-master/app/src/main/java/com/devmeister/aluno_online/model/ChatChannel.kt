package com.devmeister.aluno_online.model

data class ChatChannel(val userIds: MutableList<String>) {
    constructor() : this(mutableListOf())
}