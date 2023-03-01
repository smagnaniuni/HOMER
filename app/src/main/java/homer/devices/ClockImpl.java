package homer.devices;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

import homer.api.Clock;

public final class ClockImpl implements Clock {

    private LocalDateTime dateTime = LocalDateTime.now();

    @Override
    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    @Override
    public void setDateTime(final LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public void updateTick(final TemporalAmount deltaTime) {
        this.dateTime = this.dateTime.plus(deltaTime);
    }

}
