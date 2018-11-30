package com.java.designpattern.lifecircle.memoryleak;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author duanlianjie
 * @date 14/12/2017
 */
public class Stack {
    private Object[] elements;

    private int size = 0;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack(Object[] elements) {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object element){
        ensureCapacity();
        elements[size++] = element;
    }

    /**
     * 出栈
     * 存在内存泄露的地方, 栈先增长,后收缩, 从栈中弹出的对象将不会当做垃圾回收,解决办法 elements[size] = null;
     *
     * @date 27/01/2018
     * @author duanlianjie
     */
    public Object pop(){
        if (elements.length == 0){
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    /**
     * 确保 数组的长度适合
     *
     * @date 27/01/2018
     * @author duanlianjie
     */
    public void ensureCapacity(){
        if (elements.length == size){

            /*
             * truncating or padding with nulls (if necessary)
             * For all indices that are
             * valid in both the original array and the copy, the two arrays will
             * contain identical values.
             */
            elements = Arrays.copyOf(elements, size * 2 + 1);
        }
    }
}
