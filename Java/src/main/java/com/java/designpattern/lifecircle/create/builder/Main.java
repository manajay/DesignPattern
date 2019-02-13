package com.java.designpattern.lifecircle.create.builder;

/**
 * Builder 模式 测试
 *
 * @author ljtwan
 * @date 2019/1/24
 **/
public class Main {

    public static void main(String[] args) {
        if (args.length !=1){
            usage();
            System.exit(0);
        }

        if (args[0].equals("plain")){
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            String result = textBuilder.getResult();
            System.out.println(result);
        } else if(args[0].equals("html")){
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.construct();
            String fileName = htmlBuilder.getResult();
            System.out.println(fileName + "文档编写完成");
        }
    }

    public static void usage() {
        System.out.println("Usage: java Main plain  编写纯文本文档");
        System.out.println("Usage: java Main html 编写 HTML 文档");
    }
}
