package com.kejunyao.training

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.kejunyao.arch.recycler.AdapterData

/**
 * $类描述$
 *
 * @author kejunyao
 * @since 2021年02月10日
 */
object ActionBuilder {

    const val ACTION_LEAK = 1

    @JvmStatic
    fun buildActionData(): List<AdapterData<String>> {
        val list = mutableListOf<AdapterData<String>>()
        list.add(AdapterData(ACTION_LEAK, "内存泄露"))
        return list
    }

    @JvmStatic
    fun handleAction(context: Context, id: Int, title: String?) {
        var clazz: Class<out Activity>? = null
        when (id) {
            ACTION_LEAK -> {
            }
            else -> {
                Toast.makeText(context, "无法识别的类型: $id", Toast.LENGTH_LONG).show()
            }
        }
        clazz ?: return
        val intent = Intent(context, clazz)
        if (context !is Activity) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }
}