package com.example.practicapokemon

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.practicapokemon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding
        private lateinit var credentials :HashMap<String,String>

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)

            binding.loginButton.setOnClickListener {
                val rememberMe = binding.rememberOption
                if (rememberMe.isChecked) {
                    guardarValorEnSharedPreferences()
                }

                val username = binding.usernameEditText.text.toString()
                val password = binding.passwordEditText.text.toString()

                if (username == "admin" && password == "1234") {
                    try {
                        val intent = Intent(this, PokemonListActivity::class.java)
                        startActivity(intent)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    finish()
                }

            }

            credentials  = obtenerValorDeSharedPreferences()
            binding.usernameEditText.setText(credentials[USERNAME_KEY])
            binding.passwordEditText.setText(credentials[PASSWORD_KEY])

            //*borrarValorDeSharedPreferences();
        }

        private fun guardarValorEnSharedPreferences() {

            val username_value = binding.usernameEditText.text.toString()
            val pass_value = binding.passwordEditText.text.toString()

            val prefs: SharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = prefs.edit()
            editor.putString("username", username_value)
            editor.putString("password", pass_value)
            editor.apply()
        }

        private fun obtenerValorDeSharedPreferences(): HashMap<String,String> {
            val prefs: SharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val credentials: HashMap<String,String> = HashMap<String,String>()
            prefs.getString(USERNAME_KEY, "")?.let { credentials.put(USERNAME_KEY, it) }
            prefs.getString(PASSWORD_KEY, "")?.let { credentials.put(PASSWORD_KEY, it) }
            return credentials
        }

        private fun borrarValorDeSharedPreferences(){
            val prefs: SharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            prefs.edit().clear().apply();
        }

        companion object {
            private const val USERNAME_KEY = "username"
            private const val PASSWORD_KEY = "password"
            private const val PREFS_NAME = "MiPreferencia"
        }
    }
