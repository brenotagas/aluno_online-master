package com.devmeister.aluno_online.model

data class User(val name: String,
                val phone: String,
                val address: String,
                val registration: String,
                val profilePicturePath: String?,
                val registrationTokens: MutableList<String>) {
    constructor() : this("", "", "", "", null, mutableListOf())
}

