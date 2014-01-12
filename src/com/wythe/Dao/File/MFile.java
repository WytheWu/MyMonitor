package com.wythe.Dao.File;

import java.io.File;
import java.io.FilenameFilter;

import com.wythe.Config.Config;

/**
 * 数据文件夹 文件操作类
 * @author wythe.wu
 * @since 2014.1.10
 */
public abstract class MFile {

    /**
     * 前提：数据文件夹下
     * 获取文件名为fileName一类文件的最新的文件
     * @param fileName String 文件名字/需要获取的物品数据的对应文件名
     * @return fileName String 最新文件的路径 / boolean 不存在这个文件
     */
    public Object getLatestFile(String fileName) {
        /*
         * 获取特定文件夹下的
         */
        File file = new File(Config.getInstance().getDataPath());
        File[] files = file.listFiles(new MyFileFilter(fileName));

        return (files.length > 0) ? files[files.length-1].getPath() : false;
    }

    /**
     * 内部类 用来创建过滤器 过滤条件为是否以特定的前缀的文件
     * @author wythe.wu
     */
    static class MyFileFilter implements FilenameFilter {
        private String suffix = "";

        public MyFileFilter(String suffix){
            this.suffix = suffix;
        }

        @Override
        public boolean accept(File dir, String name) {
            //如果文件名与指定的前面相同便返回true
            if(new File(dir,name).isFile()){
                return name.startsWith(suffix);
            } else {
                //如果是文件夹
                return true;
            }
        }
    }
}
