package xyz.ikuznetsov.game;

public class Cletka {

    private int xPos, yPos, num;
    private String type = "-";

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberAsXY(String xy){
        String[] str = xy.split("");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        return (3 * (x - 1) + 1) + (y - 1);
    }
}
