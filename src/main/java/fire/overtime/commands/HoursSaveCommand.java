package fire.overtime.commands;

import fire.overtime.models.Enums.HourType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class HoursSaveCommand {
    private Integer firefighterId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer monthId;
    private int factHours;
    private HourType hoursType;

    public HoursSaveCommand() {
    }
}

