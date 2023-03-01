package homer.api;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

public interface Clock {

    LocalDateTime getDateTime();

    void setDateTime(LocalDateTime dateTime);

    void updateTick(TemporalAmount dt);

}
