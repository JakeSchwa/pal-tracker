package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private List<TimeEntry> timeEntryList = new ArrayList<>();
    private long lastId = 0;

    private TimeEntry create(long id, TimeEntry timeEntry) {
        TimeEntry createdTimeEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());

        timeEntryList.add(createdTimeEntry);
        return createdTimeEntry;
    }

    public TimeEntry create(TimeEntry timeEntry) {
        lastId++;
        return create(lastId, timeEntry);
    }

    public TimeEntry find(long id) {
        return timeEntryList.stream().filter(entry -> entry.getId() == id).findAny().orElse(null);
    }

    public List<TimeEntry> list() {
        return timeEntryList;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry existingEntry = find(id);
        if(existingEntry == null) return null;

        delete(id);
        return create(id, timeEntry);
    }

    public void delete(long id) {
       timeEntryList = timeEntryList.stream().filter(entry -> entry.getId() != id).collect(Collectors.toList());
    }
}
