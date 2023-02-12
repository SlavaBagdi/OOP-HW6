package HomeWork.TaskBook.Core.Models.FileMod;

import HomeWork.TaskBook.Core.Infrostructure.Taskbook;
import HomeWork.TaskBook.Core.Models.Task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * To work with the database
 */
public class Database extends WorkWithFiles implements IDatabase {


    public Database(String path, Taskbook taskbook) {
        super(path, taskbook);
    }

    public Database(Taskbook taskbook) {
        super("Database.dat", taskbook);
    }

    @Override
    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getPath()))) {
            oos.writeObject(getTaskbook());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Taskbook load() {
        Taskbook tasks;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getPath()))) {
            tasks = (Taskbook) ois.readObject();
            int maxID = 0;
            for (Task task : tasks.getTasks()) {
                if (task.getId() > maxID) maxID = task.getId();
            }
            Task.setID(++maxID);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            tasks = new Taskbook();
        }
        return tasks;
    }
}