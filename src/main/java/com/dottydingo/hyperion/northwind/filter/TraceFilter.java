package com.dottydingo.hyperion.northwind.filter;

import com.dottydingo.tracelog.DefaultTraceManager;
import com.dottydingo.tracelog.Trace;
import com.dottydingo.tracelog.TraceManager;
import com.dottydingo.tracelog.TraceType;
import com.dottydingo.tracelog.logback.LogbackTraceFactory;

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
        traceManager.startTrace(trace);

        //...

        // un-associate the trace from the current thread.
        trace = traceManager.endTrace();

        // close the trace and send the email
        trace.close();
    }
}
