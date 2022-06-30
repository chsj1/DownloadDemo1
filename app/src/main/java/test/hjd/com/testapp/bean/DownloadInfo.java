package test.hjd.com.testapp.bean;

import java.io.Serializable;

/**
 * Created by allen on 2022-06-30.
 */
public class DownloadInfo implements Serializable {
    private String appName;
    private String appIcon;
    private String status;
    private int progress;
    private String downloadUrl;


    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(String appIcon) {
        this.appIcon = appIcon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    @Override
    public String
    toString() {
        return "DownloadInfo{" +
                "appName='" + appName + '\'' +
                ", appIcon='" + appIcon + '\'' +
                ", status='" + status + '\'' +
                ", progress=" + progress +
                ", downloadUrl='" + downloadUrl + '\'' +
                '}';
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}
