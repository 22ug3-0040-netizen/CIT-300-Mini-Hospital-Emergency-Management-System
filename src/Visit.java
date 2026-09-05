public class Visit {

    private int patientId;
    private int visitId;
    private String date;
    private String doctor;
    private String diagnosis;
    private String treatment;

    public Visit(int patientId, int visitId, String date,
                 String doctor, String diagnosis, String treatment) {

        this.patientId = patientId;
        this.visitId = visitId;
        this.date = date;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getVisitId() {
        return visitId;
    }

    public String getDate() {
        return date;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
               ", Visit ID: " + visitId +
               ", Date: " + date +
               ", Doctor: " + doctor +
               ", Diagnosis: " + diagnosis +
               ", Treatment: " + treatment;
    }
}