package com.java.designpattern.lifecircle.create.builder;

/**
 * 文本构建器
 *
 * @author ljtwan
 * @date 2019/1/24
 **/
public class TextBuilder extends Builder {

    private StringBuffer stringBuffer = new StringBuffer();

    @Override
    public void makeTitle(String title) {
        stringBuffer.append("======================\n");
        stringBuffer.append("[\"" + title + "\"]\n");
        stringBuffer.append("\n");
    }

    @Override
    public void makeString(String string) {
        stringBuffer.append("Ψ " + string + "\n");
        stringBuffer.append("\n");
        stringBuffer.append("========Φ=======");
    }

    @Override
    public void makeItems(String[] items) {
        for (String item: items){
            stringBuffer.append(". " + item + "\n");
        }
        stringBuffer.append("\n");
    }

    @Override
    public void close() {
        stringBuffer.append("==================");
        System.out.println("相关 builder 资源已经释放");
    }

    public String getResult(){
        return stringBuffer.toString();
    }
}
