package HomeWork.TaskBook.Core.Models.FileMod;

import HomeWork.TaskBook.Core.Infrostructure.Taskbook;
import HomeWork.TaskBook.Core.Models.Task;

import java.io.FileWriter;
import java.io.IOException;

/*
To export data to CSV
 */
public class ExportCSV extends WorkWithFiles implements IExport {

    public ExportCSV(String path, Taskbook taskbook) {
        super(path, taskbook);
    }

    public ExportCSV(Taskbook taskbook) {
        super("exportData.csv", taskbook);
    }

    @Override
    public void exportTo() {

        try (FileWriter writer = new FileWriter(getPath(), false)) {
            String headers = "id;CreateDate;DeadLine;Author;TaskText;Priority\n";
            writer.write(headers);
            for (Task tsk : getTaskbook().getTasks()) {
                writer.write(tsk.toString());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}