package com.cloud.zookeeper;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @auther: wjx
 * @Date: 2020/12/15 21:06
 * @Description:
 */
public class ZkUtil {

    private static ZooKeeper zk;
    private static String connectString="192.168.17.131:2181,192.168.17.138:2181";
    private static int sessionTimeout=3000;

    private static ConnectWatch watcher = new ConnectWatch();
    private static CountDownLatch latch = new CountDownLatch(1);

    public static ZooKeeper getZK(){
        try {
            zk = new ZooKeeper(connectString,sessionTimeout,watcher);
            watcher.setLatch(latch);
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zk;
    }
}
