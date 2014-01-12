package com.wythe.View.Component;
public abstract class MComponent {

    public MComponent() {
        this.create();
    }

    /**
     * 创建组件对象
     * @return
     */
    public abstract Object create();
}
