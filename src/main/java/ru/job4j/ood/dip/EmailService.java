package ru.job4j.ood.dip;

class EmailService {
    public void sendEmail(String message) {
        System.out.println("Отправка сообщения: " + message);
    }
}

class Notification {
    private EmailService emailService;

    public Notification() {
        this.emailService = new EmailService();
    }

    public void notifyUser(String message) {
        emailService.sendEmail(message);
    }
}

/*
Причина нарушения: Notification зависит от конкретного класса EmailService,
что делает его жестко связанным и сложным для тестирования.
*/

