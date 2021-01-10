package org.kaelbastos.Domain.entities.Worker;

import org.kaelbastos.Domain.entities.utils.Notification;
import org.kaelbastos.Domain.entities.utils.Validator;

import java.time.LocalDateTime;

public class DayOfWeekRestrictionValidator extends Validator<DayOfWeekRestriction> {
    @Override
    public Notification validate(DayOfWeekRestriction dayOfWeekRestriction) {
        Notification notification = new Notification();

        if(isNotNull(dayOfWeekRestriction)){

            LocalDateTime dayOfWeekRestrictionStart = dayOfWeekRestriction.getStart();
            LocalDateTime dayOfWeekRestrictionEnd = dayOfWeekRestriction.getEnd();

            if(isNotNull(dayOfWeekRestrictionStart) && isNotNull(dayOfWeekRestrictionEnd)){
                if(dayOfWeekRestrictionStart.isAfter(dayOfWeekRestrictionEnd))
                    notification.addError("Start is after end.");
                if(dayOfWeekRestrictionStart.equals(dayOfWeekRestrictionEnd))
                    notification.addError("Start and end are at the same time.");
            } else {
                notification.addError("Start and/or end are null.");
            }
        } else {
            notification.addError("Day of week restriction is null.");
        }

        return notification;
    }
}
