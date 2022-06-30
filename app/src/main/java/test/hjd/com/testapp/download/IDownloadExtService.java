package test.hjd.com.testapp.download;

/**
 * Created by allen on 2022-06-30.
 */
public interface IDownloadExtService extends IDownloadService {
    void paused(String downloadId);

    void cancel(String downloadId);
}
