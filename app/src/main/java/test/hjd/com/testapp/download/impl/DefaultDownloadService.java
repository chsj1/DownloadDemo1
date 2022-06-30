package test.hjd.com.testapp.download.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import test.hjd.com.testapp.bean.DownloadInfo;
import test.hjd.com.testapp.download.DownloadListener;
import test.hjd.com.testapp.download.IDownloadExtService;

/**
 * Created by allen on 2022-06-30.
 */
public class DefaultDownloadService implements IDownloadExtService {

    BlockingQueue<DownloadTask> workQueue = new LinkedBlockingQueue<>(100);
    ExecutorService executorService = Executors.newFixedThreadPool(2);

    //保存下载中的任务
    Map<String, DownloadTask> downloadingTasks = new ConcurrentHashMap<>();
    //保存取消的任务
    Map<String, DownloadTask> cancelTasks = new ConcurrentHashMap<>();


    public DefaultDownloadService() {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        DownloadTask downloadTask = workQueue.take();
                        downloadTask.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        DownloadTask downloadTask = workQueue.take();
                        downloadTask.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void paused(String downloadId) {
    }

    @Override
    public void cancel(String downloadId) {
        DownloadTask downloadTask = downloadingTasks.get(downloadId);
        downloadTask.cancel();

        workQueue.remove(downloadTask);
    }

    @Override
    public void download(String downloadUrl, DownloadListener listener) {
        DownloadInfo downloadInfo = new DownloadInfo();
        downloadInfo.setDownloadUrl(downloadUrl);
        DownloadTask downloadTask = new DownloadTask(downloadInfo);
        try {
            downloadingTasks.put(downloadUrl, downloadTask);
            workQueue.put(downloadTask);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
