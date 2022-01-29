package Praktikum.Homework_1;
import java.util.HashMap;

public class StepTracker {
    int stepsTarget = 10000;                                                       //цель по шагам
    HashMap<Integer, HashMap<Integer, Integer>> monthToData
                       = new HashMap<Integer, HashMap<Integer, Integer>>();        //создаем объект типа HashMap

    public StepTracker() {                                                         //инициализируем поля HashMap,
        for (int i = 1; i < 13; i++) {
            monthToData.put(i, new HashMap<>());
            for (int j =1; j<31; j++){
                monthToData.get(i).put(j,0);
            }
        }
    }

    void add(int month, int day, int steps) {                                  // внесение шагов за определенный день
        monthToData.get(month).put(day, steps);
    }

    void printMonth(int month){                                               //Вывод по дням количества шагов за месяц
        for(Integer temp : monthToData.get(month).keySet()){
            System.out.print("День:" + temp + ", Шаги:" + monthToData.get(month).get(temp) + ",");
        } System.out.println(" : " + stepsTarget);
    }

    void monthSum(int month){                                                  //статистика за месяц
        Converter converter = new Converter();                                 //создаем обект класса Converter
        int sum = 0;
        boolean counter = false;
        for (Integer key: monthToData.get(month).keySet()) {                   //получаю кол-во шагов за месяц
            sum += monthToData.get(month).get(key);
            if(monthToData.get(month).get(key) >= stepsTarget){
                counter = true;                                                 //проверяю, был ли в этом месяце хотя-бы
            }                                                                  //один день с превышением
        }
        System.out.println("Пройдено шагов за месяц: " + sum);
        System.out.println("Среднее количество шагов за месяц : " + sum/30);
        System.out.println("Пройдено километров за месяц : " + converter.stepsToKm(sum));
        System.out.println("Килокаллорий потрачено за месяц: " + converter.stepsToCcal(sum));

        if(!counter){
            System.out.println("-------------------------------------------");
            System.out.println("В этом месяце цель по шагам не достигалась.");
            System.out.println("-------------------------------------------");

        } else {                                                          //если в месяце превышения по цели были, то
            int maxSerie = 1;                                             //ищем самую большую серию
            int serie = 1;
            monthToData.get(month).put(31, 0);                            //добавил "виртуальный" день 31 для
            for (Integer key: monthToData.get(month).keySet()) {          //корректности проверки условия в строке 54
                if((monthToData.get(month).get(key) >= stepsTarget) &&
                                  (monthToData.get(month).get(key+1) >= stepsTarget)){

                    serie += 1;                                           //счетчик текущей серии
                } else {
                    if (serie > maxSerie){                                //сравнение с максимальной серией
                        maxSerie = serie;
                        serie = 0;
                    }
                }
            }
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Максимальная серия (дней подряд с превышением) в этом месяце : " + maxSerie) ;
            System.out.println("-------------------------------------------------------------------");
        }

    }


    void changeStepTarget(int steps){                                                  //изменяем цель по шагам
        this.stepsTarget = steps;
        System.out.println("Цель по шагам изменена. Новая цель - " + stepsTarget);
    }
}