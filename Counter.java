package Praktikum.Homework_1;
import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
    StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Введите номер месяца (1 - январь...12 - декабрь): "); //Проверка ввода (1<x<12)
                int month = scanner.nextInt();
                System.out.println("Введите число (от 1 до 30): ");                        //Проверка ввода (1<x<30)
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов: ");
                int steps = scanner.nextInt();
                stepTracker.add(month, day, steps);
            }

            if (choice == 2) {
                System.out.println("Введите номер месяца (1 - январь...12 - декабрь): ");  //Проверка ввода (1<x<12)
                int month = scanner.nextInt();
                stepTracker.printMonth(month);
                stepTracker.monthSum(month);
            }

            if (choice == 3) {
                int steps;
                System.out.print("Задайте новую цель по шагам: ");
                steps = scanner.nextInt();
                stepTracker.changeStepTarget(steps);
            }
            if (choice == 0){
                break;
            }
        }
        }

    public static void printMenu(){
        System.out.println("-------------------------------------------------");
        System.out.println("1 - Внести данные за определенный день.");
        System.out.println("2 - Выгрузить статистику за определенный месяц.");
        System.out.println("3 - Изменить цель по шагам.");
        System.out.println("0 - Выход.");
        System.out.println("-------------------------------------------------");
}

}

