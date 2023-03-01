package homer.devices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import homer.api.Clock;

class TestClockImpl {

    private Clock clock;

    @BeforeEach
    void createClock() {
        this.clock = new ClockImpl();
        assertNotNull(this.clock);
    }

    @Test
    void testGetTime() {
        assertNotNull(this.clock.getDateTime());
    }

    @Test
    void testSetTime() {
        final LocalDateTime newDateTime = LocalDateTime.now();
        this.clock.setDateTime(newDateTime);
        assertEquals(this.clock.getDateTime(), newDateTime);
    }

    @Test
    void testUpdateTick() {
        final LocalDateTime currentDateTime = this.clock.getDateTime();
        final TemporalAmount deltaTime = Duration.ofSeconds(1);
        this.clock.updateTick(deltaTime);
        assertEquals(this.clock.getDateTime(), currentDateTime.plus(deltaTime));
    }

}
