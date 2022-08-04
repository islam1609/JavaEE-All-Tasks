/*package JDBCbigTASK.DB;

import JDBCbigTASK.Tasks.Task;

import java.util.ArrayList;

public class DBManager {
   private static Long id = 4l;
    private static ArrayList<Task> allTasks = new ArrayList<>();

    static {
        allTasks.add(new Task(1L, "Homework", "To do homework", "25.05.2022", "done"));
        allTasks.add(new Task(2L, "Clean", "To clean entire house", "23.05.2022", "not yet"));
        allTasks.add(new Task(3L, "Walk with dog", "Walk with dog", "22-05-2022", "done"));
    }

    public static void addTask(Task task) {
        task.setId(id);
        allTasks.add(task);
        id++;
    }

    public static ArrayList<Task> getAllTasks() {
        return allTasks;
    }

    public static Task getTask(Long id) {
        for (Task ts : allTasks) {
            if (id == ts.getId())
                return ts;
        }
            return null;
        }
    public static void deleteTask(Long id) {
        for (Task ts : allTasks) {
            if (id == ts.getId())
                allTasks.remove(ts);
            }
        }
    } */


