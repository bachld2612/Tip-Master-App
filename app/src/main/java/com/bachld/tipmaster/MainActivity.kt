package com.bachld.tipmaster

import android.os.Bundle
import android.widget.EditText
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var radioGroup: RadioGroup;
    lateinit var input_hoaDon: EditText;
    lateinit var input_tongTien: EditText;
    lateinit var input_tienBoa: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        radioGroup = findViewById(R.id.radioGroup);
        input_hoaDon = findViewById(R.id.input_hoaDon);
        input_tongTien = findViewById(R.id.input_tongTien);
        input_tienBoa = findViewById(R.id.input_tienBoa);
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.radio_10 -> {
                    val tien = input_hoaDon.text.toString().toDoubleOrNull() ?: 0.0
                    val tienBoa = tien * 0.1
                    val tongTien = tien + tienBoa
                    input_tienBoa.setText(tienBoa.toString())
                    input_tongTien.setText(tongTien.toString())
                }
                R.id.radio_15 -> {
                    val tien = input_hoaDon.text.toString().toDoubleOrNull()?:0.0
                    val tienBoa = tien * 0.15
                    val tongTien = tien + tienBoa
                    input_tienBoa.setText(tienBoa.toString())
                    input_tongTien.setText(tongTien.toString())
                }
                R.id.radio_20 -> {
                    val tien = input_hoaDon.text.toString().toDoubleOrNull() ?: 0.0
                    val tienBoa = tien * 0.2
                    val tongTien = tien + tienBoa
                    input_tienBoa.setText(tienBoa.toString())
                    input_tongTien.setText(tongTien.toString())
                }
            }
        }
    }
}