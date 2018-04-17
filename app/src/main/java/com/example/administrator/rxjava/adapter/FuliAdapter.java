package com.example.administrator.rxjava.adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.administrator.rxjava.R;
import com.example.administrator.rxjava.model.bean.GankDataBean;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

import java.util.ArrayList;
import java.util.List;
import utils.ImageLoaderUtils;

/**
 * Created by Administrator on 2017/12/24.
 */

public class FuliAdapter extends RecyclerView.Adapter<FuliAdapter.ViewHolder> {
    private List<GankDataBean.ResultsBean> results = new ArrayList<>();
    ProgressBar progressBar;
    public FuliAdapter(Context context) {
        super();
        //图片加载进度条
        progressBar = new ProgressBar(context);
        FrameLayout.LayoutParams loadingLayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        loadingLayoutParams.gravity = Gravity.CENTER;
        progressBar.setLayoutParams(loadingLayoutParams);
    }

    public interface OnItemClickListener{
        void OnItemClick(View view,int position);
    }
    private  OnItemClickListener mOnItemClickListener;

    public  void addOnItemClickListener(OnItemClickListener mOnItemClickListener){
            this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fuli_layout, parent, false);
        ViewHolder mViewHolder = new ViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ImageLoaderUtils.displayImageUrl(results.get(position).getUrl(), holder.mImageView,
                new ImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String s, View view) {
                        progressBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onLoadingFailed(String s, View view, FailReason failReason) {
                        progressBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onLoadingCancelled(String s, View view) {
                        progressBar.setVisibility(View.GONE);
                    }
                },
                new ImageLoadingProgressListener() {
                    @Override
                    public void onProgressUpdate(String s, View view, int i, int i1) {
                        //todo 在这里更新 ProgressBar的进度信息
                    }
                });
        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("clicked---->",position+"");
                mOnItemClickListener.OnItemClick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void addItems(List<GankDataBean.ResultsBean> results) {
//        results.remove(0);
        this.results.addAll(results);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.img);
        }
    }
}
