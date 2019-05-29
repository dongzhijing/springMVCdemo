package org.newit.microservice.springMVCdemo;

/**
 * Created by Administrator on 2019-05-29.
 */
public class MyTime {
    private long currentTime;
    public void setCurrentTime(long currentTime){
        this.currentTime = currentTime;
    }
    public long getCurrentTime(){
        return currentTime;
    }
}
