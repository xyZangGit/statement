package com.statement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.databinding.adapters.AbsListViewBindingAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BasePopupView
import com.lxj.xpopup.enums.PopupPosition
import com.lxj.xpopup.interfaces.SimpleCallback
import com.statement.databinding.Fragment1Binding


/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment(), View.OnClickListener {

    private lateinit var inflate: Fragment1Binding

    private val array = arrayListOf<DataBean>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        inflate = Fragment1Binding.inflate(inflater, container, false)

        initView()

        return inflate.root
    }

    private fun initView() {
        inflate.tvTime.setOnClickListener(this)
        inflate.tvTable.setOnClickListener(this)
        inflate.tvFilter.setOnClickListener(this)

        for (index in 1..9) {
            array.add(DataBean(index, "2021.0${index}"))
        }

        var linearLayoutManager = LinearLayoutManager(context)
        inflate.tableRv.layoutManager = linearLayoutManager
        inflate.tableRv.adapter = RvAdapter(context, array)
        inflate.tableRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                inflate.tvTime.text =
                    array[linearLayoutManager.findFirstVisibleItemPosition()].time
            }

        })

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            Fragment1()
    }

    override
    fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.tv_time,
            R.id.tv_table -> {
                val asCustom: CustomPartShadowPopupView = XPopup.Builder(context)
                    .atView(p0)
                    .setPopupCallback(object : SimpleCallback() {
                        override fun onShow(popupView: BasePopupView?) {
//                            Toast.makeText(context, "显示了", LENGTH_LONG).show()
                        }
                    })
                    .asCustom(context?.let { CustomPartShadowPopupView(it) })
                        as CustomPartShadowPopupView

                asCustom.show()
            }
            R.id.tv_filter -> {
                XPopup.Builder(context)
                    .popupPosition(PopupPosition.Right)
                    .atView(p0)
                    .hasStatusBarShadow(true)
                    .asCustom(context?.let { CustomDrawerPopupView(it) })
                    .show()

            }
        }
    }
}