package org.wsk.API.Timer;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author wsk
 * 执行类
 */
public class Executor <T extends Task , D extends Data >{
    /**
     * 时间节点列表
     */
    private ArrayList<Time> schedule = new ArrayList<Time>();

    /**
     * 执行器
     */
    private ThreadExecutor ex;

    /**
     * 执行方法
     */
    private T task;

    /**
     * 数据获取方法
     */
    private D data;

    /**
     * 准备时间
     */
    private long pretime;

    /**
     * 任务间隔时间
     */
    private long sleeptime;

    /**
     * 添加单个时间节点
     * @param t
     */
    public void addschedule(Time t){
        schedule.add(t);
    }

    /**
     * 添加一组时间节点
     * @param c
     */
    public void addschedule(Collection<Time> c){
        schedule.addAll(c);
    }

    /**
     * 移除单个时间节点
     * @param t
     */
    public void remove(Time t){
        schedule.remove(t);
    }

    /**
     * 移除一组时间节点
     * @param c
     */
    public void remove(Collection<Time> c){
        schedule.removeAll(c);
    }

    /**
     * 启动
     */
    public void execute(){
        ex = new ThreadExecutor(data , task , schedule , pretime , sleeptime);
        ex.start();
    }

    /**
     * 停止
     */
    public void stop(){
        try{
            ex.interrupt();
            ex.stop();
            ex = null;
            System.gc();
        }catch(Exception e){

        }
    }

    /**
     * 构造方法
     * @param data
     * @param task
     * @param pretime
     * @param sleeptime
     */
    public Executor(D data , T task , long pretime , long sleeptime){
        this.data = data;
        this.task = task;
        this.pretime = pretime;
        this.sleeptime = sleeptime;
    }

    /**
     * 获取当前日程表
     * @return ArrayList<Time>
     */
    public ArrayList<Time> getshedule(){
        return this.schedule;
    }

    /**
     * 获取任务执行器
     * @return T
     */
    public T gettask(){
        return this.task;
    }

    /**
     * 获取数据获取器
     * @return D
     */
    public D getdata(){
        return this.data;
    }

    /**
     * 获取准备时间
     * @return long
     */
    public long getpretime(){
        return this.pretime;
    }

    /**
     * 获取间隔时间
     * @return long
     */
    public long getsleeptime(){
        return this.sleeptime;
    }
}
