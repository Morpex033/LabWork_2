package com.company;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a = 1;
	    for (int i = 0; i < 5; i++){
        System.out.println((22+23+(a++ -1)*25));
        }
        task45();
        task70();
        task95();
        task120();
        task145();
    }

    /*
     Создать одномерный массив
    */
    public static int[] CreateArray(int size){
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(100) + 1;
        }
        return array;
    }

    /*
    Задана последовательность из N вещественных чисел. Определить, сколько среди них чисел, меньших К, равных К и больших К.
     */
    public static void task45(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер массива чисел");
        int size = scan.nextInt();
        while (true) {
            if (size <= 0) {
                System.out.println("Размер массива не может быть меньше чем 1. Повторите");
                size = scan.nextInt();
            }else{
                break;
            }
        }
        int[] array = CreateArray(size);
        System.out.println("Введите число K, число должно быть не отрицательным:");
        int K = scan.nextInt();
        while (true){
            if (K < 0){
                System.out.println("Число которое вы ввели, меньше нуля. Повторите попытку.");
                K = scan.nextInt();
            }else {
                break;
            }
        }

        int Less_than_K = 0;
        int More_than_K = 0;
        int Equals_K = 0;
        for (int i = 0; i < array.length; i++){
            if (K < array[i]){
                Less_than_K++;
            }else if(K > array[i]){
                More_than_K++;
            }else{
                Equals_K++;
            }
        }
        System.out.println("Ваше число - " + K +
                "\nЧисла которые меньше чем ваше число - " + Less_than_K +
                "\nЧисла которые больше вашего числа - " + More_than_K +
                "\nЧисла которые равны вашему - " + Equals_K);
    }

    /*
    Найти произведение элементов массива, кратных 3 и 9.
     */
    public static void task70(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер массива чисел");
        int size = scan.nextInt();
        while (true) {
            if (size <= 0) {
                System.out.println("Размер массива не может быть меньше чем 1. Повторите");
                size = scan.nextInt();
            }else{
                break;
            }
        }
        int[] array = CreateArray(size);
        int[] arraySum = new int[array.length];
        Arrays.fill(arraySum,0);
        int a = 0;
        for (int i = 0; i < array.length; i++){
            if ((array[i]%3 == 0) || (array[i]%9 == 0)){
                arraySum[a++] = array[i];
            }
        }
        BigInteger BigNum = new BigInteger("1");
        for (int i = 0; i < arraySum.length; i++){
            if (arraySum[i] != 0) {
                BigInteger temp = BigInteger.valueOf(arraySum[i]);
                BigNum = BigNum.multiply(temp);
            }
        }
        System.out.println("Произведение всех чисел массива кратных 3 и 9 - " + BigNum);
    }

    /*
    Удалить элемент массива целых чисел, удовлетворяющий условию: остаток от деления на 3 равен 2.
     Если таких элементов нет, выдать сообщение «элементы для удаления не найдены».
     */
    public static void task95() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива целых чисел");
        int size = scanner.nextInt();
        while (true) {
            if (size <= 0) {
                System.out.println("Размер массива не может быть меньше чем 1. Повторите");
                size = scanner.nextInt();
            }else{
                break;
            }
        }
        int[] array = CreateArray(size);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if ((array[i] % 3) == 2) {
                array[i] = 0;
            }
        }
        boolean flag = true;
        for (int i: array) {
            if(i != 0) {
                flag = false;
            }
        }
        if(flag == true) System.out.println("Элементов для удаления не найдено.");
        int point = 0;
        for (int i: array){
            if (i == 0){
                point++;
            }else{
                System.out.print(i + " ");
            }
        }
        for (int i = 0; i < point; i++){
            System.out.print(0 + " ");
        }
        System.out.println();
    }

    /*
    Заданы два массива. Создать один массив, в котором все элементы расположены в порядке возрастания.
     */
    public static void task120(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размеры массивов");
        int size = scan.nextInt();
        while (true) {
            if (size <= 0) {
                System.out.println("Размер массива не может быть меньше чем 1. Повторите");
                size = scan.nextInt();
            }else{
                break;
            }
        }
        int[] array1 = CreateArray(size);
        int[] array2 = CreateArray(size);
        Arrays.sort(array1);
        for (int i:array1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i:array2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /*
    Японская радиокомпания провела опрос N радиослушателей по вопросу: «Какое животное вы связываете с Японией и японцами?».
    Составить программу получения k наиболее часто встречающихся ответов и их долей (в процентах).
     */
    public static void task145() {
        Random random = new Random();
        final int size = random.nextInt(35000000) + 15000000;
        String[] Japan_People = new String[size];
        String[] Animals = {"Cow", "Wolf", "Sheep", "Goat", "Pig", "Horse", "Dog", "Cat", "Bird", "Fish", "Tiger", "Lion", "Monkey"};
        int Cow = 0, Wolf = 0, Sheep = 0, Goat = 0, Pig = 0, Horse = 0, Dog = 0, Cat = 0, Bird = 0, Fish = 0, Tiger = 0, Lion = 0, Monkey = 0;
        for (int i = 0; i < Japan_People.length; i++) {
            Japan_People[i] = Animals[random.nextInt(Animals.length)];
        }
        for (int i = 0; i < Japan_People.length; i++) {
            switch (Japan_People[i]) {
                case "Cow":
                    Cow++;
                    break;
                case "Wolf":
                    Wolf++;
                    break;
                case "Sheep":
                    Sheep++;
                    break;
                case "Goat":
                    Goat++;
                    break;
                case "Pig":
                    Pig++;
                    break;
                case "Horse":
                    Horse++;
                    break;
                case "Dog":
                    Dog++;
                    break;
                case "Cat":
                    Cat++;
                    break;
                case "Bird":
                    Bird++;
                    break;
                case "Fish":
                    Fish++;
                    break;
                case "Tiger":
                    Tiger++;
                    break;
                case "Lion":
                    Lion++;
                    break;
                case "Monkey":
                    Monkey++;
                    break;
                default:
                    break;
            }
        }
        int all_animals = Cow + Wolf + Sheep + Goat + Pig + Horse + Dog + Cat + Bird + Fish + Tiger + Lion + Monkey;
        System.out.println("Было опрошено " + Japan_People.length + " жителей Японии.");
        System.out.println("Вопрос: Какое животное вы связываете с Японией и японцами?");
        System.out.println("Корова: " + Cow + " голосов, " + (Cow * 100 / all_animals) + "%" + " от общего количества голосов.");
        System.out.println("Волк: " + Wolf + " голосов, " + (Wolf * 100 / all_animals) + "%" + " от общего количества голосов.");
        System.out.println("Овца: " + Sheep + " голосов, " + (Sheep * 100 / all_animals) + "%" + " от общего количества голосов.");
        System.out.println("Коза: " + Goat + " голосов, " + (Goat * 100 / all_animals) + "%" + " от общего количества голосов.");
        System.out.println("Свинья: " + Pig + " голосов, " + (Pig * 100 / all_animals) + "%" + " от общего количества голосов.");
        System.out.println("Лошадь: " + Horse + " голосов, " + (Horse * 100 / all_animals) + "%" + " от общего количества голосов.");
        System.out.println("Собака: " + Dog + " голосов, " + (Dog * 100 / all_animals) + "%" + " от общего количества голосов.");
        System.out.println("Кошка: " + Cat + " голосов, " + (Cat * 100 / all_animals) + "%" + " от общего количества голосов.");
        System.out.println("Птица: " + Bird + " голосов, " + (Bird * 100 / all_animals) + "%" + " от общего количества голосов.");
        System.out.println("Рыба: " + Fish + " голосов, " + (Fish * 100 / all_animals) + "%" + " от общего количества голосов.");
        System.out.println("Тигр: " + Tiger + " голосов, " + (Tiger * 100 / all_animals) + "%" + " от общего количества голосов.");
        System.out.println("Лев: " + Lion + " голосов, " + (Lion * 100 / all_animals) + "%" + " от общего количества голосов.");
        System.out.println("Обезьяна: " + Monkey + " голосов, " + (Monkey * 100 / all_animals) + "%" + " от общего количества голосов.");
    }
}
