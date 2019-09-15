package com.trud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Logger {
    private List<String> allDomains;
    private List<Domain> result = Collections.synchronizedList(new ArrayList<>());

    public Logger(DomainContainer domenContainer) {
        domenContainer.readFromFile();
        allDomains = domenContainer.getDomains();
    }


    public List<Domain> parse() {

        List<LoggerThread> tmp = new ArrayList<>();
        LoggerThread lt;
        for (String domain: allDomains) {
            lt = new LoggerThread(domain, result);
            tmp.add(lt);
            lt.start();
        }

        //it's need for waiting other thread from this
        for (LoggerThread loggerThread : tmp) {
            try {
                loggerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
