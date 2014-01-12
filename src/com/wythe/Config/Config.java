package com.wythe.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置类
 * 
 * 初始化所有配置， 配置文件路径为/config
 * @author Wythe.Wu
 * @since 2014.1.10
 *
 */
public class Config {

    // 配置文件路径
    private final String configPath = System.getProperty("user.dir") + "/config/market.properties";

    /**
     * 项目基本配置信息
     * @param dataPath string 数据文档的路径
     */
    private String dataPath;

    /**
     * 单例模式
     */
    private Config() {
        //首次加载配置文档
        try {
            this.loadConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Config config = null;

    /**
     * 实例化一个Config对象， 有且仅有一个
     * @return Config
     */
    public synchronized static Config getInstance() {
        if(null == config) {
            config = new Config();
        }
        return config;
    }

    /**
     * 读取配置文件，并且设置相应的配置
     * @throws IOException
     */
    private void loadConfiguration() throws IOException {
        // 读配置文件
        Properties prope = new Properties();
        InputStream in = null;

        in = new FileInputStream(this.configPath);

        String dataStorePath = null;

        // 给每个参数初始化值
        prope.load(in);
        // 设置数据文档路径
        dataStorePath = prope.getProperty("DataStorePath").trim();
        this.setDataPath(dataStorePath);
    }

    /**
     * 重新加载配置文件
     * @throws IOException
     */
    public void reLoadConfiguration() throws IOException {
        this.loadConfiguration();
    }

    /**
     * =====================================
     * 以下是set和get方法
     * @return String
     * =====================================
     */
    public String getDataPath() {
        return dataPath;
    }

    public void setDataPath(String dataStorePath) {
        if("default".endsWith(dataStorePath)) {
            this.dataPath = System.getProperty("user.dir") + "\\data";
        } else {
            this.dataPath = dataStorePath;
        }
    }
}
