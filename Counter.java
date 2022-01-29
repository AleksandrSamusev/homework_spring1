package Praktikum.Homework_1;
import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {

    StepTracker stepTracker = new StepTracker();                             //Создаем объект типа StepTracker
        Scanner scanner = new Scanner(System.in);                            //Создаем объект типа Scanner

        while (true) {
            printMenu();                                                     //печатаем в цикле меню
            int choice = scanner.nextInt();

            if (choice == 1) {
                int month;
                int day;

                System.out.println("Введите номер месяца (1 - январь...12 - декабрь): ");
                month = scanner.nextInt();
                 while (month <1 || month > 12) {                                             //Проверяем корректность
                     System.out.println("Введено некорректное значение. " +                   //ввода номера месяца
                                        "Введите номер месяца(1 - январь...12 - декабрь): ");
                     month = scanner.nextInt();
                 }

                System.out.println("Введите число (от 1 до 30): ");                            //Проверяем корректность
                 day = scanner.nextInt();                                                      //ввода числа
                while (day <1 || day > 30) {
                    System.out.println("Введено некорректное значение. Введите число (от 1 до 30): ");
                    day = scanner.nextInt();
                }
                System.out.println("Введите количество шагов: ");                             // Вносим шаги за день
                 int steps = scanner.nextInt();
                stepTracker.add(month, day, steps);
            }

            if (choice == 2) {
                int month;

                System.out.println("Введите номер месяца (1 - январь...12 - декабрь): ");
                month = scanner.nextInt();                                                    //Проверяем корректность
                while (month <1 || month > 12) {                                              //ввода номера месяца
                    System.out.println("Введено некорректное значение. " +
                                        "Введите номер месяца(1 - январь...12 - декабрь): ");
                    month = scanner.nextInt();
                }
                stepTracker.printMonth(month);                                     // Выводим по дням шаги за месяц
                stepTracker.monthSum(month);                                       // а также всю статистику
            }

            if (choice == 3) {
                int steps;
                System.out.print("Задайте новую цель по шагам: ");
                steps = scanner.nextInt();
                stepTracker.changeStepTarget(steps);                               //Задаем новую цель
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

