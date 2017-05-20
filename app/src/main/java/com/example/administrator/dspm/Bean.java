package com.example.administrator.dspm;

/**
 * Created by Administrator on 2017/4/19.
 */

public class Bean {

    private String title;
    private String content;

     public  Bean(String title, String content){
         this.title = title;
         this.content = content;
     }
     public String getTitle() {
         return title;
     }
     public String getContent() {
         return content;
     }
}
