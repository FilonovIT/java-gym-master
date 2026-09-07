package ru.yandex.practicum.gym;

import java.util.*;

public class Timetable {

    private Map<String, TreeMap<TimeOfDay, List<TrainingSession>>> timetable = new HashMap<>();

    public Timetable() {
        timetable = new HashMap<>();
        for (DayOfWeek day : DayOfWeek.values()) {
            timetable.put(day.name(), new TreeMap<>());
        }
    }

    public void addNewTrainingSession(TrainingSession trainingSession) {
        //новая тренировка
        //сохраняем занятие в расписании
        DayOfWeek day = trainingSession.getDayOfWeek();
        TimeOfDay time = trainingSession.getTimeOfDay();

        TreeMap<TimeOfDay, List<TrainingSession>> dayShedule = timetable.get(day);

        List<TrainingSession> sessions = dayShedule.get(time);

        if (sessions == null) {
            sessions = new ArrayList<>();
            dayShedule.put(time, sessions);
        }
        sessions.add(trainingSession);
    }

    public List<TrainingSession> getTrainingSessionsForDay(DayOfWeek dayOfWeek) {
        //тренировки за день
        //как реализовать, тоже непонятно, но сложность должна быть О(1)
        TreeMap<TimeOfDay, List<TrainingSession>> dayShedule = timetable.get(dayOfWeek);

        List<TrainingSession> result = new ArrayList<>();

        for (List<TrainingSession> sessions : dayShedule.values()) {
            result.addAll(sessions);
        }
        return result;
    }

    public List<TrainingSession> getTrainingSessionsForDayAndTime(DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {
        //как реализовать, тоже непонятно, но сложность должна быть О(1)
        TreeMap<TimeOfDay, List<TrainingSession>> dayShedule = timetable.get(dayOfWeek);
        List<TrainingSession> sessions = dayShedule.get(timeOfDay);
        return sessions != null ? new ArrayList<>(sessions) : Collections.emptyList();
    }
}
