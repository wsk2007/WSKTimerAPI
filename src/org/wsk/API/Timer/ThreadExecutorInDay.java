package org.wsk.API.Timer;

import java.util.*;

/**
 * 按天执行
 * @param <D>
 * @param <T>
 */
public class ThreadExecutorInDay <D extends Data , T extends Task> extends Thread {
    /**
     * 必要参数
     */
    private D d;
    private T t;
    private ArrayList<Time> sc;
    private long pre;
    private long sleep;



    @Override
    public void run(){
        try {
            sleep(pre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object a = d.getStartData();
        t.doTask(a);
        Iterator<Time> it = sc.iterator();
        Calendar c;
        int h;
        int m;
        int s ;
        int mo;
        int da;
        Date date;
        Time time;
        while(true){
            c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
            while(it.hasNext()){
                date = c.getTime();
                h = date.getHours();
                mo = date.getMonth() + 1;
                da = date.getDay();
                m = date.getMinutes();
                s = date.getSeconds();
                time = it.next();
                if(s == time.s & m == time.m & h == time.h & mo == time.mo & da == time.d){

                    t.doTask(d.getData());
                    try {
                        sleep(sleep);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
            it = sc.iterator();
        }

    }

    /**
     * 构造方法
     * @param d
     * @param t
     * @param s
     * @param pre
     * @param sleep
     */
    public ThreadExecutorInDay(D d , T t , ArrayList<Time> s , long pre , long sleep){
        this.d = d;
        this.t = t;
        this.sc = s;
        this.pre = pre;
        this.sleep = sleep;
    }
}