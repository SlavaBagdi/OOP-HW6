package HomeWork.UI;

import HomeWork.TaskBook.Core.Enums.Priorities;
import HomeWork.TaskBook.Core.MVP.View;

import java.util.Scanner;

public class ConsoleView implements View {

    Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getTaskText() {
        System.out.printf("Задача: ");
        return in.nextLine();
    }

    @Override
    public void setTaskText(String value) {
        System.out.printf("Задача: " + value + "\n");
    }

    @Override
    public Priorities getPriority() {
        System.out.printf("Выберите приоретет:\n" +
                "1 - Немедленно\n" +
                "2 - Средний\n" +
                "3 - Низкий\n");
        System.out.print("Выбор: ");
        int choice = in.nextInt();
        Priorities temp;
        switch (choice) {
            case 1 -> temp = Priorities.IMMEDIATE;
            case 2 -> temp = Priorities.MEDIUM;
            default -> temp = Priorities.LOW;
        }
        return temp;
    }

    @Override
    public void setPriority(String value) {
        System.out.printf("Приоретет: " + value + "\n");
    }

    @Override
    public String getDeadline() {
        System.out.printf("Дедлайн: ");
        return in.nextLine();
    }

    @Override
    public void setDeadline(String value) {
        System.out.printf("Дедлайн: " + value + "\n");
    }

    @Override
    public String getAuthor() {
        System.out.printf("Автор: ");
        return in.nextLine();
    }

    @Override
    public void setAuthor(String value) {
        System.out.printf("Автор: " + value + "\n");
    }

    @Override
    public void setCreateDate(String value) {
        System.out.printf("Дата и время создания задачи: " + value + "\n");
    }

    @Override
    public void printMenu() {
        String sb = """

                1 - Добавить задачу
                2 - Показать все задачи
                3 - Сохранить БД
                4 - Импортировать из CSV
                5 - Экспортировать в CSV
                0 - Завершить работу
                """;
        System.out.println(sb);
        System.out.print("Ваш выбор: ");
    }
}