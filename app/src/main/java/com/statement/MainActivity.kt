package com.statement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.statement.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var contentView =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        contentView.intentTv.setOnClickListener {
            this.startActivity(
                Intent(
                    this,
                    MainActivity2::class.java
                )
            )
        }
    }
}