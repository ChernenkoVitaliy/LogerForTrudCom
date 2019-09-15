package com.trud;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class LoggerThread extends Thread {
    private List<Domain> result;
    private String domain;
    private static int count = 0;
    private int tmp;

    public LoggerThread(String domain, List<Domain> result) {
        this.domain = domain;
        this.result = result;
    }

    @Override
    public void run() {
        tmp = count++;
//        System.out.println("Thread " + tmp + " started...");
        Document doc = null;
        try {
            doc = Jsoup.connect(domain).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements spanElements = doc.getElementsByAttributeValue("class", "current-info");

        spanElements.forEach(h2Element -> {
            Element aElement = h2Element.child(0);
            String title = aElement.text();

            result.add(new Domain(domain, title));
//            System.out.println("Thread " + tmp + " done!!!");
        });
    }
}
