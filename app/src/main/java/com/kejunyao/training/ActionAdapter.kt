package com.kejunyao.training

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kejunyao.arch.recycler.AdapterData
import com.kejunyao.arch.recycler.BaseClickRecyclerAdapter
import com.kejunyao.arch.recycler.NoSupportHolder

/**
 * $类描述$
 *
 * @author kejunyao
 * @since 2021年02月10日
 */
class ActionAdapter : BaseClickRecyclerAdapter<AdapterData<String>>() {

    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.type ?: -1
    }

    override fun createRecyclerViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == -1) {
            NoSupportHolder(parent)
        } else {
            ActionViewHolder.create(parent)
        }
    }
}