package com.example.genericrecycleradapter

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.genericrecycleradapter.databinding.ActivityMainBinding
import com.example.genericrecycleradapter.databinding.DesignRecBinding
import com.example.genericrecycleradapter.model.User

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG = "yah"
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = listOf<User>(
            User("yahya", "0593241570"),
            User("yahye", "0593241570"),
            User("yahys", "0593241570"),
            User("yahyw", "0593241570"),
            User("yahyq", "0593241570"),
            User("yahyr", "0593241570"),
            User("yahyt", "0593241570"),
            User("yahyy", "0593241570"),
            User("yahyu", "0593241570"),
            User("yahyo", "0593241570"),
            User("yahyi", "0593241570"),
            User("yahya", "0593241570"),
            User("yahyx", "0593241570"),
            User("yahyc", "0593241570"),
            User("yahya", "0593241570")
        )
        val rec = RecAdapter<User, DesignRecBinding>(
            layoutId = R.layout.activity_main,
            bindView = { binding, item ->
                binding.name.text = item.name
                binding.phone.text = item.phone
            },
            bindingInflater = DesignRecBinding::inflate
        )
        rec.updateItems(list)

        binding.rec.adapter = rec
        binding.rec.layoutManager = LinearLayoutManager(this)
    }
}