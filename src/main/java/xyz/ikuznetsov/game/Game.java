package xyz.ikuznetsov.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    boolean whatTypeIsNow = false; // false - крестики, true - нолики
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, InterruptedException {
        Game game = new Game();
        Cletka[] cletkas = new Cletka[9];

        game.beforeGame();
        game.initializeClearField(cletkas);
        game.outGameField(cletkas);

        while(true){
            game.getChoice(cletkas);
            game.outGameField(cletkas);
            if(game.isGameOverAsWin(cletkas)){
                if(game.whatTypeIsNow) {
                    System.out.println("Игра закончена. Крестики выиграли.");
                    break;
                }
                else{
                    System.out.println("Игра закончена. Нолики выиграли.");
                    break;
                }

            }
            if(game.isGameOverAsDraw(cletkas)){
                System.out.println("Игра закончена. Ничья.");
                break;
            }
        }


    }

    private void outGameField(Cletka[] cletka){
        System.out.println(cletka[0] + " " + cletka[1] + " " + cletka[2]);
        System.out.println(cletka[3] + " " + cletka[4] + " " + cletka[5]);
        System.out.println(cletka[6] + " " + cletka[7] + " " + cletka[8]);
    }

    private void initializeClearField(Cletka[] cletka){
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

    private boolean isGameOverAsWin(Cletka[] cletka){
        if(cletka[0].getType().equals(cletka[4].getType()) && cletka[4].getType().equals(cletka[8].getType()) && !(cletka[0].getType().equals("--")))
            return true;
        else if(cletka[2].getType().equals(cletka[4].getType()) && cletka[4].getType().equals(cletka[6].getType())&& !(cletka[2].getType().equals("--")))
            return true;
        else if(cletka[0].getType().equals(cletka[1].getType()) && cletka[1].getType().equals(cletka[2].getType())&& !(cletka[0].getType().equals("--")))
            return true;
        else if(cletka[3].getType().equals(cletka[4].getType()) && cletka[4].getType().equals(cletka[5].getType())&& !(cletka[3].getType().equals("--")))
            return true;
        else if(cletka[6].getType().equals(cletka[7].getType()) && cletka[7].getType().equals(cletka[8].getType())&& !(cletka[6].getType().equals("--")))
            return true;
        else if(cletka[0].getType().equals(cletka[3].getType()) && cletka[3].getType().equals(cletka[6].getType())&& !(cletka[0].getType().equals("--")))
            return true;
        else if(cletka[1].getType().equals(cletka[4].getType()) && cletka[4].getType().equals(cletka[7].getType())&& !(cletka[1].getType().equals("--")))
            return true;
        else if(cletka[2].getType().equals(cletka[5].getType()) && cletka[5].getType().equals(cletka[8].getType())&& !(cletka[2].getType().equals("--")))
            return true;
        else return false;
    }

    private boolean isGameOverAsDraw(Cletka[] cletka){
        for (int i = 0; i < cletka.length; i++) {
            if(cletka[i].getType().equals("--")){
                return false;
            }
        }
        return true;
    }
    private void beforeGame() throws InterruptedException {
        System.out.println("Добро пожаловать в игру крестики нолики!");
        Thread.sleep(500);
        System.out.println("Позиция клетки задается следующим образом: первое число - горизонталь клетки. Второе число - вертикаль клетки.");
        Thread.sleep(500);
        System.out.println("Позиция вводится одним двузначным числом, каждая цифра в котором может быть от 1 до 3 включительно.");
        Thread.sleep(500);
        System.out.println("Игра начинается...");
        Thread.sleep(500);
    }

}
