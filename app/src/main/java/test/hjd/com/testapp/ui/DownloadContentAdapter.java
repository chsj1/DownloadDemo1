package test.hjd.com.testapp.ui;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import test.hjd.com.testapp.R;
import test.hjd.com.testapp.bean.DownloadInfo;

/**
 * Created by allen on 2022-06-30.
 */
public class DownloadContentAdapter extends RecyclerView.Adapter {


    private MutableLiveData<List<DownloadInfo>> downloadInfos;

    public DownloadContentAdapter() {
        this.downloadInfos = new MutableLiveData<>();
    }

    public MutableLiveData<List<DownloadInfo>> getDownloadInfos() {
        return downloadInfos;
    }

    private Context context;
    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon;
        public TextView appName;
        public TextView handleButton;
        public TextView downloadStatus;
        public ProgressBar downloadProgress;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            icon = itemView.findViewById(R.id.icon);
            appName = itemView.findViewById(R.id.appName);
            downloadStatus = itemView.findViewById(R.id.download_status);
            handleButton = itemView.findViewById(R.id.handleDownload);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.download_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        DownloadInfo downloadInfo = downloadInfos.getValue().get(i);
        ((ViewHolder)viewHolder).appName.setText(downloadInfo.getAppName());
        ((ViewHolder) viewHolder).handleButton.setText(downloadInfo.getStatus());
        Glide.with(context).load(downloadInfo.getAppIcon()).into(((ViewHolder) viewHolder).icon);
//        ((ViewHolder)viewHolder).appName.setText(downloadInfo.getAppName());
//        ((ViewHolder)viewHolder).appName.setText(downloadInfo.getAppName());
    }

    @Override
    public int getItemCount() {
        return downloadInfos == null ? 0 : downloadInfos.getValue().size();
    }
}
