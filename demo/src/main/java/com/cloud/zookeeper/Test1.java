package com.cloud.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.client.ZooKeeperSaslClient;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @auther: wjx
 * @Date: 2020/12/14 21:54
 * @Description:
 */
public class Test1 {

    public static void main(String[] args) throws Exception{
        CountDownLatch latch = new CountDownLatch(1);
        ZooKeeper zk = new ZooKeeper("192.168.17.131:2181,192.168.17.138:2181", 30000,
                watchedEvent -> {
                    System.out.println(watchedEvent.getPath());
                    Watcher.Event.KeeperState state = watchedEvent.getState();
                    Watcher.Event.EventType type = watchedEvent.getType();
                    System.out.println("state:"+state);
                    System.out.println("type:"+type);
                    switch (state) {
                        case Unknown:
                            break;
                        case Disconnected:
                            break;
                        case NoSyncConnected:
                            break;
                        case SyncConnected:
                            System.out.println("connected..");
                            latch.countDown();
                            break;
                        case AuthFailed:
                            break;
                        case ConnectedReadOnly:
                            break;
                        case SaslAuthenticated:
                            break;
                        case Expired:
                            break;
                    }

                    switch (type) {
                        case None:
                            break;
                        case NodeCreated:
                            break;
                        case NodeDeleted:
                            break;
                        case NodeDataChanged:
                            break;
                        case NodeChildrenChanged:
                            break;
                    }
                });
        latch.await();
        //
        String path = zk.create("/idea", "aaa".getBytes(),  ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("path :"+path);

        System.out.println("***************");
        Stat stat = new Stat();
        byte[] data = zk.getData(path, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("get data watch..." + event);
                try {
                    System.out.println("get data stat:"+stat.getVersion());
                    //每次回去只会回调一次，添加这个相当于在新的stat下再获取一次
                    byte[] data1 = zk.getData(path, this, stat);
                    System.out.println("data1:"+new String(data1));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, stat);
//        byte[] data = zk.getData(path, (watchEvent) -> {
//            System.out.println("get data watch..." + watchEvent);
////            zk.getData(path, this, stat);
//        }, stat);

        System.out.println("data :"+new String(data));

        //set会触发get回调
        Stat stat1 = zk.setData(path, "old-aaa".getBytes(), 0);
        //同一个stat只会获取一次
        Stat stat2 = zk.setData(path, "old-aaa222222".getBytes(), stat1.getVersion());

        System.out.println("***********************************");


        zk.getData("/idea", true, new AsyncCallback.DataCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
                System.out.println(rc);
                System.out.println(path);
                System.out.println(ctx);
                System.out.println(new String(data));
                System.out.println(stat);

            }
        }, "abc");

        Thread.sleep(200000);

    }

}
