package com.example.text_translate

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.Translator
import com.google.mlkit.nl.translate.TranslatorOptions


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.editText)
        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)


        //check app level permission is granted for Camera
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            //grant the permission
            requestPermissions(arrayOf(Manifest.permission.CAMERA), 101)
        }

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

        englishJapaneseTranslator.translate("how are you")
                .addOnSuccessListener { translatedText ->
                    // Translation successful.
                    textView.setText(translatedText)
                }
                .addOnFailureListener { exception ->
                    // Error.
                    // ...
                    textView.setText("translation failed")
                }


        button.setOnClickListener {
            englishJapaneseTranslator.translate(editText.text.toString())
                    .addOnSuccessListener { translatedText ->
                        // Translation successful.
                        textView.setText(translatedText)
                    }
                    .addOnFailureListener { exception ->
                        // Error.
                        // ...
                        textView.setText("translation failed")
                    }
        }






    }
}