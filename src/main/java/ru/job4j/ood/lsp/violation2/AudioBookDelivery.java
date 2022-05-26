package ru.job4j.ood.lsp.violation2;

public class AudioBookDelivery extends BookDelivery {

    @Override
    void getDeliveryLocations() {

        /* нельзя реализовать

         поскольку у аудиокниги нет

         физического местоположения */
    }
}

/*
В случае, если внести изменение в метод getDeliveryLocations(),
то это нарушит LSP. После такой модификации мы не можем заменить
суперкласс BookDelivery подклассом AudioBookDelivery
без нарушения работы приложения.
 */
