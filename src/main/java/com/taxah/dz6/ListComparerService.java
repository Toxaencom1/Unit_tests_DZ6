package com.taxah.dz6;


public class ListComparerService {
    private double firstAverage;
    private double secondAverage;
    public ListComparerService(ComparisonList first, ComparisonList second) {
        this.firstAverage = calculateAverageGrade(first);
        this.secondAverage = calculateAverageGrade(second);
    }


    public double calculateAverageGrade(ComparisonList list){
        return list.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
    }

    public String compareAverageGrades(){
        if (firstAverage>secondAverage){
            return "Первый список имеет большее среднее значение";
        } else if (firstAverage<secondAverage) {
            return "Второй список имеет большее среднее значение";
        }
        return "Средние значения равны";
    }
}
