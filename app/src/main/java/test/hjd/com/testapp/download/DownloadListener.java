package test.hjd.com.testapp.download;

/**
 * Created by allen on 2022-06-30.
 */
public interface DownloadListener {
    void onProgressUpdate(int progress);
    void onSuccess(String file);
    void onFailure(String reason);
}
