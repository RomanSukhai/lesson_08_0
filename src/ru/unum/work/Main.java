package ru.unum.work;
import ua.lviv.lgs.enumeraion.console.Aplication;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    enum Season {
        WINTER, SPRING, SUMMER, AUTUMN;
    }


    enum Month {
        JANUARY(30, Season.WINTER),
        FEBRUARY(23, Season.SPRING),
        MARCH(31, Season.SPRING),
        APRIL(25, Season.SPRING),
        JUNE(30, Season.SPRING),
        JULY(23, Season.SUMMER),
        AUGUST(31, Season.SUMMER),
        SEPTEMBER(25, Season.AUTUMN),
        OCTOBER(30, Season.AUTUMN),
        NOVEMBER(23, Season.AUTUMN),
        DECEMBER(31, Season.WINTER);

        int day;
        Season season;
        Month month;

        public int getDay() {
            return day;
        }

        public Season getSeason() {
            return season;
        }

        public Month getMonth() {
            return month;
        }

        Month(int day, Season season) {
            this.day = day;
            this.season = season;
        }
        Month[] getMasDay=new Month[12];


    }
    public static final int[] LOGICAL_NAMES = new int[Month.values().length];
    static{
        for(int i=0; i<Month.values().length; i++)
            LOGICAL_NAMES[i]=Month.values()[i].day;
    }
    public static void main(){
        System.out.println(" ");
        System.out.println("Натисніть 1 (Чи є такий місяць)");
        System.out.println("Натисніть 2 (щоб вивести всі місяці з  такою порою року)");
        System.out.println("Натисніть 3 (щоб вивести всі дні з такою кількістю днів)");
        System.out.println("Натисніть 4 (щоб вивести всі місяці які мають найменшу кількість днів)");
        System.out.println("Натисніть 5 (щоб вивести всі місяці які мають найбільшу кількість днів)");
        System.out.println("Натисніть 6 (щоб вивести на екран наступну пору року)");
        System.out.println("Натисніть 7 (щоб вивести на екран попередню пору року)");
        System.out.println("Натисніть 8 (щоб всі місяці які мають парну кількість днів)");
        System.out.println("Натисніть 9 (щоб всі місяці які мають не парну кількість днів)");
        System.out.println(" ");
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Main.main();
        Season[] masSeason = Season.values();
        Month[] masMonth = Month.values();
        Scanner sc = new Scanner(System.in);
        while (true) {

            switch (sc.next()) {
                case "1": {
                    System.out.print("Enter month: ");
                    sc = new Scanner(System.in);
                    String input = sc.next().toUpperCase(Locale.ROOT);

                    ControlMonth(input);
                    Main.main();
                    break;
                }


                case "2": {

                    System.out.print("Enter season: ");
                    sc = new Scanner(System.in);
                    String input = sc.next().toUpperCase(Locale.ROOT);

                    boolean flag = MonthOfSeason(masSeason, masMonth, input);

                    if (!flag) {
                        System.out.println("Сезону не існує");
                    }
                    Main.main();
                    break;
                }
                case "3": {

                    System.out.print("Enter day: ");
                    sc = new Scanner(System.in);
                    int inputsc = sc.nextInt();

                    MonthOfCountDay(masMonth, inputsc);
                    Main.main();
                    break;
                }
                case "4": {
                    int max = 0;
                    max=LOGICAL_NAMES[0];
                    for (int i = 1; i < 10; i++) {
                        if (LOGICAL_NAMES[i] > max) {
                            max = LOGICAL_NAMES[i];
                            for (Month m :masMonth){
                                if (max ==m.getDay()){
                                    System.out.println(m.name());
                                }
                            }
                        }
                    }
                    Main.main();
                    break;

                }
                case "5":{
                    int min = 0;
                    min=LOGICAL_NAMES[0];
                    for (int i = 1; i < 10; i++) {
                        if (LOGICAL_NAMES[i] < min) {
                            min = LOGICAL_NAMES[i];
                            for (Month m :masMonth){
                                if (min ==m.getDay()){
                                    System.out.println(m.name());
                                }
                            }
                        }
                    }
                    Main.main();
                    break;
                }
                case "6": {
                    System.out.print("Enter season: ");
                    sc = new Scanner(System.in);
                    String input = sc.next().toUpperCase(Locale.ROOT);

                    boolean flag =false;

                    for (Season s : masSeason) {
                        if (s.name().equals(input)) {
                            System.out.println("Сезон існує");
                            flag = true;
                        }
                    }

                    if(flag){
                        Season cont2 = Season.valueOf(input);
                        int ordinal = cont2.ordinal();

                        if (ordinal == (masSeason.length - 1) ){
                            ordinal = 0;
                            System.out.println(masSeason[ordinal]);
                        }
                        else {
                            System.out.println(masSeason[ordinal+1]);

                        }

                    }
                    if (!flag) {
                        System.out.println("Немає такої кількості");
                    }
                    Main.main();
                    break;
                }
                case "7": {
                    System.out.print("Enter season: ");
                    sc = new Scanner(System.in);
                    String input = sc.next().toUpperCase(Locale.ROOT);

                    boolean flag =false;

                    for (Season s : masSeason) {
                        if (s.name().equals(input)) {
                            System.out.println("Сезон існує");
                            flag = true;
                        }
                    }

                    if(flag){
                        Season cont2 = Season.valueOf(input);
                        int ordinal = cont2.ordinal();

                        if (ordinal == (masSeason.length +1) ){
                            ordinal = 0;
                            System.out.println(masSeason[ordinal]);
                        }
                        else if (input.equalsIgnoreCase("Winter")){
                            System.out.println(masSeason[(ordinal+(3))]);
                        }
                        else {
                            System.out.println(masSeason[(ordinal+(-1))]);

                        }

                    }
                    if (!flag) {
                        System.out.println("Немає такої кількості");
                    }
                    Main.main();
                    break;

                }
                case "8":{
                    SteamDaySeason(0);
                }
                case "9":{
                    NoSteamDaySeason();
                }

            }
        }
    }

    private static void MonthOfCountDay(Month[] masMonth, int inputsc) {
        boolean flag = false;

        for (Month m : masMonth) {
            if (m.day == inputsc) {
                System.out.println(m.name());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Немає такої кількості");
        }
        return;
    }

    private static boolean MonthOfSeason(Season[] masSeason, Month[] masMonth, String input) {
        boolean flag = false;

        for (Season s : masSeason) {
            if (s.name().equals(input)) {
                System.out.println("Сезон існує");
                flag = true;
            }
        }
        if (flag) {

            for (Month ses : masMonth) {
                if (ses.getSeason().name().equalsIgnoreCase(input)) {
                    System.out.println(ses);
                }
            }
        }
        return flag;
    }

    private static void ControlMonth(String input) {
        boolean flag = false;

        for (Month m : Month.values()) {
            if (m.name().equals(input)) {
                System.out.println("Місяць існує");
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Такаога місяця не існує");
        }
        return;
    }

    private static void NoSteamDaySeason() {
        boolean flag = false;
        for (Month m : Month.values()){
            if (m.getDay() % 2 == 1){
                System.out.println(m.name());
                flag = true;
            }
        }
    }

    private static void SteamDaySeason(int i) {
        boolean flag = false;
        for (Month m : Month.values()) {
            if (m.getDay() % 2 == i) {
                System.out.println(m.name());
                flag = true;
            }
        }
    }
}



