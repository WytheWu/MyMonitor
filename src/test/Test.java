package test;

import com.wythe.Model.Desc.MItem;

public class Test {

    public static void main(String[] args) {
        // 项目开始前加载
        // Config.getInstance();
        // MFileRead mRead = MFileRead.getInstance();
        // Object a = mRead.getLatestFile("da");
        // System.out.println(System.currentTimeMillis());

        // System.out.println(mRead.getLatestFileName("a"));

        // Properties prope = new Properties();
        // InputStream in = null;
        // try {
        // in = new
        // FileInputStream("E:/workspace-java-eclipse/ReadFile/config/market.properties");
        // } catch (FileNotFoundException e1) {
        // // TODO Auto-generated catch block
        // e1.printStackTrace();
        // }
        //
        // String dataStorePath = null;
        //
        // /*
        // * 给每个参数初始化值
        // */
        // try {
        // System.out.println(in);
        // prope.load(in);
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        MItem item = new MItem();
        try {
            item.setName("aa");
            item.setQuality("aa");
            System.out.println(item.check());
            System.out.println(item.getName());
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
