package org.utils;
import java.time.LocalDate;

public abstract class Participant {
    public abstract void Vote(VoteOptions vo);

    public abstract void book();

    public abstract void getAvailableItems(LocalDate startDate, LocalDate endDate);
}
