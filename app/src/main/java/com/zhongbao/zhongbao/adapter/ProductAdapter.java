package com.zhongbao.zhongbao.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;

import java.util.List;

import com.zhongbao.zhongbao.bean.Product;
import com.zhongbao.zhongbao.dialog.BuyGoodsDialog;
import com.zhongbao.zhongbao.goods.BuyGoodsActivity;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    private LayoutInflater mInflater;

    private List<Product> mProductList;

    private OnItemClickListener mOnItemClickListener;

    private Context context;
    private BuyGoodsDialog buyGoodsDialog;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        this.mProductList = products;
        buyGoodsDialog = new BuyGoodsDialog(context);
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ProductHolder(mInflater.inflate(R.layout.item_product, viewGroup, false));
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int i) {
        Product product = mProductList.get(i);
        holder.mProductName.setText(product.getProductName());
        holder.mTotalProductNumber.setText("总需人次：" + product.getTotalNumber());
        holder.mProductSurplusNumber.setText("剩余人次：" + product.getSurplusNumber());
        int total = Integer.parseInt(product.getTotalNumber());
        int surPlus = Integer.parseInt(product.getSurplusNumber());
        holder.mProgress.setProgress(total - surPlus);
        holder.mProgress.setMax(total);
        holder.mProductProgress.setText("开奖进度:" + ((total - surPlus) * 100 / total) + "%");
        holder.goods_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyGoodsDialog.show();
//                context.startActivity(new Intent(context, BuyGoodsActivity.class));
            }
        });

        if (null != mOnItemClickListener) {
            holder.mAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(v);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class ProductHolder extends RecyclerView.ViewHolder {

        ConstraintLayout mAll;
        TextView mProductSurplusNumber;
        TextView mTotalProductNumber;
        TextView mProductName;
        TextView mProductProgress;
        ProgressBar mProgress;
        ImageView goods_add;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            mProductSurplusNumber = itemView.findViewById(R.id.tv_surplus_number);
            mTotalProductNumber = itemView.findViewById(R.id.tv_product_total_number);
            mProductName = itemView.findViewById(R.id.tv_product_name);
            mProgress = itemView.findViewById(R.id.pb_product_progress);
            mProductProgress = itemView.findViewById(R.id.tv_product_progress);
            mAll = itemView.findViewById(R.id.all_view);
            goods_add = itemView.findViewById(R.id.goods_add);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view);
    }
}
