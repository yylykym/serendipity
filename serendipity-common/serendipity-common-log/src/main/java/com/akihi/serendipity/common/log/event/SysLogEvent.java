package com.akihi.serendipity.common.log.event;

import org.springframework.context.ApplicationEvent;

public class SysLogEvent extends ApplicationEvent {
    public SysLogEvent(SysLogEventSource source) {
        super(source);
    }
}
