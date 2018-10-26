package com.zhongbao.zhongbao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;

import java.util.List;

import com.zhongbao.zhongbao.bean.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    private LayoutInflater mInflater;
    private List<Category> mCategoryList;
    private String mSelectCategoryID = "";
    private OnItemClickListener mOnItemClickListener;
    private Context context;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        mCategoryList = categories;
    }

    public void setSelectCategoryID(String categoryID) {
        this.mSelectCategoryID = categoryID;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.item_category, viewGroup, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, final int i) {
        Category category = mCategoryList.get(i);
        holder.mCategoryName.setText(category.getCategoryName());
        if (category.getCategoryID().equals(mSelectCategoryID)) {
            holder.huakuai.setVisibility(View.VISIBLE);
            holder.mCategoryName.setTextColor(context.getResources().getColor(R.color.bg_toolbar));
        } else {
            holder.huakuai.setVisibility(View.GONE);
            holder.mCategoryName.setTextColor(context.getResources().getColor(R.color.bkl));
        }
//    holder.mCategoryItemView.setSelected(category.getCategoryID().equals(mSelectCategoryID));
        if (null != mOnItemClickListener) {
            holder.mCategoryItemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(i, v);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    public class CategoryHolder extends RecyclerView.ViewHolder {

        RelativeLayout mCategoryItemView;
        TextView mCategoryName;
        View huakuai;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            mCategoryItemView = itemView.findViewById(R.id.ll_category_item);
            mCategoryName = itemView.findViewById(R.id.tv_category_name);
            huakuai = itemView.findViewById(R.id.huakuai);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, View view);
    }
}
