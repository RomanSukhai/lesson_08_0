/*

It's my code,then only .Only I can using him,because have author rights for him
But I am allow for them in order to using him too))))))))))))))))))))

 */

package ru.unum.work;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;


/**
 * @since java 1.8
 * @author Roma
 * @version 1.1
 */


//name to class start
public class Main {
    //enum for Season
    enum Season {
        WINTER, SPRING, SUMMER, AUTUMN;
    }

    //enum for Month
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

        //variable type int,name day
        int day;

        //variable type class,name season and month
        Season season;
        Month month;

        //getter for day
        public int /*name getter --->*/getDay() {
            return day;
        }

        //getter for season
        public /*name getter --->*/Season getSeason() {
            return season;
        }

        //getter for month
        public /*name getter --->*/Month getMonth() {
            return month;
        }

        //this is constructor
        /*name constructor --->*/Month(int day, Season season) {
            this.day = day;
            this.season = season;
        }
        Month[] getMasDay=new Month[12];


    }
    //docs for mas int[]
    public static final int[] /*name mas --->*/LOGICAL_NAMES = new int[Month.values().length];

    //this is check mas name LOGICAL_NAMES
    static{
        for(int i=0; i<Month.values().length; i++)
            LOGICAL_NAMES[i]=Month.values()[i].day;
    }

    //this is print in order to can using in program
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

    //this is begin program
    public static void main(String[] args) throws WrongInputConsoleParametersException {
        Main.main();
        Season[] masSeason = Season.values();
        Month[] masMonth = Month.values();
        Scanner sc = new Scanner(System.in);


        //this is start cycle this program,which can work in order to hold user

        while (true) {

                    int scan = sc.nextInt();
                    if (scan<=9){
                        if (scan==1){
                            System.out.print("Enter month: ");
                            sc = new Scanner(System.in);
                            String input = sc.next().toUpperCase(Locale.ROOT);

                            //this method control and check Month in mas,whether it exists
                            ControlMonth(input);
                            Main.main();
                            break;
                        }


                        if (scan==2){

                            System.out.print("Enter season: ");
                            sc = new Scanner(System.in);
                            String input = sc.next().toUpperCase(Locale.ROOT);

                            //this method print all month for season in order to write user
                            boolean flag = MonthOfSeason(masSeason, masMonth, input);

                            if (!flag) {
                                System.out.println("Сезону не існує");
                            }
                            Main.main();
                            break;
                        }
                        if (scan==3){

                            System.out.print("Enter day: ");
                            sc = new Scanner(System.in);
                            int inputsc = sc.nextInt();

                            MonthOfCountDay(masMonth, inputsc);
                            Main.main();
                            break;
                        }
                        if (scan==4){
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
                        if (scan==5){
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
                        if (scan==6){
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
                        if (scan==7){
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
                        if (scan==8){
                            SteamDaySeason(0);
                        }
                        if (scan==9){
                            NoSteamDaySeason();
                        }
                    }
                    else {

                        String mesenger = "The values should be from 1 to 9";
                        throw new WrongInputConsoleParametersException(mesenger);
                    }
        }
    }

    /**
     * @param no input params
     * @exception WrongInputConsoleParametersException
     * @author Roma
     * @return null
     * @see java code convention
     **/

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
            String toExceptionMessenger ="Pleas,write Month,whether it exists ";

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



