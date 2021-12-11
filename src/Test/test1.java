package Test;

public class test1 {
    public static void main(String[] args) {
        try {
            throw new Exception("JDBC查询出现错误！！！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
