package ru.job4j.ood.isp.violation3;

public class Main {
    public static void main(String[] args) {
        LightCruiser lightCruiser = new LightCruiser();
        System.out.println(lightCruiser.fly());
        System.out.println(lightCruiser.land());
        System.out.println(lightCruiser.shoot());

        ScienceVessel scienceVessel = new ScienceVessel();
        System.out.println(scienceVessel.fly());
        System.out.println(scienceVessel.land());
        System.out.println(scienceVessel.doScience());
    }
}

/*
Таким образом, нарушение ISP состоит в том, что хотя бы один из методов интерфейса Spaceship
не использован в каждом представленном здесь случае по крайней мере одной из реализаций
(в данном случае, каждая реализация содержит не используемый метод).
 */