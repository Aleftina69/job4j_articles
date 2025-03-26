package ru.job4j.ood.ocp;

class Report {
    private final String format;

    public Report(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}

class ReportGenerator {
    public void generateReport(Report report) {
        switch (report.getFormat()) {
            case "CSV":
                break;
            case "PDF":
                break;
            case "XML":
                break;
            default:
                throw new UnsupportedOperationException("Unknown report format");
        }
    }
}

/*
Причина нарушения OCP:
Для добавления нового формата отчета (например, XML) необходимо изменять метод generateReport,
что делает код менее гибким и более подверженным ошибкам.
 */
