package test.hjd.com.testapp.network;

import java.util.ArrayList;
import java.util.List;

import test.hjd.com.testapp.bean.DownloadInfo;
import test.hjd.com.testapp.constants.DownloadStatusConstants;

/**
 * Created by allen on 2022-06-30.
 */
public class DownloadRequst {
    //TODO
    // 此处以 本地同步 的方式模拟 异步的网络请求
    public static List<DownloadInfo> getDownloads() {
        ArrayList<DownloadInfo> downloads = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            DownloadInfo downloadInfo = new DownloadInfo();
            downloadInfo.setAppName("download " + i);
            downloadInfo.setAppIcon("");
            downloadInfo.setProgress(0);
            downloadInfo.setStatus(DownloadStatusConstants.DOWNLOAD_BEFORE);

            downloads.add(downloadInfo);
        }

        return downloads;
    }
}
