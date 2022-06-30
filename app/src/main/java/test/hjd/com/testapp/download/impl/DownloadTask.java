package test.hjd.com.testapp.download.impl;

import test.hjd.com.testapp.LiveDataBus;
import test.hjd.com.testapp.bean.DownloadInfo;
import test.hjd.com.testapp.constants.DownloadStatusConstants;

/**
 * Created by allen on 2022-06-30.
 *
 * 1)执行具体的下载任务
 * 2)状态变化更新(下载状态,进度)
 *
 */
public class DownloadTask implements Runnable {

    private DownloadInfo downloadInfo;

    public DownloadTask(DownloadInfo downloadInfo) {
        this.downloadInfo = downloadInfo;
    }

    @Override
    public void run() {
        //todo 下载任务
        downloadInfo.setStatus(DownloadStatusConstants.DOWNLOAD_ING);
    }

    public void cancel() {
        throw new RuntimeException("取消下载");
    }
}
