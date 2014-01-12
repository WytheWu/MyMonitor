package com.wythe.Model;

import java.lang.reflect.Method;
import java.util.List;


/**
 * 根模型类
 * 
 * 模型层的根类， 所有模型层继承该类
 * @param recordDate String timestamp
 * @param updateDate String timestamp
 * @param deleted String 0 undeleted 1 deleted
 * @author Wythe.Wu
 */
public abstract class MModel {

    private String[] required;

    private String recordDate = System.currentTimeMillis() + "";
    private String updateDate = System.currentTimeMillis() + "";
    private String deleted = "0";

    /**保存某一条记录 */
    public abstract boolean save();
    /**保存一堆记录*/
    public abstract boolean save(Object[] objs);
    /**删除某一条记录 */
    public abstract boolean deleteById(String id);
    /**删除所有记录*/
    public abstract boolean deleteAll();
    /**根据ID查询某一条记录*/
    public abstract Object searchById(String id);
    /**查询所有记录*/
    @SuppressWarnings("unchecked")
    public abstract List searchByDate();
    /**更新某一条记录*/
    public abstract boolean updateById();
    /**更新一些列的记录*/
    public abstract boolean updateAll(Object[] objs);

    /**
     * 通过required判断那些必须不为空的值是否不为空
     * @return boolean
     * @throws NoSuchFieldException
     * @throws SecurityException
     */
    @SuppressWarnings("unchecked")
    public boolean check() {
        int total = this.required.length;
        // 如果必须的字段为空
        if(null == this.required || 0 == total) {
            return true;
        }

        //逐个判断字段
        try
        {
            String column = null;
            for (int i = 0; i < total; i++) {
                column = this.required[i];
                column = "get" + column.substring(0, 1).toUpperCase()+column.replaceFirst("\\w","");
                Class ownerClass = this.getClass();
                // TODO
                Method method = ownerClass.getMethod(column, ownerClass);
                String[] args = {""};
                method.invoke(this, args);

                System.out.println(column);
                System.out.println(ownerClass);
                /*
                Field field = ownerClass.getField(column);

                Object property = field.get(ownerClass);
                if(property == null || "" == property)
                    return false;*/
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "recordDate" + recordDate + "updateDate" + updateDate + "deleted" + deleted;
    }

    /**
     * Get和 Set方法
     * @return
     */
    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String[] getRequired() {
        return required;
    }

    public void setRequired(String[] required) {
        this.required = required;
    }
}
