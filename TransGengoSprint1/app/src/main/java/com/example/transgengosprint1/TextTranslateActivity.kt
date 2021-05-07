package com.example.transgengosprint1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.mlkit.nl.translate.*
import com.google.mlkit.common.model.DownloadConditions


class TextTranslateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_translate)

        val editText = findViewById<EditText>(R.id.editText)
        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)

        val options = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH)
            .setTargetLanguage(TranslateLanguage.JAPANESE)
            .build()
        val englishJapaneseTranslator: Translator = Translation.getClient(options)
        val conditions = DownloadConditions.Builder()
            .requireWifi()
            .build()

        englishJapaneseTranslator.downloadModelIfNeeded(conditions)
            .addOnSuccessListener {
                // Model downloaded successfully. Okay to start translating.
                Log.i("Success", "Japanese Model downloaded")

            }
            .addOnFailureListener { exception ->
                // Model couldn’t be downloaded or other internal error.
                Log.e("Error", "Model not downloaded")
            }

        englishJapaneseTranslator.translate("ready to translate")
            .addOnSuccessListener { translatedText ->
                // Translation successful.
                textView.text = translatedText
            }
            .addOnFailureListener { exception ->
                // Error.
                // ...
                textView.text = "please wait 10-20 secondsfor model to download"
            }


        button.setOnClickListener {
            englishJapaneseTranslator.translate(editText.text.toString())
                .addOnSuccessListener { translatedText ->
                    // Translation successful.
                    textView.text = translatedText
                }
                .addOnFailureListener { exception ->
                    // Error.
                    // ...
                    textView.text = "translation failed"
                }
        }
    }
}