package com.dottydingo.hyperion.northwind.filter;

import com.dottydingo.service.tracelog.DefaultTraceManager;
import com.dottydingo.service.tracelog.Trace;
import com.dottydingo.service.tracelog.TraceManager;
import com.dottydingo.service.tracelog.TraceType;
import com.dottydingo.service.tracelog.logback.LogbackTraceFactory;

/**
 */
public class TraceFilter
{
    public static void main(String[] args) throws Exception
    {
        LogbackTraceFactory traceFactory = new LogbackTraceFactory();
        TraceManager traceManager = new DefaultTraceManager();

        Trace trace = traceFactory.createTrace(TraceType.email,"trace_destination@somedomain.com");

        // associate the trace with the current tread
        traceManager.associateTrace(trace);

        //...

        // un-associate the trace from the current thread.
        trace = traceManager.disassociateTrace();

        // close the trace and send the email
        trace.close();
    }
}
