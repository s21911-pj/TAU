import org.example.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TankTest {
    private Tank tank;
    private Engine engine;
    private Caterpillars caterpillars;
    private Fire fire;
    private Enemy enemy;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {
        engine = Mockito.mock(Engine.class);
        fire = Mockito.mock(Fire.class);
        caterpillars = Mockito.mock(Caterpillars.class);
        enemy = Mockito.mock(Enemy.class);

        tank = new Tank(caterpillars, enemy, fire, engine);
    }

    @Test
    public void isEnemySpotted() {
        when(enemy.enemySpotted()).thenReturn(true);
        assertEquals(true, enemy.enemySpotted());

        when(enemy.enemySpotted()).thenReturn(false);
        assertEquals(false, enemy.enemySpotted());
    }

    @Test
    public void isRunning() {
        when(engine.isRunning()).thenReturn(true);
        assertEquals(true, tank.isRunning());

        when(engine.isRunning()).thenReturn(false);
        assertEquals(false, tank.isRunning());
    }


    @Test
    public void start() {
        when(engine.isRunning()).thenReturn(false, true);
        tank.start();
    }

    @Test
    public void start_with_caterpillars_broken() {

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Started engine but isn't running");
        when(engine.isRunning()).thenReturn(false);
        when(caterpillars.repair()).thenReturn(true);
        tank.start();
    }

    @Test
    public void start_IsRunning() {

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Engine already running");
        when(caterpillars.repair()).thenReturn(true);
        when(engine.isRunning()).thenReturn(true);
        tank.start();
    }

    @Test
    public void start_DidNotStart() {
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Started engine but isn't running");
        when(engine.isRunning()).thenReturn(false, false);
        when(caterpillars.broken()).thenReturn(false);
        tank.start();
    }
}