package ru.job4j.ood.dip;

class Database {
    public void connect() {
        System.out.println("Подключение к базе данных");
    }
}

class UserService {
    private Database database;

    public UserService() {
        this.database = new Database();
    }

    public void getUser(int userId) {
        database.connect();
        System.out.println("Получение пользователя с ID: " + userId);
    }
}

/*
Причина нарушения: UserService напрямую зависит от класса Database,
что затрудняет тестирование и замену базы данных.
*/
