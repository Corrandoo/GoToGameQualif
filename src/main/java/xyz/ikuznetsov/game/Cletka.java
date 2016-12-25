package xyz.ikuznetsov.game;
class Cletka {

    private String type;

    Cletka(String type) {
        this.type = type;
    }


    String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return type;
    }
}
