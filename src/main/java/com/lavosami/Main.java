package com.lavosami;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://anekdotovstreet.com/blondinki/?ysclid=likoo2benz6729960").get();
        Elements elements = document.select("div.anekdot-text > p");

        for (Element element : elements) {
            System.out.println(element);
        }
    }
}