package com.example.calvin.multinotes;

public class Note {

    private String title;
    private String content;
    private String time;

    Note(int i){
        time = "time " + i;
        title = "title " + i;
        content = "content " + i;
        i++;
    }

    Note(String title, String content, String time){
        this.time = time;
        this.title = title;
        this.content = content;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public String getTime(){
        return time;
    }

}
