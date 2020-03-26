package Homework_3;

import java.util.Random;
import java.util.Scanner;

public class Homework_3 {

    public static void main(String[] args) {
        guessTask1();
        guessTask2();
    }

    private static Scanner scanner = new Scanner(System.in);

    // Написать программу, которая загадывает случайное число от 0 до 9,
    // и пользователю дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
    // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    static void guessTask1() {
        boolean isExit = false;
        guessGame();
        do {
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
//            while (!scanner.hasNext("[1,0]")) {
//                System.out.println("Не символ. Введите 1/0:");
//                scanner.next();
//            }
            int answer = scanner.next().charAt(0);
            if ('0' == answer) {
                isExit = true;
            } else if ('1' == answer) {
                guessGame();
            }
        } while (!isExit);
    }

    private static void guessGame() {
        Random random = new Random();
        int generate = random.nextInt(10);
        boolean isWin = false;
        int playerNum;
        int maxTryCount = 3;
        System.out.println("Угадайте число от 0 до 9, у Вас есть 3 попытки, введите число: ");
        for (int tryCount = 1; tryCount <= maxTryCount; tryCount++) {
            playerNum = scanner.nextInt();
            if (playerNum == generate) {
                isWin = true;
                break;
            } else if (playerNum > generate) {
                System.out.println("Загаданное число меньше " + playerNum + ". Осталось " + (maxTryCount - tryCount) + " попытка(и)(ок).");
            } else {
                System.out.println("Загаданное число больше " + playerNum + ". Осталось " + (maxTryCount - tryCount) + " попытка(и)(ок).");
            }
        }
        if (isWin) System.out.println("Вы угадали!");
        else System.out.printf("Вы не угадали. Ответ: %d\n", generate);
    }

    //     Создать массив из слов:
//     String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
//     При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
//     Если слово не угадано, компьютер показывает буквы которые стоят на своих местах. Apple – загаданное, apricot - ответ игрока
//     ap############# (15 символов, чтобы пользователь не мог узнать длину слова). Для сравнения двух слов посимвольно, можно пользоваться:
//     String str = "apple"; str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции.
//     Играем до тех пор, пока игрок не отгадает слово
//     Используем только маленькие буквы
    static void guessTask2(){
        boolean isExit = false;
        guessWords();
        do{
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            int answer = scanner.next().charAt(0);
            if ('0' == answer) {
                isExit = true;
            } else if ('1' == answer) {
                guessWords();
            }
        } while(!isExit);
    }
    static void guessWords() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};
        int wordLength = words.length;
        Random random = new Random();
        int puzzle = random.nextInt(wordLength);
        String hiddenWord = words[puzzle];
        int hiddenWordLength = hiddenWord.length();
//        System.out.printf("puzzle: %s\n\n", hiddenWord);
        String input;
        int inputLength;
        int count;
        boolean flag = true;
        String placeholder = "#";
        String know;
        int diff;
        do {
            System.out.println("Угадайте загаданный фрукт или овощ на английском:\n в слове " + hiddenWordLength + " символов");
            count = 0;
            while (!scanner.hasNext()) {
                System.out.println("Введите слово:");
                scanner.next();
            }
            input = scanner.nextLine().toLowerCase();
            inputLength = input.length();
            know = "";
            for (int i = 0; i < inputLength && i < hiddenWordLength; i++) {
                if (input.charAt(i) == hiddenWord.charAt(i)) {
                    know += input.charAt(i);
                    count++;
                } else {
                    know += placeholder;
                }
            }
            diff = 15 - know.length();
            for (int i = 0; i < diff; i++) {
                know += placeholder;
            }
            if (inputLength == hiddenWordLength && count == hiddenWordLength) {
                flag = false;
                System.out.println("Вы угадали!");
            } else if (count > 0) {
                System.out.println(know);
            } else {
                System.out.println("нет совпадений\n");
            }
        } while (flag);
    }
}
