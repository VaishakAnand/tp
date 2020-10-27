package seedu.address.ui;

import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.student.Student;
import seedu.address.model.student.academic.Attendance;
import seedu.address.model.student.question.Question;

/**
 * An UI component that displays information of a {@code Student}.
 */
public class StudentCard extends UiPart<Region> {

    private static final String FXML = "StudentListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Student student;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label school;
    @FXML
    private Label year;
    @FXML
    private Label venue;
    @FXML
    private Label time;
    @FXML
    private Label fee;
    @FXML
    private Label payment;
    @FXML
    private Label details;
    @FXML
    private Label questions;
    @FXML
    private Label exams;


    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public StudentCard(Student student, int displayedIndex) {
        super(FXML);
        this.student = student;
        id.setText(displayedIndex + ". ");
        name.setText(student.getName().fullName);
        phone.setText("Phone: " + student.getPhone().value);
        school.setText("School: " + student.getSchool().school);
        year.setText("Year: " + student.getYear());
        venue.setText("Class Venue: " + student.getAdmin().getClassVenue().venue);
        time.setText("Class Time: " + student.getAdmin().getClassTime().toString());
        fee.setText("Fee: " + student.getAdmin().getFee().toString());
        payment.setText("Last Payment Date: " + student.getAdmin().getPaymentDate().toString());
        details.setText("Additional Details: \n" + student.getAdmin().getFormattedDetails());
        questions.setText("Questions:\n" + student.getQuestions()
                .stream()
                .map(Question::toString)
                .collect(Collectors.joining("\n")));
        exams.setText("Examinations: \n" + student.getFormattedExams());
        questions.setVisible(!student.getQuestions().isEmpty());
//        attendance.setText("Attendance:\n" + student.getAttendance()
//        .stream()
//        .map(Attendance::toString)
//        .collect(Collectors.joining("\n")));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof StudentCard)) {
            return false;
        }

        // state check
        StudentCard card = (StudentCard) other;
        return id.getText().equals(card.id.getText())
                && student.equals(card.student);
    }
}
