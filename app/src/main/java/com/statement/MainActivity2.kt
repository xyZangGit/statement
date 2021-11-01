package com.statement

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.statement.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var contentView: ActivityMain2Binding
    private val tabText = arrayOf("选项一", "选项二")
    private var tabView = intArrayOf(R.mipmap.select, R.mipmap.select)
    private val noTabView = intArrayOf(R.mipmap.no_select, R.mipmap.no_select)


    val fragments = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contentView = DataBindingUtil.setContentView(this, R.layout.activity_main2)
        contentView.main2Back.setOnClickListener { finish() }

        fragments.add(Fragment1.newInstance())
        fragments.add(Fragment2.newInstance())
        contentView.easyBar.apply {
            selectIconItems(tabView)
            normalIconItems(noTabView)
            titleItems(tabText)
            fragmentList(fragments)
            normalTextColor(resources.getColor(R.color.aswww))   //Tab未选中时字体颜色
            selectTextColor(resources.getColor(R.color._xpopup_title_color))
            fragmentManager(supportFragmentManager)
            build()

        }


    }


}