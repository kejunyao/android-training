package com.kejunyao.training;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kejunyao.arch.recycler.AdapterData;
import com.kejunyao.arch.recycler.BaseClickRecyclerHolder;
import com.kejunyao.arch.recycler.ViewHolderUtils;

/**
 * $类描述$
 *
 * @author kejunyao
 * @since 2020年07月23日
 */
public class ActionViewHolder extends BaseClickRecyclerHolder<AdapterData<String>> {

    public static ActionViewHolder create(ViewGroup parent) {
        return new ActionViewHolder(ViewHolderUtils.inflate(parent, R.layout.action_item_view));
    }

    private final TextView textView;

    public ActionViewHolder(@NonNull final View itemView) {
        super(itemView);
        textView = (TextView) itemView;
    }

    @Override
    public void refresh(AdapterData<String> data) {
        super.refresh(data);
        textView.setText(data.data);

        Math.sqrt()
    }
}
