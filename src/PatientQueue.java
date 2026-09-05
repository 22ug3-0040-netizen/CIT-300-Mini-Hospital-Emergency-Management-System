import java.util.LinkedList;
import java.util.Queue;

public class PatientQueue {

    private Queue<Patient> emergencyQueue;

    public PatientQueue() {
        emergencyQueue = new LinkedList<>();
    }

    public void enqueue(Patient patient) {
        emergencyQueue.add(patient);
        System.out.println("Patient added to emergency queue.");
    }

    public Patient dequeue() {
        if (emergencyQueue.isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patient = emergencyQueue.poll();
        System.out.println("Patient removed from emergency queue.");
        return patient;
    }

    public void displayQueue() {
        if (emergencyQueue.isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return;
        }

        System.out.println("Emergency Patients Waiting:");

        for (Patient patient : emergencyQueue) {
            System.out.println(patient);
        }
    }
}