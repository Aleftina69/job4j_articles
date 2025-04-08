package ru.job4j.ood.dip;

class Logger {
    public void log(String message) {
        System.out.println(message);
    }
}

class UserController {
    private Logger logger;

    public UserController() {
        this.logger = new Logger();
    }

    public void createUser(String username) {
        logger.log("Создан пользователь: " + username);
    }
}

/* Причина нарушения: UserController зависит от конкретной реализации Logger,
что затрудняет замену логирования (например, на логирование в файл или удаленный сервер).
*/
