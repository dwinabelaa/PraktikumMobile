package com.belaa.konversimatauang

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.belaa.konversimatauang.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tombolKonversi.setOnClickListener { hitungKonversi() }

        binding.inputEditText.setOnKeyListener { view, keyCode, _ ->
            handleKeyEvent(
                view,
                keyCode
            )
        }
    }

    private fun hitungKonversi() {
        val stringInTextField = binding.inputEditText.text.toString()
        val inputUang = stringInTextField.toDoubleOrNull()

        if (inputUang == null || inputUang == 0.0) {
            binding.teksHasil.text = ""
            return
        }

        val pilihanUser = when (binding.pilihanMataUang.checkedRadioButtonId) {
            R.id.euro -> 16000
            R.id.USDollar -> 14000
            R.id.japaneseYen -> 114
            else -> 4000
        }

        var hasil = inputUang * pilihanUser
        val indonesianLocale = Locale("in","ID")
        val hasilFormat =
            NumberFormat.getCurrencyInstance(indonesianLocale).format(hasil)
        binding.teksHasil.text = getString(R.string.nilai_rupiah, hasilFormat)
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}