package com.lavosami;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Random;

public class Jokes {
    static Document document;

    static {
        try {
            document = Jsoup.connect("https://anekdotovstreet.com/blondinki/?ysclid=likoo2benz6729960").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Elements elements = document.select("div.anekdot-text > p");

    static public String randomJoke() {
        Random random = new Random();

        String str = String.valueOf(elements.get(random.nextInt(elements.size())));
        while (str.contains("шлюха")) {
            str = String.valueOf(elements.get(random.nextInt(elements.size())));
        }

        str = str.replace("<p>", "");
        str = str.replace("<br>", "\n");
        str = str.replace("</p>", "");

        return str;
    }

    public static void main(String[] args) {
        System.out.println(randomJoke());
    }
}