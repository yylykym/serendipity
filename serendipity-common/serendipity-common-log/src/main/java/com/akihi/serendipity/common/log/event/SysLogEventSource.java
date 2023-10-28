package com.akihi.serendipity.common.log.event;

import com.akihi.serendipity.admin.api.domain.SysLog;

public class SysLogEventSource extends SysLog {

    /**
     *  参数重写成body
     */
    private Object body;

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
