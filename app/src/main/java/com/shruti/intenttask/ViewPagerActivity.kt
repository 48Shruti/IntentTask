package com.shruti.intenttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.shruti.intenttask.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {
    lateinit var binding : ActivityViewPagerBinding
    var items = ArrayList<Fragment>()
    lateinit var adapter: FragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        items.add(FirstFragment())
        items.add(SecondFragment())
        adapter = FragmentAdapter(this,items)
        binding.viewPager.adapter = adapter
    }
}