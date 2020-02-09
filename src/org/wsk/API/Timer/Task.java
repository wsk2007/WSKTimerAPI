package org.wsk.API.Timer;

/**
 * @author wsk
 * 任务执行接口
 */
public interface Task{
    /**
     * 通用执行方法
     * 在每一个时间节点调用
     */
    public void doTask(Object arg);
}
