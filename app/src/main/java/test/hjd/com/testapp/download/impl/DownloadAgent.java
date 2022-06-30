package test.hjd.com.testapp.download.impl;

import test.hjd.com.testapp.bean.DownloadInfo;
import test.hjd.com.testapp.download.DownloadListener;
import test.hjd.com.testapp.download.IDownloadExtService;

/**
 * Created by allen on 2022-06-30.
 *
 * download agent
 */
public class DownloadAgent {

    private static DownloadAgent instance;

    private IDownloadExtService downloadService = new DefaultDownloadService();

    public static DownloadAgent getInstance() {
        if (null == instance) {
            synchronized (DownloadAgent.class) {
                if (null == instance) {
                    instance = new DownloadAgent();
                }
            }
        }

        return instance;
    }

    public void startDownload(DownloadInfo downloadInfo, DownloadListener downloadListener) {
        downloadService.download(downloadInfo.getDownloadUrl(), downloadListener);
    }

    public void cancel(String downloadId) {
        downloadService.cancel(downloadId);
    }

}
