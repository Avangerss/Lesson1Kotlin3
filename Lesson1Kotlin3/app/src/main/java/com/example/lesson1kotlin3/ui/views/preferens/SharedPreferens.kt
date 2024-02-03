package com.example.lesson1kotlin3.ui.views.preferens

import android.content.Context

class SharedPreferens(context: Context) {

    private val preference =  context.getSharedPreferences(PREFERENCES_USER_NAME,Context.MODE_PRIVATE)

    var isShowRegister: Boolean
        get() =preference.getBoolean(PREFERENCEES_SHOW_REGISTER,false)
        set(value) {
            preference.edit().putBoolean(PREFERENCEES_SHOW_REGISTER,value).apply()
        }

    var user_name: String?
        get() = preference.getString(PREFERENCES_USER_NAME,"")
        set(value) {
            preference.edit().putString(PREFERENCES_USER_NAME,value).apply()
        }
    var age:String?
        get() = preference.getString(PREFERENCES_AGE,"")
        set(value) {
            preference.edit().putString(PREFERENCES_AGE,value).apply ()
        }
    var user_email: String?
        get() = preference.getString(PREFERENCES_EMAIL,"")
        set(value) {
            preference.edit().putString(PREFERENCES_EMAIL,value).apply()
        }
    var user_password: String?
        get() = preference.getString(PREFERENCES_PASSWORD,"")
        set(value) {
            preference.edit().putString(PREFERENCES_PASSWORD,value).apply()
        }

    companion object{
        const val PREFERENCEES_SHOW_REGISTER = "register"
        const val PREFERENCES_USER_NAME ="user_name helper"
        const val PREFERENCES_AGE ="user_age helper"
        const val PREFERENCES_EMAIL ="user_email helper"
        const val PREFERENCES_PASSWORD ="user_rassword helper"
    }
}