import org.example.FootballPlayer;
import org.example.Posiotion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FootballPlayerTest {

    @Test
    void player_isDefender() {
        FootballPlayer footballPlayer = FootballPlayer.defenderPlayer(1, 7, "Adam");
        assertEquals(Posiotion.DEFENDER, footballPlayer.getPosition());
    }

    @Test
    void player_isAttacker() {
        FootballPlayer footballPlayer = FootballPlayer.attackPlayer(1, 7, "Adam");
        assertEquals(Posiotion.ATTACKER, footballPlayer.getPosition());
    }

    @Test
    void player_isGoalkeeper() {
        FootballPlayer footballPlayer = FootballPlayer.goalKeeperPlayer(1, 7, "Adam");
        assertEquals(Posiotion.GOALKEEPER, footballPlayer.getPosition());
    }

    @Test
    void player_isMidfielder() {
        FootballPlayer footballPlayer = FootballPlayer.midfieldPlayer(1, 7, "Adam");
        assertEquals(Posiotion.MIDFIELDER, footballPlayer.getPosition());
    }

}
