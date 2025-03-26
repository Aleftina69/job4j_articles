package ru.job4j.ood.ocp;

class Form {
    public void submit() {
    }
}

class ContactForm extends Form {
    public void submit() {
        System.out.println("Submitting contact form");
    }
}

class RegistrationForm extends Form {
    public void submit() {
        System.out.println("Submitting registration form");
    }
}

class FormHandler {
    private ContactForm contactForm;
    private RegistrationForm registrationForm;

    public FormHandler() {
        this.contactForm = new ContactForm();
        this.registrationForm = new RegistrationForm();
    }

    public void handleContactForm() {
        contactForm.submit();
    }

    public void handleRegistrationForm() {
        registrationForm.submit();
    }
}

/* Если нам нужно добавить новый тип формы, например, FeedbackForm,
нам придется изменить класс FormHandler, добавив новый метод handleFeedbackForm
и создавать новый экземпляр FeedbackForm. Это нарушает принцип OCP,
потому что мы изменяем существующий код для добавления новой функциональности.
 */
