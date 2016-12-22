package xyz.ikuznetsov.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    boolean whatTypeIsNow = false; // false - крестики, true - нолики
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        Cletka[] cletkas = new Cletka[9];

        game.intializeClearField(cletkas);
        game.outGameField(cletkas);


    }

    private void outGameField(Cletka[] cletka){
        System.out.println(cletka[0] + " " + cletka[1] + " " + cletka[2]);
        System.out.println(cletka[3] + " " + cletka[4] + " " + cletka[5]);
        System.out.println(cletka[6] + " " + cletka[7] + " " + cletka[8]);
    }

    private void intializeClearField(Cletka[] cletka){
        for (int i = 0; i < cletka.length; i++) {
            cletka[i] = new Cletka(i + 1, "--");
        }
    }

    private void getChoice(Cletka[] cletka) throws IOException {
        if(!whatTypeIsNow){
            System.out.println("Крестики ходят. Введите позицию клетки:");
            String position = reader.readLine();
            cletka[getNumberAsXY(position) - 1].setType("X");
            whatTypeIsNow = true;
        }
        else{
            System.out.println("Нолики ходят. Введите позицию клетки:");
            String position = reader.readLine();
            cletka[getNumberAsXY(position) - 1].setType("O");
            whatTypeIsNow = false;
        }
    }

    private int getNumberAsXY(String xy){
        String[] str = xy.split("");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        return (3 * (x - 1) + 1) + (y - 1);
    }

}
