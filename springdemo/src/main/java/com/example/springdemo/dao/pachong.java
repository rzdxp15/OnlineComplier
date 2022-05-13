package com.example.springdemo.dao;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
public class pachong {

    @RequestMapping("/get")
    public Object get()  {
        List<newss>n=new ArrayList<>();
        try {
            String url="http://news.baidu.com/";
            news nss=new news();
            Document document = Jsoup.parse(new URL(url).openStream(), "UTF-8", url);
            //根据class获取到 页面的 元素内容
            Elements tables = document.getElementsByClass("mod-tab-pane active");
            Elements td = tables.select("li");

            for(int j=0;j<td.size();j++) {
                Elements els = td.get(j).select("a");
                for (int i = 0; i < els.size(); i++) {

                    String title = els.get(i).text();
                   // System.out.println(title);
                    String u = els.get(i).select("a").attr("href");
                   // System.out.println(u);
                    String result = nss.post(title);
                    //System.out.println(result);
                    newss ns = new newss(title, u, result);
                    n.add(ns);
                }
            }
            return n;
        }catch (Exception e){
            e.printStackTrace();
        }
        return n;
    }




}
