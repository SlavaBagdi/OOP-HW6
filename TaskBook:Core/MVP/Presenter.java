package HomeWork.TaskBook.Core.MVP;

import HomeWork.TaskBook.Core.Models.Task;

public class Presenter {

    private Model model;
    private View view;

    public Presenter(View view) {
        this.view = view;
        this.model = new Model();
    }

    public void add() {
        System.out.println("Введите задачу: ");
        model.currentBook.add(
                new Task(view.getTaskText(), view.getDeadline(), view.getAuthor(), view.getPriority()));
    }

    /*
    Save to database
     */
    public void saveToDb() {
        model.save();
        System.out.println("Успешно сохранено");
    }

    /*
    Load from database
     */
    public void loadFromDb() {
        model.load();
    }

    public void showAllTasks() {
        for (Task tsk : model.currentBook.getTasks()) {
            System.out.println("----------");
            System.out.println("Здача №:" + tsk.getId());
            view.setTaskText(tsk.getTaskText());
            view.setDeadline(tsk.getDeadline());
            view.setAuthor(tsk.getAuthor());
            view.setPriority(tsk.getPriority().toString());
            view.setCreateDate(tsk.getDateTime());
        }
    }

    public void importCSV() {
        model.importFromCSV();
        view.showMessage("Импорт завершён");
    }

    public void exportCSV() {
        model.exportToCSV();
        view.showMessage("Экспорт завершен");
    }


}