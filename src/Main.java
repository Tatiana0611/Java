public class Main {

    public static void main(String[] args) {

        Bank MegaBank = new Bank("MegaBank");

        Account profile_1 = new Account("Vasia", "Ivanov");
        Account profile_2 = new Account("Petya", "Smirnov");
        Account profile_3 = new Account("Katya", "Popova");
        Account profile_4 = new Account("Ira", "Petrova");

        Threads thread_1 = new Threads();
        Threads thread_2 = new Threads();
        Threads thread_3 = new Threads();
        Threads thread_4 = new Threads();
        thread_1.setResources(MegaBank, profile_1, profile_2, 10.0);
        thread_2.setResources(MegaBank, profile_1, profile_3, 15.0);
        thread_3.setResources(MegaBank, profile_1, profile_4, 5.0);
        thread_4.setResources(MegaBank, profile_4, profile_2, 35.0);


        /*//////////////////////////////////////////////////////////////////////////
        количетсво переводов установлено циклом в методе makeTransaction класса Bank
        *///////////////////////////////////////////////////////////////////////////

        thread_1.start();
        thread_2.start();
        thread_3.start();
        thread_4.start();
        try {
            thread_1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread_3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread_4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        MegaBank.printTransactionList();


    }   // end main ///////////////
}       // and class main /////////






/////////////////////////////////////////////////////
/*
написать симуляцию транзакции в банковской системе

Минимальные требования
        * несколько аккаунтов одновременной переводят деньги друг другу
        * обрабатывать транзакции (осуществлять перевод) в несколько потоков (как минимум в 2 потока)
        * в конце можно распечатать список со всеми транзакциями
        * у каждой транзакции есть int id, который либо генерится рандомно либо увеличивается на +1 от предыдущей транзакции
        * в начале рандомно на счету у каждого аккаунта генерится какая то сумма денег
        * объект аккаунт преставляет набор из счета, названия, любой доп информации
        * объект счет - номер счета, кол-во денежных средств и др.
        * объект транзакция
        * объект банк хранит все транзакции
        * отделить реализацию от интерфейсов, принципы SOLID, patterns
        * создать несколько тестовых сценариев

        Доп требования
        все параметры конфигурабельны (кол-во аккаунтов, потоков, генерации денег и тд)
        отдельный поток который похволяет добавлять, удалять и тд. аккаунты на лету
        отдельный поток который позволяет управлять параметрами аккаунты (деньги на счету, названия счетов) на лету

        Доп требования
        * обрабатывать транзакции с помощью паттернов publish/subscribe
        * визуализировать процесс перевода денег с одного аккаунта на другой например на javaFx
        * создать систему наподобие блокчейна чтобы у каждого аккаунты хранились все цепочки транзакций в системе
        * сервер-клиент взаимодействие (REST, http и др)
        * замерить скорость обработки транзакций
 */