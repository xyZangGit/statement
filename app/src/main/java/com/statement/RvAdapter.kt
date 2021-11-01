package com.statement

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.statement.databinding.ListItemBinding

/**
 *Created by zxy on 10/9/21
 */
class RvAdapter(var context: Context?, private var dataList: ArrayList<DataBean>) :
    RecyclerView.Adapter<RvAdapter.RvHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvHolder {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false)
        return RvHolder(binding)


    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RvHolder, position: Int) {
        holder.bind(position, context)
    }

    inner class RvHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(index: Int, context: Context?) {
            var age1 = dataList[index].age1
            binding.tv1.text = "我是数据$age1"
            binding.tv2.text = "我是数据$age1"
            binding.tv3.text = "我是数据$age1"
            binding.tv4.text = "我是数据$age1"
            binding.tv6.text = "数据$age1"
            binding.tv7.text = "我是数据${age1}"
            binding.tv8.text = "我是数据"
            binding.tv9.text = "我是数据${age1}"
            binding.tv10.text = "我是数据"
            binding.img11.text = age1.toString()
            if (index / 2 == 1) {
                binding.bg.setImageDrawable(context?.getDrawable(R.mipmap.bg))
            } else
                binding.bg.setImageDrawable(context?.getDrawable(R.mipmap.bg2))

//            when (index) {
//                0 ->
//                    binding.img11.background = context?.getDrawable(R.color.colorPrimaryDark)
//                1 ->
//                    binding.img11.background = context?.getDrawable(R.color.colorAccent)
//                2 ->
//                    binding.img11.background = context?.getDrawable(R.color._xpopup_dark_color)
//                3 ->
//                    binding.img11.background = context?.getDrawable(R.color._xpopup_light_color)
//                4 ->
//                    binding.img11.background = context?.getDrawable(R.color._xpopup_title_color)
//                5 ->
//                    binding.img11.background =
//                        context?.getDrawable(R.color.cardview_dark_background)
//                6 ->
//                    binding.img11.background = context?.getDrawable(R.color.colorPrimaryDark)
//                7 ->
//                    binding.img11.background = context?.getDrawable(R.color._xpopup_content_color)
//
//            }
        }

    }
}