package Praktikum.Homework_1;

public class Converter {

    double stepsToCcal(double steps){
        return steps*50/1000;
    }           //конвертируем шаги в Килокаллории

    double stepsToKm(int steps){
        return steps*0.75;
    }                   //конвертируем шаги в киломметры
}
