import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskDAO dao = new TaskDAO();

        while (true) {

            System.out.println("\n=== Student Task Manager ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Task: ");
                    String task = sc.nextLine();
                    dao.addTask(task);
                    break;

                case 2:
                    dao.viewTasks();
                    break;

                case 3:
                    System.out.print("Enter Task ID to mark completed: ");
                    int id1 = sc.nextInt();
                    dao.markCompleted(id1);
                    break;

                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int id2 = sc.nextInt();
                    dao.deleteTask(id2);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
