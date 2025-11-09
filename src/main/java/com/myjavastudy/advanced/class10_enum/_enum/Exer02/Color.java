package com.myjavastudy.advanced.class10_enum._enum.Exer02;

public enum Color {
    RED(255,0,0,"红色"), 
    ORANGE(255,128,0,"橙色"), 
    YELLOW(255,255,0,"黄色"), 
    GREEN(0,255,0,"绿色"), 
    CYAN(0,255,255,"青色"),
    BLUE(0,0,255,"蓝色"),
    PURPLE(128,0,255,"紫色");


    private final int red;
    private final int green;
    private final int blue;

    private final String description;

    private Color(int red, int green, int blue,String description) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.description = description;
    }

    @Override
    public String toString(){
        return super.name() + "(" + red + "," + green + "," + blue + ")" + "----->" + description;
    }

}
