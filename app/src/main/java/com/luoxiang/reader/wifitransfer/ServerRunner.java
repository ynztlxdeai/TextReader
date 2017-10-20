
package com.luoxiang.reader.wifitransfer;

import java.io.IOException;

/**
 * Wifi传书 服务端
 */
public class ServerRunner {

    private static SimpleFileServer server;
    public static boolean serverIsRunning = false;

    /**
     * 启动wifi传书服务
     */
    public static void startServer() {
        server = SimpleFileServer.getInstance();
        try {
            if (!serverIsRunning) {
                server.start();
                serverIsRunning = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stopServer() {
        if (server != null) {
            server.stop();
            serverIsRunning = false;
        }
    }
}