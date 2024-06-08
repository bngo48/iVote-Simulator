import java.util.HashMap;
import java.util.Map;

public class VotingService {
    private Question question;
    private Map<String, Integer> answerCount;   // frequency of student answer

    public VotingService(Question question) {
        this.question = question;
        this.answerCount = new HashMap<>();
        
        // start with 0 frequency for every answer
        for (String answer : question.getCandidateAnswers()) {
            answerCount.put(answer, 0);
        }
    }

    // only collect the last answer submitted by student    
    public void submitAnswer(Student student) {
        for (String answer : student.getAnswer()) {
            answerCount.put(answer, answerCount.getOrDefault(answer, 0) + 1);
        }
    }

    // show polling results
    public void displayResults() {
        for (Map.Entry<String, Integer> entry : answerCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
