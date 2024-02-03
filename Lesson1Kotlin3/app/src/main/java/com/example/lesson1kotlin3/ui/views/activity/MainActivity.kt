package com.example.lesson1kotlin3.ui.views.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.lesson1kotlin3.R
import com.example.lesson1kotlin3.ui.views.preferens.SharedPreferens

class MainActivity : AppCompatActivity() {
    private val preferensHelper: SharedPreferens by lazy {
        SharedPreferens(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpNavigation(savedInstanceState)
    }

    private fun setUpNavigation(savedInstanceState: Bundle?) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_main_activity) as NavHostFragment
        val navController = navHostFragment.navController
        if (savedInstanceState == null) {
            val navGraph = navController.navInflater.inflate(R.navigation.naw_graph)

            if (!preferensHelper.isShowRegister){
                navGraph.setStartDestination(R.id.registrationFragment)
                navController.graph = navGraph
            }
        }
    }
}