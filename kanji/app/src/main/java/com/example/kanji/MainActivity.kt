package com.example.kanji

import android.os.Bundle
import android.util.JsonReader
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}

class KanjiObj {
    var slug: String? = null
    var isCommon: Boolean? = null
    var tags: String? = null
    var jlpt: Int? = null
    var japanese: List<String>? = null
    var senses: List<String>? = null

    constructor() : super() {}

    constructor(Slug: String, IsCommon: Boolean, Tags: String, Jlpt: Int, Japanese: List<String>, Senses:List<String>) : super() {
        this.slug = Slug
        this.isCommon = IsCommon
        this.tags = Tags
        this.jlpt = Jlpt
        this.japanese = Japanese
        this.senses = Senses
    }
}