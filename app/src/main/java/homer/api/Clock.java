package homer.api;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

public interface Clock {

    LocalDateTime getTime();

    void setTime(LocalDateTime dateTime);

    void updateTick(TemporalAmount dt);

}
