package com.java.designpattern.lifecircle.create.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ljtwan
 * @date 2019/1/24
 **/
public class HTMLBuilder extends Builder {

    private String fileName;
    private PrintWriter printWriter;

    @Override
    public void makeTitle(String title) {
        fileName = title + ".html";

        try {
            printWriter = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        printWriter.println("<html><head><title>" + title + "</title></head><body>");
        printWriter.println("<h1>" + title + "</h1>");
    }

    @Override
    public void makeString(String string) {
        printWriter.println("<p>" + string + "</p>");
    }

    @Override
    public void makeItems(String[] items) {
        printWriter.println("<ul>");
        for (String item:
             items) {
            printWriter.println("<li>" + item + "</li>");
        }
        printWriter.println("</ul>");
    }

    @Override
    public void close() {
        printWriter.println("</body></html>");
        printWriter.close();
    }

    public String getResult(){
        return fileName;
    }
}
