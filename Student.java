import java.util.List;

public class Student {
    private String id;
    private List<String> answer;

    public Student(String id, List<String> answer) {
        this.id = id;
        this.answer = answer;
    }

    public String getID() {
        return id;
    }

    public List<String> getAnswer() {
        return answer;
    }
}
