package seedu.address.logic.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.ScheduleCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

/**
 * Parses input arguments and creates a new ScheduleCommand object
 */
public class ScheduleCommandParser implements Parser<ScheduleCommand> {

    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("d/MM/yyyy");

    /**
     * Parses the given {@code userInputDate} to a LocalDate object
     * and returns a ScheduleCommand with the LocalDate object for execution.
     * @throws ParseException if the user input does not conform the expected date format
     * and the input is an empty string
     */
    @Override
    public ScheduleCommand parse(String userInputDate) throws ParseException {
        requireNonNull(userInputDate);
        String trimmedUserInput = userInputDate.trim();

        // check to see if input string is empty
        if (trimmedUserInput.isBlank()) {
            throw new ParseException(ScheduleCommand.EMPTY_DATE_MESSAGE);
        }

        try {
            LocalDate date = LocalDate.parse(trimmedUserInput, INPUT_FORMAT);
            return new ScheduleCommand(date);
        } catch (DateTimeParseException e) {
            throw new ParseException(ScheduleCommand.INCORRECT_DATE_FORMAT);
        }
    }
}
