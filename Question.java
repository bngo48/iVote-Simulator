import java.util.List;

public class Question {
    private int type;   // 1-MCQ, 2-SCQ
    private List<String> candidateAnswers;

    public Question(int type, List<String> candidateAnswers) {
        this.type = type;
        this.candidateAnswers = candidateAnswers;
    }

    public int getType() {
        return type;
    }

    public List<String> getCandidateAnswers() {
        return candidateAnswers;
    }
}

