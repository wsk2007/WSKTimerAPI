package org.wsk.API.Timer;

/**
 * @author wsk
 * 时间数据单元
 */
public class Time {
    /**
     * 小时数
     */
    public int h;
    /**
     * 分钟数
     */
    public int m;
    /**
     * 秒数
     */
    public int s;

    /**
     * 月份
     */
    public int mo;

    /**
     * 年份
     */
    public int y;

    /**
     * 天数
     */
    public int d;

    /**
     *
     * @param h
     * @param m
     * @param s
     * 构造方法
     */
    public Time(int h , int m , int s){
        this.h = h;
        this.m = m;
        this.s = s;
    }
}
