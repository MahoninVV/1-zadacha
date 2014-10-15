/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Валерий Махонин
 */
import java.util.Scanner;
public class JavaApplication1 {

    
    public static void main(String[] args) {
        System.out.println("Водитель маршрутного такси");
        sleeping();
    }
    public static Scanner scan = new Scanner(System.in);
    public static String str;
    
    public static boolean ask(String quest) {
        boolean res = false; // yes or no
        boolean succ = false; //флаг на успешный ввод
        while (!succ) {
            System.out.println(quest); //печатаем вопрос из методов
            str = scan.nextLine();  //cчитываем ответы на вопросы
            switch (str.charAt(0)) {
                case 'y':
                    res = true;
                    succ = true;
                    break;
                case 'n':
                    res = false;
                    succ = true;
                    break;
                default:
                    System.out.println("выбирайте  y или n");
                    break;
            }
        }
        return res;
    }
    public static void sleeping() {
        System.out.println("..Сплю..");
        wake();
    }
    public static void wake() {
        System.out.println("Проснулся...");
        isEat();
    }
    public static void isEat() {
        if (ask("Покушаем?")) {
            System.out.println("Иду к холодильнику");
            haveFood();
        }
        else
            isWorking();
    }    
    public static void haveFood() {
        if (ask("Есть еда?")){
            System.out.println("Кушаю...");
            isWorking();
        }
        else
           isMoney();
    }
    public static void isMoney() {
        if (ask("Есть $$$?"))
            System.out.println("Иду к Ашоту в кафе");
        else
           isWorking();
    }
    public static void isWorking() {
        if (ask("Надо на работу?")) {
            System.out.println("Иду к маршрутке");
            starts();
        }
        else {
            choose();
        }
    }
    public static void choose(){
        System.out.println("Рыбалочка, по бабам, чинить маршрутку, смотреть тв");
            dayOff();
    }
    public static void starts() {
        if (ask("Заводится?")) {
           goToStation();
        }
        else {
            System.out.println("Зовем Михалыча чинить маршрутку");
            isRepaired();
        }
    }
    public static void isRepaired() {
       if (ask("Починили?"))
            goToStation();
        else
            choose();
    }
    public static void goToStation() {
        System.out.println("Еду на конечную");
        isVoyage();
    }
    public static void dayOff() {
       if (ask("Закончился день?")) {
            goHome();
       }
        else
            choose();
    }
    public static void isVoyage(){
        if (ask("Нужно в рейс?")) {
            getPeople();
        }
        else
            chooseVoyage();
    }
    public static void chooseVoyage(){
        System.out.println("Поговорить с коллегами, Покушать, Посчитать выручку");     
    }
    public static void getPeople() {
        System.out.println("Усаживаем пассажиров");
        allPay();
    }
    public static void allPay(){
        if (ask("Все передали за проезд?")) {
            getLargeBills();
        }
        else {
            System.out.println("Потребовать деньги. Не продолжать движение");   
            allPay();
        }
    }
    public static void getLargeBills() {
        if (ask("Дали крупную купюру?")) {
            isRenting();   
        }
        else {
            System.out.println("Дать сдачу при необходимости");   
            move();
        }
    }
    public static void isRenting() {
        if (ask("Есть сдача?")) {
            System.out.println("Попытаться обсчитать");   
            move();
        }
        else {
            System.out.println("Высадить");   
            move();
        }
    }
    public static void move(){
        System.out.println("ЕДЕМ");
        if (ask("Приближаемся к конечной?")) {
            isNext();
        }
        else
            havePlaces();
    }
    public static void isNext(){
        if (ask("Следующая конечная?")) {
            System.out.println("Высаживаем всех");
            endOfShift();
        }
        else
            havePlaces();
    }
    public static void havePlaces(){
        if (ask("Есть свободные места?")) {
            System.out.println("Останавливаемся на каждой остановке");
            getPeople();
        }
        else
            askStop();
    }
    public static void askStop(){
        if (ask("Заранее попросили?")) {
            System.out.println("Плавно остановиться");
            havePassangers();
        }
        else
            move();
    }
    public static void havePassangers(){
        if (ask("Есть пассажиры на посадку?")) {
           getPeople();
        }
        else
            move();
    }
    public static void endOfShift(){
        if (ask("Конец смены?")) {
           goHome();
        }
        else {
           System.out.println("Ждём");
           isVoyage();
        }
    }
    public static void goHome(){
        System.out.println("ДОМОООЙ!");
        if (ask("Надо завтра на работу?")) {
            System.out.println("Заводим будильник");
            sleeping();
        }
        else
            sleeping();
    }    
}
