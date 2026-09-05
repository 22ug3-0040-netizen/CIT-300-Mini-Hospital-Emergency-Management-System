import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HospitalManagementSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PatientBST patientBST = new PatientBST();
        PatientQueue emergencyQueue = new PatientQueue();
        TreatmentStack treatmentStack = new TreatmentStack();

        // Separate visit history for each patient
        Map<Integer, PatientVisitHistory> patientVisitHistories = new HashMap<>();

        int choice;

        do {
            System.out.println("\n===== MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display Patients");
            System.out.println("5. Add Patient to Emergency Queue");
            System.out.println("6. Serve Emergency Patient");
            System.out.println("7. Display Emergency Queue");
            System.out.println("8. Add Treatment History");
            System.out.println("9. Remove Recent Treatment");
            System.out.println("10. Display Treatment History");
            System.out.println("11. Add Patient Visit");
            System.out.println("12. Search Patient Visit");
            System.out.println("13. Remove Patient Visit");
            System.out.println("14. Display Patient Visit History");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String contact = scanner.nextLine();

                    System.out.print("Enter Medical Condition: ");
                    String condition = scanner.nextLine();

                    Patient patient = new Patient(
                            id, name, age, contact, condition
                    );

                    patientBST.insert(patient);
                    System.out.println("Patient added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Patient ID to search: ");
                    int searchId = scanner.nextInt();

                    Patient foundPatient = patientBST.search(searchId);

                    if (foundPatient != null) {
                        System.out.println("Patient found:");
                        System.out.println(foundPatient);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Patient ID to delete: ");
                    int deleteId = scanner.nextInt();

                    patientBST.delete(deleteId);
                    System.out.println("Delete operation completed.");
                    break;

                case 4:
                    patientBST.displayInOrder();
                    break;

                case 5:
                    System.out.print("Enter Patient ID: ");
                    int queueId = scanner.nextInt();

                    Patient queuePatient = patientBST.search(queueId);

                    if (queuePatient != null) {
                        emergencyQueue.enqueue(queuePatient);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 6:
                    Patient servedPatient = emergencyQueue.dequeue();

                    if (servedPatient != null) {
                        System.out.println("Served Patient:");
                        System.out.println(servedPatient);
                    }
                    break;

                case 7:
                    emergencyQueue.displayQueue();
                    break;

                case 8:
                    System.out.print("Enter Treatment: ");
                    String treatment = scanner.nextLine();

                    treatmentStack.pushTreatment(treatment);
                    break;

                case 9:
                    String removedTreatment = treatmentStack.popTreatment();

                    if (removedTreatment != null) {
                        System.out.println("Removed Treatment: " + removedTreatment);
                    }
                    break;

                case 10:
                    treatmentStack.displayHistory();
                    break;

                case 11:
                    System.out.print("Enter Patient ID: ");
                    int visitPatientId = scanner.nextInt();

                    // Check whether patient exists
                    Patient visitPatient = patientBST.search(visitPatientId);

                    if (visitPatient == null) {
                        System.out.println("Patient not found.");
                        break;
                    }

                    scanner.nextLine();

                    System.out.print("Enter Visit ID: ");
                    int visitId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Date: ");
                    String date = scanner.nextLine();

                    System.out.print("Enter Doctor: ");
                    String doctor = scanner.nextLine();

                    System.out.print("Enter Diagnosis: ");
                    String diagnosis = scanner.nextLine();

                    System.out.print("Enter Treatment: ");
                    String visitTreatment = scanner.nextLine();

                    Visit visit = new Visit(
                            visitPatientId,
                            visitId,
                            date,
                            doctor,
                            diagnosis,
                            visitTreatment
                    );

                    // Create a separate linked list for this patient
                    if (!patientVisitHistories.containsKey(visitPatientId)) {
                        patientVisitHistories.put(
                                visitPatientId,
                                new PatientVisitHistory()
                        );
                    }

                    patientVisitHistories
                            .get(visitPatientId)
                            .addVisit(visit);

                    break;

                case 12:
                    System.out.print("Enter Patient ID: ");
                    int searchVisitPatientId = scanner.nextInt();

                    if (!patientVisitHistories.containsKey(searchVisitPatientId)) {
                        System.out.println("Visit history is empty.");
                        break;
                    }

                    System.out.print("Enter Visit ID to search: ");
                    int searchVisitId = scanner.nextInt();

                    Visit foundVisit = patientVisitHistories
                            .get(searchVisitPatientId)
                            .searchVisit(searchVisitId);

                    if (foundVisit != null) {
                        System.out.println("Visit found:");
                        System.out.println(foundVisit);
                    } else {
                        System.out.println("Visit not found.");
                    }
                    break;

                case 13:
                    System.out.print("Enter Patient ID: ");
                    int removeVisitPatientId = scanner.nextInt();

                    if (!patientVisitHistories.containsKey(removeVisitPatientId)) {
                        System.out.println("Visit history is empty.");
                        break;
                    }

                    System.out.print("Enter Visit ID to remove: ");
                    int removeVisitId = scanner.nextInt();

                    patientVisitHistories
                            .get(removeVisitPatientId)
                            .removeVisit(removeVisitId);

                    break;

                case 14:
                    System.out.print("Enter Patient ID: ");
                    int displayVisitPatientId = scanner.nextInt();

                    if (!patientVisitHistories.containsKey(displayVisitPatientId)) {
                        System.out.println("Visit history is empty.");
                        break;
                    }

                    patientVisitHistories
                            .get(displayVisitPatientId)
                            .displayVisits();

                    break;

                case 0:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}