package com.devmeister.aluno_online

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.devmeister.aluno_online.fragment.ListUserChatFragment
import com.devmeister.aluno_online.fragment.EditPerfilFragment
import com.devmeister.aluno_online.fragment.NewsFragment
import kotlinx.android.synthetic.main.activity_main.*
import com.devmeister.aluno_online.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(NewsFragment())

        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    replaceFragment(NewsFragment())
                    true
                }
                R.id.navigation_chat -> {
                    replaceFragment(ListUserChatFragment())
                    true
                }
                R.id.navigation_user -> {
                    replaceFragment(EditPerfilFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_layout, fragment)
                .addToBackStack(null)
                .commit()
    }

}
