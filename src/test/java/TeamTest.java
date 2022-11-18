import org.example.FootballPlayer;
import org.example.Team;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeamTest {
    private static Team team;

    @BeforeAll
    static void setup() {
        List<String> nameList1 = Arrays.asList("John", "Benji", "Alex", "Henry", "Nick", "Mike", "Alon", "Ron");
        team = new Team(nameList1, 1, 4, 4, 2);
    }

    @Test
    void team_hasUniqueJersey() {
        List<Integer> jerseyList = team.getFootballPlayers().stream().map(FootballPlayer::getJersey).collect(Collectors.toList());
        Set<Integer> jerseySet = new HashSet<>(jerseyList);
        assertEquals(jerseySet.size(), jerseyList.size(), "The jerseys are not unique");
    }

    @Test
    void team_CheckGrade0To10() {
        List<Integer> gradeList = team.getFootballPlayers().stream().map(FootballPlayer::getGrade).collect(Collectors.toList());
        int min = -1; // default
        int max = 1000; // default
        if (gradeList.size() > 0) {
            min = Collections.min(gradeList);
            max = Collections.max(gradeList);
        }
        assertTrue(min >= 0 && min <= 10 && max >= 0 && max <= 10, "The grades must be between 0 to 10");
    }


//
//    // write to file
//    public void write(String fileName, List<FigureGeneral> figuresList) {
//        try {
//            Writer out = new FileWriter(new File(fileName).getAbsoluteFile());
//            write(out, figuresList);
//        } catch (IOException e) {
//            System.out.println("Cannot write to file!");
//        }
//    }

//
//    public void writeToFile(String name){
//        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/" + name +"TeamData.txt");
//             ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)) {
//            oos.writeObject(this.footballPlayers.toString());
//        } catch (FileNotFoundException ex) {
//            System.out.println("There was an error - FileNotFoundException");
//        } catch (IOException ex) {
//            System.out.println("There was an error - IOException");
//        }
//    }




//    @VisibleForTesting void write(FileOutputStream fileOutputStream , List<FootballPlayer> figuresList) {
//        try ( fileOutputStream = new FileOutputStream("src/main/resources/" + name +"TeamData.txt");
//             ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)) {
//            oos.writeObject(this.footballPlayers.toString());
//        } catch (FileNotFoundException ex) {
//            System.out.println("There was an error - FileNotFoundException");
//        } catch (IOException ex) {
//            System.out.println("There was an error - IOException");
//        }
//    }

//    @Test public void testWrite() {
//        List<FigureGeneral> list = Lists.newArrayList();
//        list.add(...); // A
//        list.add(...); // B
//        list.add(...); // C
//        StringWriter stringWriter = new StringWriter();
//        write(stringWriter, list);
//        assertEquals("A.\nB.\nC.\n", stringWriter.toString());
//    }


//    @VisibleForTesting void write(Writer writer, List<FigureGeneral> figuresList) {
//        PrintWriter out = new PrintWriter(writer);
//        try {
//            for (int i = 0; i < figuresList.size(); i++) {
//                out.println(figuresList.get(i).toString());
//            }
//        } finally {
//            out.close();
//        }
//    }
//
//    @Test public void testWrite() {
//        List<FigureGeneral> list = Lists.newArrayList();
//        list.add(...); // A
//        list.add(...); // B
//        list.add(...); // C
//        StringWriter stringWriter = new StringWriter();
//        write(stringWriter, list);
//        assertEquals("A.\nB.\nC.\n", stringWriter.toString());
//    }

}
