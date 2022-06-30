package test.hjd.com.testapp;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import test.hjd.com.testapp.bean.DownloadInfo;
import test.hjd.com.testapp.network.DownloadRequst;
import test.hjd.com.testapp.ui.DownloadContentAdapter;

public class MainActivity extends BaseActivity {

    private RecyclerView rv;
    private DownloadContentAdapter downloadContentAdapter;

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        rv.setLayoutManager(linearLayoutManager);

        downloadContentAdapter = new DownloadContentAdapter();
        rv.setAdapter(downloadContentAdapter);
    }

    @Override
    public void initListeners() {
        downloadContentAdapter.getDownloadInfos().observe(this, new Observer<List<DownloadInfo>>() {
            @Override
            public void onChanged(@Nullable List<DownloadInfo> downloadInfos) {
                downloadContentAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void initDatas() {
        List<DownloadInfo> downloads = DownloadRequst.getDownloads();
        downloadContentAdapter.getDownloadInfos().postValue(downloads);
    }
}
