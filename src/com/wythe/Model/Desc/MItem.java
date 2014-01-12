package com.wythe.Model.Desc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.wythe.Model.MModel;

/**
 * 物品
 * 
 * 关注的物品的模型类
 * @author Wythe.Wu
 * @since 2014.01.10
 */
public class MItem extends MModel {

    /**
     * 表的基本参数
     * @param id String 唯一的标识
     * @param name String 物品名称
     * @param quality String 物品品质
     * @param desc String 物品描述
     * @param imgPath String 物品图片链接
     * @param urlPath String 物品的详细地址
     * @param expected String 物品期望价格
     */
    private String id;
    private String name;
    private String quality;
    private String desc;
    private String imgPath;
    private String urlPath;
    private String expected;

    public MItem() {
        super();
        String[] requ = {"id", "name", "quality"};
        this.setRequired(requ);
        this.id = UUID.randomUUID().toString();
    }

    /**
     * 相当于查询某个ID为id的记录
     * @param id
     * @return MItem item
     */
    public MItem(String id) {

    }

    /**
     * 保存某一条物品记录
     * @return boolean
     */
    @Override
    public boolean save() {
        // TODO
        return true;
    }

    /**
     * 保存物品数组
     * @param id
     * @return boolean
     */
    public boolean save(MItem[] items) {
        // TODO
        return true;
    }

    /**
     * 根据ID删除某一条数据
     * @param id
     * @return boolean
     */
    @Override
    public boolean deleteById(String id) {
        // TODO
        return true;
    }

    /**
     * 删除所有物品数据
     * @return
     */
    @Override
    public boolean deleteAll() {
        // TODO
        return true;
    }

    /**
     * 根据ID查询某一条数据
     * @param id
     * @return Mitem
     */
    @Override
    public MItem searchById(String id) {
        // TODO
        return new MItem();
    }

    /**
     * 根据日期查询某段时间的数据
     * @return MItem[]
     */
    @Override
    public List<MItem> searchByDate() {
        // TODO
        return new ArrayList<MItem>();
    }

    @Override
    public boolean updateById() {
        // TODO
        return true;
    }

    @Override
    public boolean updateAll(Object[] objs) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Set和Get方法
     * @return String
     */
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getQuality() {
        return quality;
    }
    public void setQuality(String quality) {
        this.quality = quality;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getImgPath() {
        return imgPath;
    }
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    public String getUrlPath() {
        return urlPath;
    }
    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
    public String getExpected() {
        return expected;
    }
    public void setExpected(String expected) {
        this.expected = expected;
    }

    @Override
    public boolean save(Object[] objs) {
        return this.save(objs);
    }
}
