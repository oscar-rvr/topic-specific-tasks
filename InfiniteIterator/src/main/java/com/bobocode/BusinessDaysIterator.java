package com.bobocode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BusinessDaysIterator
        implements Iterator<LocalDate> {
    private LocalDate currentDate;

    public BusinessDaysIterator(LocalDate startDate){
    this.currentDate=startDate;
    }

    @Override
    public boolean hasNext(){
        return true;
    }

    @Override
    public LocalDate next(){
        currentDate=currentDate.plusDays(1);
        while(currentDate.getDayOfWeek()==DayOfWeek.SATURDAY||currentDate.getDayOfWeek()==DayOfWeek.SUNDAY){
            currentDate=currentDate.plusDays(1);
        }
        return currentDate;
    }



    public static void main(String[] args) {

        Iterator<LocalDate> iter = new BusinessDaysIterator(LocalDate.of(2022, 1, 1)); // 1 de enero de 2022

        System.out.println(iter.next());
        System.out.println(iter.next());



    }

}