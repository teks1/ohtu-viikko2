package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    Statistics stats;
    private List<Player> players;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
        players = readerStub.getPlayers();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
        assertEquals(5, players.size());
    }

    @Test
    public void testSearchWithWrongName() {
        Player player = stats.search("Pentti");
        assertEquals(null, player);
    }

    @Test
    public void testSearchWithCorrectName() {
        Player player = stats.search("Kurri");
        assertEquals("Kurri", player.getName());
    }

    @Test
    public void testPlayersOfTeam() {
        List<Player> playersOfTeam = stats.team("EDM");
        assertEquals(3, playersOfTeam.size());
    }

    @Test
    public void testTopScorers() {
        List<Player> topScorers = stats.topScorers(30);
        assertEquals("Gretzky", topScorers.get(0).getName());
    }

    @Test
    public void testTopScorers2() {
        List<Player> topScorers = stats.topScorers(3);
        assertEquals("Gretzky", topScorers.get(0).getName());
    }
}
