package Praktikum.Homework_1;
import java.util.HashMap;

public class StepTracker {
    int stepsTarget = 10000;
    HashMap<Integer, HashMap<Integer, Integer>> monthToData = new HashMap<Integer, HashMap<Integer, Integer>>();

    public StepTracker() {
        for (int i = 1; i < 13; i++) {
            monthToData.put(i, new HashMap<>());
            for (int j =1; j<31; j++){
                monthToData.get(i).put(j,0);
            }
        }
    }

    void add(int month, int day, int steps) {
        monthToData.get(month).put(day, steps);
    }

    void printMonth(int month){
        for(Integer temp : monthToData.get(month).keySet()){
           System.out.print("День:" + temp + ", Шаги:" + monthToData.get(month).get(temp) + ",");
        } System.out.println(" : " + stepsTarget);
    }

    void monthSum(int month){
        Converter converter = new Converter();
        int sum = 0;
        int counter = 0;
        for (Integer key: monthToData.get(month).keySet()) {
            sum += monthToData.get(month).get(key);
            if(monthToData.get(month).get(key) >= stepsTarget){
                counter++;
            }
        }
        System.out.println("Пройдено шагов за месяц: " + sum);
        System.out.println("Среднее количество шагов за месяц : " + sum/30);
        System.out.println("Пройдено километров за месяц : " + converter.stepsToKm(sum));
        System.out.println("Килокаллорий потрачено за месяц: " + converter.stepsToCcal(sum));
        if(counter == 0){
            System.out.println("В этом месяце цель по шагам не достигалась.");
        } else
            System.out.println("");
    }


    void changeStepTarget(int steps){
        this.stepsTarget = steps;
        System.out.println("Цель по шагам изменена. Новая цель - " + stepsTarget);
    }
}
