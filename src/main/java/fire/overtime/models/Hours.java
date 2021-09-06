package fire.overtime.models;

import fire.overtime.models.Enums.HourType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hours")
public class Hours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hoursId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "firefighter_id")
    private Firefighter firefighter;

    @Column(name = "firefighter_id", insertable = false, updatable = false)
    private Integer firefighterId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "month_year_id")
    private Month month;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "fact_hours")
    private Integer factHours;

    @Column(name = "hours_type")
    @Enumerated(EnumType.STRING)
    private HourType hoursType;

    public Integer getId() {
        return hoursId;
    }

    public void setId(Integer hoursId) {
        this.hoursId = hoursId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getFactHours() {
        return factHours;
    }

    public void setFactHours(int factHours) {
        this.factHours = factHours;
    }

    public HourType getHoursType() {
        return hoursType;
    }

    public void setHoursType(HourType hoursType) {
        this.hoursType = hoursType;
    }

    public Firefighter getFirefighter() {
        return firefighter;
    }

    public void setFirefighter(Firefighter firefighter) {
        this.firefighter = firefighter;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Integer getFirefighterId() {
        return firefighterId;
    }

    public void setFirefighterId(Integer firefighterId) {
        this.firefighterId = firefighterId;
    }
}

