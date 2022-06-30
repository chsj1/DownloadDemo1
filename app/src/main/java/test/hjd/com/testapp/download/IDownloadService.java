package test.hjd.com.testapp.download;

/**
 * Created by allen on 2022-06-30.
 */
public interface IDownloadService {
    public void download(String downloadUrl, DownloadListener listener);
}
