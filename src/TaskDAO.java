import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TaskDAO {

    public void addTask(String title) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO tasks(title) VALUES(?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);

            ps.executeUpdate();

            System.out.println("Task Added!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewTasks() {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM tasks";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- TASK LIST ---");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("title") + " | " +
                    rs.getString("status")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void markCompleted(int id) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE tasks SET status='Completed' WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Task marked completed!");
            else
                System.out.println("Task not found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(int id) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM tasks WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Task deleted!");
            else
                System.out.println("Task not found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
