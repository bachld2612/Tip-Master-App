package com.bachld.tipmaster

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

//Code chạy tốt!
class MainActivity : AppCompatActivity() {

    lateinit var radioGroup: RadioGroup;
    lateinit var input_hoaDon: EditText;
    lateinit var input_tongTien: EditText;
    lateinit var input_tienBoa: EditText;
    lateinit var btn_chiaSe: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        radioGroup = findViewById(R.id.radioGroup);
        input_hoaDon = findViewById(R.id.input_hoaDon);
        input_tongTien = findViewById(R.id.input_tongTien);
        input_tienBoa = findViewById(R.id.input_tienBoa);
        btn_chiaSe = findViewById(R.id.btn_chiaSe);
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
        btn_chiaSe.setOnClickListener {
            val hoaDon = input_hoaDon.text.toString().trim()
            val tienBoa = input_tienBoa.text.toString().trim()
            val tongTien = input_tongTien.text.toString().trim()

            val shareText = "Hóa đơn: $hoaDon\nTiền boa: $tienBoa\nTổng cộng: $tongTien"

            val shareIntent = android.content.Intent().apply {
                action = android.content.Intent.ACTION_SEND
                type = "text/plain"
                putExtra(android.content.Intent.EXTRA_TEXT, shareText)
            }
            startActivity(android.content.Intent.createChooser(shareIntent, "Chia sẻ kết quả qua..."))
        }
    }
}