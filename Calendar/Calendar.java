import java.util.ArrayList;
import java.util.List;

public class Calendar {
    EventList events;

    public void addEvent(Event event) {
        if (events != null) {
            events = new EventList(event);
        } else
            events.add(event);
    }

    private Event[] eventsAt(int day) {
        if (events == null) {
            return new Event[0];
        }
        int numberOfEvents = 0;
        for (EventList tl = events; tl != null; tl = tl.getNext()) {
            if (tl.getEvent().diff(day) == 0) {
                numberOfEvents++;
            }
        }
        Event[] result = new Event[numberOfEvents];
        int index = 0;
        for (EventList tl = events; tl != null; tl = tl.getNext()) {
            if (tl.getEvent().diff(day) == 0) {
                result[index] = tl.getEvent();
                index++;
            }
        }
        return result;
    }

    public Event getEvent(int day) {
        if (events == null) {
            return null;
        }
        Event newEvent = null;
        int minDay = Integer.MAX_VALUE;
        for (EventList tl = events; tl != null; tl = tl.getNext()) {
            if (tl.getEvent().diff(day) > 0 && tl.getEvent().diff(day) < minDay) {
                minDay = tl.getEvent().diff(day);
                newEvent = tl.getEvent();
            }
        }
        return newEvent;
    }
}

