package com.devmeister.aluno_online.model

class News(val title: String, val datePosted: String, val image: String){
    override fun toString(): String {
        return title
    }
}