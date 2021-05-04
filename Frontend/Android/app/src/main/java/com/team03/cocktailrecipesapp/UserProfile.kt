package com.team03.cocktailrecipesapp

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class UserProfile : AppCompatActivity() {

    lateinit var test :TextView
    lateinit var swtLangauge: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        loadLanguagePreference()
        test = findViewById(R.id.txtExample)
        swtLangauge = findViewById(R.id.swtlanguage)
        loadSwitchSteate()
        swtLangauge.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
            {
                setLanguage("kv")
            }
            else
            {
                setLanguage("en")
            }
            updateFields()
            saveSwitchState(isChecked)
        }
        updateFields()
    }


    fun setLanguage(language: String)
    {
        println("Language $language")
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        saveLanguagePreference(language)
    }

    fun saveLanguagePreference(language: String)
    {
        val editor: SharedPreferences.Editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("Language", language).apply()
    }

    fun loadLanguagePreference()
    {
        val shared_lang: SharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE)
        val language: String? = shared_lang.getString("Language", "en")
        if (language != null) {
            setLanguage(language)
        }
    }

    fun saveSwitchState(state: Boolean)
    {
        val editor: SharedPreferences.Editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putBoolean("state", state).apply()
    }

    fun loadSwitchSteate()
    {
        val shared_lang: SharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE)
        val state: Boolean? = shared_lang.getBoolean("state", false)
        if (state != null) {
            swtLangauge.isChecked = state
        }
    }

    fun updateFields() : Boolean
    {
        //TODO set all resources in the app to the right string resource
        return false
    }

}