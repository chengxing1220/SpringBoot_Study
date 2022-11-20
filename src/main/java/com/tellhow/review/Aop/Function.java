package com.tellhow.review.Aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wujianghao
 * @date 2022年11月18日 17:19
 * 业务逻辑类
 */
@Slf4j
@Component
public class Function {
    /**
     *
     * @param name 执行人
     * @param taskName 任务名
     * @return
     */
    public String GhostInfestation(String name, String taskName) {
     //   int q=1/0;
        log.info(name + "执行" + taskName);
        return name + "获取功勋";
    }
}
