package HomeWork.TaskBook.Core.Models.FileMod;

import HomeWork.TaskBook.Core.Enums.Priorities;
import HomeWork.TaskBook.Core.Infrostructure.Taskbook;
import HomeWork.TaskBook.Core.Models.Task;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
/*
To import data from CSV
 */
public class ImportCSV extends WorkWithFiles implements IImport {

    public ImportCSV(String path, Taskbook taskbook) {
        super(path, taskbook);
    }

    public ImportCSV(Taskbook taskbook) {
        super("exportData.csv", taskbook);
    }

    @Override
    public void importFrom() {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Path.of(getPath()));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        for (int i = 1; i < lines.size(); i++) {
            List<String> row = List.of(lines.get(i).split(";"));
            Task tskTemp = new Task();
            tskTemp.setDeadline(row.get(2));
            tskTemp.setAuthor(row.get(3));
            tskTemp.setTaskText(row.get(4));
            switch (row.get(5)) {
                case "IMMEDIATE" -> tskTemp.setPriority(Priorities.IMMEDIATE);
                case "MEDIUM" -> tskTemp.setPriority(Priorities.MEDIUM);
                case "LOW" -> tskTemp.setPriority(Priorities.LOW);
            }
            getTaskbook().add(tskTemp);
        }

    }
}