package HomeWork.UI;

import HomeWork.TaskBook.Core.MVP.Presenter;
import HomeWork.TaskBook.Core.MVP.View;

import java.util.Scanner;


public class App {

    public static void buttonClick() {
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view);
        presenter.loadFromDb();
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                view.printMenu();
                String choice = in.next();
                switch (choice) {
                    case "1" -> presenter.add();
                    case "2" -> presenter.showAllTasks();
                    case "3" -> presenter.saveToDb();
                    case "4" -> presenter.importCSV();
                    case "5" -> presenter.exportCSV();
                    case "0" -> {
                        System.out.println("Завершение работы");
                        System.exit(0);
                    }
                    default -> System.out.println("Такой команды нет");
                }
            }
        }
    }


}