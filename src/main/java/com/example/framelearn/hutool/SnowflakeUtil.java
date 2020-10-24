package com.example.framelearn.hutool;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Date:2020/9/15
 */

@Slf4j
public class SnowflakeUtil {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private static long workerId = 0;//为终端ID

    private static long datacenterId = 1;//数据中心ID

    private static Snowflake snowflake = IdUtil.createSnowflake(workerId,datacenterId);

    public SnowflakeUtil(){
        init();
    }

    public void init(){
        workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        log.info("当前机器的workId:{}",workerId);
    }
    public static synchronized long snowflakeId(){
        return snowflake.nextId();
    }
    public synchronized long snowflakeId(long workerId,long datacenterId){
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }
}