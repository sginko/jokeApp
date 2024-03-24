package pl.akademiaspecjalistowit.jokeapp.repository;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class FileJokeRepository implements JokeRepository {
    private Map<String, List<Joke>> jokes;

    @Override
    public List<Joke> getAllJokes() {
        return this.jokes.entrySet().stream()
                .flatMap(entry-> entry.getValue().stream())
                .toList();
    }

//    public Map<String, List<Joke>> getJokeFromFile() {
//        Path filePathVisits = Path.of("jokes.txt");
//        Map<String, List<Joke>> mapJokes = new HashMap<>();
//        List<Joke> visits = new ArrayList<>();
//        try {
//            List<String> lines = Files.readAllLines(filePathVisits);
//
//            for (String line : lines) {
//                String[] strings = line.split(";");
//                LocalDate date = LocalDate.parse(strings[0].trim());
//                int id = Integer.parseInt(strings[1].trim());
//                LocalTime time = LocalTime.parse(strings[2].trim());
//                UUID idDoctor = UUID.fromString(strings[3].trim());
//                String idPatient = strings[4].trim();
//                if (idPatient.equals("-")) {
//                    Visit visit = new Visit(date, time, getDoctorFromId(idDoctor), null);
//                    visits.add(visit);
//                    VisitServiceImpl.pasteToListVisits(visit, mapVisit);
//                } else {
//                    UUID idPatient2 = UUID.fromString(idPatient);
//                    Visit visit = new Visit(date, time, getDoctorFromId(idDoctor), getPatientFromId(idPatient2));
////                Visit visit = new Visit(date, time, getDoctorFromId(idDoctor), idPatient2.equals("-") ? null : getPatientFromId(idPatient));
//                    visits.add(visit);
//                    VisitServiceImpl.pasteToListVisits(visit, mapVisit);
//                }
//
//            }
//            Visit.countVisits = visits.size() + 1;
//        } catch (IOException e) {
//            System.out.println("Error. Cannot read file");
//        }
//        return mapVisit;
//    }

    private List<Joke> getJokeFromFile() {
        Path filePathUsers = Path.of("jokess.txt");
        List<Joke> jokes = new ArrayList<>();
        List<String> lines = null;
        try {
            lines = Files.readAllLines(filePathUsers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String line : lines) {
            String[] strings = line.split(";");
            UUID id = UUID.fromString(strings[0].trim());
            String content = strings[1].trim();
            Joke joke = new Joke(id, content);
            jokes.add(joke);
        }
        return jokes;
    }
}
