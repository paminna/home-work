package com.sbrf.reboot.equalshashcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class EqualsHashCodeTest {

     class Car {
        String model;
        String color;
        Calendar releaseDate;
        int maxSpeed;

        String getModel()
        {
            return model;
        }

        String getColor()
        {
            return color;
        }

        Calendar getDate()
        {
            return releaseDate;
        }

        int getMaxSpeed()
        {
            return maxSpeed;
        }

        @Override
        public boolean equals(Object o) {
            //Рефлексивность: объект должен равняться самому себе
            if (o == this)
                return true;
            // объявляем переменную типа, с которой хотим сравнить и приводим о к этому типу
            Car car = (Car)o;
            // проверяем, что все значения полей объектов равны и объекты имеют один тип
            if (       (car.getModel().equals(this.model))
                    && (car.getMaxSpeed() == this.maxSpeed)
                    && (car.getDate().equals(this.releaseDate))
                    && (car.getColor().equals(car.color))
                    && (car.getClass().equals(this.getClass())))
                return true;
            // проверка на то, что объект не равен null и что объекты имеют один тип
            if (o != null || o.getClass() == this.getClass())
                return true;
            return false;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(model, color, releaseDate, maxSpeed);
        }
     }

    @Test
    public  void assertTrueEquals() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Mercedes";
        car2.color = "black";
        car2.releaseDate = new GregorianCalendar(2020, 0, 25);
        car2.maxSpeed = 10;

        car1.equals(car2);
        Assertions.assertTrue(car1.equals(car2));
    }

    @Test
    public void assertFalseEquals() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Audi";
        car2.color = "white";
        car2.releaseDate = new GregorianCalendar(2017, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertFalse(car1.equals(car2));
    }

    @Test
    public void successEqualsHashCode(){
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Mercedes";
        car2.color = "black";
        car2.releaseDate = new GregorianCalendar(2020, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertEquals(car1.hashCode(),car2.hashCode());

    }

    @Test
    public void failEqualsHashCode(){
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Audi";
        car2.color = "white";
        car2.releaseDate = new GregorianCalendar(2017, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertNotEquals(car1.hashCode(),car2.hashCode());

    }

    @Test
    public void CheckEquals(){
        Car car1 = new Car();
        car1.model = "audii";
        car1.color = "white";
        car1.releaseDate = new GregorianCalendar(2017, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Audi";
        car2.color = "white";
        car2.releaseDate = new GregorianCalendar(2017, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertNotEquals(car1.hashCode(),car2.hashCode());
    }

    @Test
    public void CheckEqualsNull(){
        Car car1 = new Car();
        car1.model = null;
        car1.color = null;
        car1.releaseDate = new GregorianCalendar(0000, 0, 00);
        car1.maxSpeed = 0;

        Car car2 = new Car();
        car2.model = "Audi";
        car2.color = "white";
        car2.releaseDate = new GregorianCalendar(2017, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertNotEquals(car1.hashCode(),car2.hashCode());
    }
}
