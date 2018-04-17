package com.example.administrator.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.rxjava.adapter.FuliAdapter;
import com.example.administrator.rxjava.model.bean.GankDataBean;
import com.example.administrator.rxjava.presenter.MainPresenter;
import com.example.administrator.rxjava.view.IMainView;
import com.example.administrator.rxjava.wight.photoview.PhotoView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView {

    private RecyclerView mRecyclerView;
    private MainPresenter mPresenter;
    private RelativeLayout mPreBack;
    private PhotoView mPhotoView;
    RecyclerView.OnScrollListener loadingMoreListener;
    private int page = 1;
    private TextView mScrollOratation;
    private TextView mScrollTofirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenter(this);
        initView();
        init();
    }

    private void initView() {
        mScrollOratation = findViewById(R.id.btn);
        mScrollTofirst = findViewById(R.id.scrolltofirst);
        mRecyclerView = findViewById(R.id.recycler);
        mPreBack = findViewById(R.id.pre);
        mPhotoView = findViewById(R.id.preview);
        btn = findViewById(R.id.btn);
    }

    private void init() {
        mPhotoView.enable();
        initialListener();
        mRecyclerView.addOnScrollListener(loadingMoreListener);
        showFuliPic();
        mPresenter.loadData(page);
        mAdapter.addOnItemClickListener(new FuliAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                mPreBack.setVisibility(View.VISIBLE);
                mPhotoView.setVisibility(View.VISIBLE);
                mScrollOratation.setVisibility(View.GONE);
                mScrollTofirst.setVisibility(View.GONE);
                ImageView imageView = (ImageView) view;
                mPhotoView.setImageDrawable(imageView.getDrawable());
            }
        });
        mPhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPreBack.setVisibility(View.GONE);
                mPhotoView.setVisibility(View.GONE);
                mScrollOratation.setVisibility(View.VISIBLE);
                mScrollTofirst.setVisibility(View.VISIBLE);
            }
        });
        mPresenter.guessyoulike();
    }

    boolean loading = false;

    private void initialListener() {
        loadingMoreListener = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    int visibleItemCount = mLinearLayoutManager.getChildCount();
                    int totalItemCount = mLinearLayoutManager.getItemCount();
                    int pastVisiblesItems = mLinearLayoutManager.findFirstVisibleItemPosition();
                    Log.d("state----->", visibleItemCount + "-----//----" + totalItemCount + "-----//----" + pastVisiblesItems);
                    if (!loading && (visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                        loading = true;
                        loadMoreDate();
                    }
                }
                if (dx > 0) {
                    int visibleItemCount = mLinearLayoutManager.getChildCount();
                    int totalItemCount = mLinearLayoutManager.getItemCount();
                    int pastVisiblesItems = mLinearLayoutManager.findFirstVisibleItemPosition();
                    Log.d("state----->", visibleItemCount + "-----//----" + totalItemCount + "-----//----" + pastVisiblesItems);
                    if (!loading && (visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                        loading = true;
                        loadMoreDate();
                    }
                }


            }
        };
    }

    private void loadMoreDate() {
//        mAdapter.loadingStart();
        loading = false;
        page++;
        mPresenter.loadData(page);
        Log.d("page------------>", page + "");
//        mAdapter.LoadMore();
    }

    FuliAdapter mAdapter;
    LinearLayoutManager mLinearLayoutManager;

    public void showFuliPic() {
        //设置布局管理器
        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mAdapter = mPresenter.getAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (mPreBack.getVisibility() == View.VISIBLE || mPhotoView.getVisibility() == View.VISIBLE) {
                mPreBack.setVisibility(View.GONE);
                mPhotoView.setVisibility(View.GONE);
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private boolean mFlags;
    private TextView btn;

    public void click(View view) {
        if (!mFlags) {
            mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            btn.setText("↓");
            mFlags = true;
        } else {
            mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            btn.setText("→");
            mFlags = false;
        }
    }

    public void scrollToFirst(View view) {
        mRecyclerView.scrollToPosition(0);
    }
}
