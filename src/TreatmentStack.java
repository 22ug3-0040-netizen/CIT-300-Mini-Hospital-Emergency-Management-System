import java.util.Stack;

public class TreatmentStack {

    private Stack<String> treatmentHistory;

    public TreatmentStack() {
        treatmentHistory = new Stack<>();
    }

    // Add completed treatment
    public void pushTreatment(String treatment) {
        treatmentHistory.push(treatment);
        System.out.println("Treatment added to history.");
    }

    // Remove the most recent treatment
    public String popTreatment() {
        if (treatmentHistory.isEmpty()) {
            System.out.println("Treatment history is empty.");
            return null;
        }

        String treatment = treatmentHistory.pop();
        System.out.println("Most recent treatment removed.");
        return treatment;
    }

    // Display treatment history
    public void displayHistory() {
        if (treatmentHistory.isEmpty()) {
            System.out.println("Treatment history is empty.");
            return;
        }

        System.out.println("Treatment History:");

        for (String treatment : treatmentHistory) {
            System.out.println(treatment);
        }
    }
}