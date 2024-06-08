import java.util.*;

public class SimulationDriver {
    public static void main(String[] args) {
        List<String> candidateAns = Arrays.asList("A", "B", "C", "D");
        int studentNum = 10; // can change

        // create a multiple choice question
        Question mcq = new Question(1, candidateAns);
        VotingService mcqVS = new VotingService(mcq);

        // create a single choice question
        Question scq = new Question(2, candidateAns);
        VotingService scqVS = new VotingService(scq);

        // create some students
        List<Student> mcqStudents = generateStudents(studentNum, mcq);
        List<Student> scqStudents = generateStudents(studentNum, scq);

        // simulate submission for each student and show results
        // MCQ
        for (Student student : mcqStudents) {
            mcqVS.submitAnswer(student);
        }
        System.out.println("Polling Results (MCQ): ");
        mcqVS.displayResults();

        // SCQ
        for (Student student : scqStudents) {
            scqVS.submitAnswer(student);
        }
        System.out.println("Polling Results (SCQ): ");
        scqVS.displayResults();
    }

    // Generate students with random ids and answers
    private static List<Student> generateStudents(int n, Question q) {
        List<Student> students = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            String id = "Student" + r.nextInt(3);
            List<String> answers = new ArrayList<>();

            if (q.getType() == 1) { // if question is MCQ
                // generate a random number of answers for each student
                int totalAns = r.nextInt(q.getCandidateAnswers().size()) + 1; // random amount
                Set<String> uniqueAns = new HashSet<>();

                // pick answers randomly until amount is met
                while (uniqueAns.size() < totalAns) {
                    uniqueAns.add(q.getCandidateAnswers().get(r.nextInt(q.getCandidateAnswers().size())));
                }

                answers.addAll(uniqueAns);
            } else {
                // pick one answer randomly for SCQ
                answers.add(q.getCandidateAnswers().get(r.nextInt(q.getCandidateAnswers().size())));
            }

            students.add(new Student(id, answers));
        }

        return students;
    }
}
