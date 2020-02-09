package org.wsk.API.Timer;

/**
 * @author wsk
 * 数据获取接口
 */
public interface Data{
    /**
     * 数据获取方法
     * 每个时间节点通用
     *
     * @return Object
     */
    public Object getData();


    /**
     * 数据获取方法
     * 用于输出启动时的测试信息
     * @return Object
     */
    public Object getStartData();

}
