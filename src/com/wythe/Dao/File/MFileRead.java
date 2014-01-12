package com.wythe.Dao.File;

/**
 * 文件操作类，读文件数据
 * 
 * @author Wythe.Wu
 * @since 2014.01.10
 *
 */
public class MFileRead extends MFile {

    /**
     * 单例模式
     */
    private MFileRead() {}

    private static MFileRead mRead = null;

    public synchronized static MFileRead getInstance() {
        if(null == mRead) {
            mRead = new MFileRead();
        }

        return mRead;
    }

    public String read() {


        return "";
    }
}
