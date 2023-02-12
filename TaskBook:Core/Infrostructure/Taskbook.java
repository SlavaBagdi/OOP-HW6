package HomeWork.TaskBook.Core.Infrostructure;

import HomeWork.TaskBook.Core.Models.Task;

import java.io.Serializable;
import java.util.ArrayList;
/*
Component for storing a list of tasks and working with them
 */
public class Taskbook implements Serializable {

    private ArrayList<Task> tasks;

    public Taskbook() {
        this.tasks = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task getTask(int index) {
        return contains(index) ? tasks.get(index) : null;
    }

    public boolean remove(Task task) {
        boolean flag = false;
        if (tasks.contains(task)) {
            tasks.remove(task);
            flag = true;
        }
        return flag;
    }

    public void add(Task task) {
        tasks.add(task);
    }

    private boolean contains(int index) {
        return tasks != null
                && tasks.size() > index;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

}