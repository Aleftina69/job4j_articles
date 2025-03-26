package ru.job4j.ood.ocp;

class Notification {
    private final String type;

    public Notification(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class NotificationService {
    public void sendNotification(Notification notification) {
        switch (notification.getType()) {
            case "Email":
                break;
            case "SMS":
                break;
            case "Push":
                break;
            default:
                throw new UnsupportedOperationException("Unknown notification type");
        }
    }
}

/*
  Причина нарушения OCP:
  Каждый раз, когда нужно добавить новый тип уведомления (например, Push),
  необходимо изменять метод sendNotification,
  что приводит к увеличению сложности и снижению гибкости кода.
 */
