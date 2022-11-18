import org.example.Team;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TeamConstructorTest {

    @Test
    void team_hasProperStructureMoreThenOneGoalKeeper_ThrowException() {
        List<String> nameList1 = Arrays.asList("John", "Benji", "Alex", "Henry", "Nick", "Mike", "Alon", "Ron");

        InvalidParameterException thrown = assertThrows(
                InvalidParameterException.class,
                () -> {
                    Team team = new Team(nameList1, 2, 3, 4, 2);
                },
                "Expected to throw \"Position error\", but it didn't"
        );
        assertTrue(thrown.getMessage().contains("Position error"));
    }

    @Test
    void team_hasProperStructureLessThen2defenders_ThrowException() {
        List<String> nameList1 = Arrays.asList("John", "Benji", "Alex", "Henry", "Nick", "Mike", "Alon", "Ron");
        InvalidParameterException thrown = assertThrows(
                InvalidParameterException.class,
                () -> {
                    Team team = new Team(nameList1, 1, 1, 4, 2);
                },
                "Expected to throw \"Position error\", but it didn't"
        );
        assertTrue(thrown.getMessage().contains("Position error"));
    }

    @Test
    void team_hasProperStructureLessThen2Attackers_ThrowException() {
        List<String> nameList1 = Arrays.asList("John", "Benji", "Alex", "Henry", "Nick", "Mike", "Alon", "Ron");
        InvalidParameterException thrown = assertThrows(
                InvalidParameterException.class,
                () -> {
                    Team team = new Team(nameList1, 1, 4, 4, 1);
                },
                "Expected to throw \"Position error\", but it didn't"
        );
        assertTrue(thrown.getMessage().contains("Position error"));
    }

    @Test
    void team_hasProperStructureLessThen2MiddleFielder_ThrowException() {
        List<String> nameList1 = Arrays.asList("John", "Benji", "Alex", "Henry", "Nick", "Mike", "Alon", "Ron");
        InvalidParameterException thrown = assertThrows(
                InvalidParameterException.class,
                () -> {
                    Team team = new Team(nameList1, 1, 4, 1, 2);
                },
                "Expected to throw \"Position error\", but it didn't"
        );
        assertTrue(thrown.getMessage().contains("Position error"));
    }

    @Test
    void team_hasNot11Players_ThrowException() {
        List<String> nameList1 = Arrays.asList("John", "Benji", "Alex", "Henry", "Nick", "Mike", "Alon", "Ron");
        InvalidParameterException thrown = assertThrows(
                InvalidParameterException.class,
                () -> {
                    Team team = new Team(nameList1, 1, 4, 1, 2);
                },
                "Expected to throw \"Position error\", but it didn't"
        );
        assertTrue(thrown.getMessage().contains("Position error"));
    }


    @Test
    void team_emptyConstructor_ThrowException() {
        UnsupportedOperationException thrown = assertThrows(
                UnsupportedOperationException.class,
                () -> {
                    Team team = new Team();
                },
                "Expected to throw \"not supported empty constructor\", but it didn't"
        );
        assertTrue(thrown.getMessage().contains("not supported empty constructor"));
    }

}
