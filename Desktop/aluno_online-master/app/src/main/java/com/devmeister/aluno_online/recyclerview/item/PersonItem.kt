package com.devmeister.aluno_online.recyclerview.item

import android.content.Context
import com.devmeister.aluno_online.R
import com.devmeister.aluno_online.model.User
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.contatos.*

class PersonItem(val person: User,
                 val userId: String,
                 private val context: Context)
    : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {

        if (   position==1 ) {
            viewHolder.textView_name.text = "breno 002"//person.name
            viewHolder.textView_registration.text = "1234567"//person.registration
        }else  if( position==2){
            viewHolder.textView_name.text = "breno 003"//person.name
            viewHolder.textView_registration.text = "654321"//person.registration
        } else {
            viewHolder.textView_name.text = "breno 001"//person.name
            viewHolder.textView_registration.text = "87364739"//person.registration}
        }
    }

    override fun getLayout() = R.layout.contatos
}