package seedu.address.model.event;

import seedu.address.logic.parser.exceptions.ParseException;

public enum EventRecurrence {
    DAILY("daily", "FREQ=DAILY;INTERVAL=1"),
    WEEKLY("weekly", "FREQ=WEEKLY;INTERVAL=1"),
    NONE("none", "FREQ=YEARLY;INTERVAL=1");

    private String recurrenceString;
    private String vEventRecurRule;

    EventRecurrence(String recurrenceString, String vEventRecurRule) {
        this.recurrenceString = recurrenceString;
        this.vEventRecurRule = vEventRecurRule;
    }

    /**
     * Given a string input, checks if it matches any Recurrence type.
     * String input will be compared to the filed recurrenceString.
     * @throws ParseException if no matching EventRecurrence can be found.
     */
    public static EventRecurrence checkWhichRecurrence(String input) throws ParseException {
        assert input != null;
        String formattedInput = input.trim().toLowerCase();

        for (EventRecurrence type: EventRecurrence.values()) {
            if (type.recurrenceString.equals(formattedInput)) {
                return type;
            }
        }
        throw new ParseException("Event recurrence is incorrect");
    }

    /**
     * Given a string input, checks which recurrence rule it refers to.
     * @return EventRecurrence with the matching rule
     * @throws ParseException if no matching recurrence rule can be found.
     */
    public static EventRecurrence checkWhichRecurRule(String input) throws ParseException {
        assert input != null;
        for (EventRecurrence type: EventRecurrence.values()) {
            if (type.vEventRecurRule.equals(input)) {
                return type;
            }
        }
        throw new ParseException("Recurrence rule is incorrect");
    }

    public String getvEventRecurRule() {
        return this.vEventRecurRule;
    }
}
