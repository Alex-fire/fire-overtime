package fire.overtime.repositories;

import fire.overtime.models.Enums.HourType;
import fire.overtime.models.Hours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface HoursRepository extends JpaRepository<Hours, Integer> {

    @Query("select h from Hours h where h.firefighter.id=:firefighterId and h.month.id= :monthYearId")
    List<Hours> getHours(@Param("firefighterId") Integer firefighterId, @Param("monthYearId") Integer monthYearId);

    List<Hours> getHoursByFirefighterIdAndMonthIdAndHoursType(Integer firefighterId,
                                                              Integer monthYearId, HourType hoursType);

    List<Hours> getHoursByFirefighterIdAndMonth_YearAndHoursType(
            Integer firefighterId, int year, HourType hoursType);

    void deleteByFirefighterIdAndStartDate(Integer firefighterId, LocalDate startDate);

    Hours getHoursByStartDateAndFirefighterId(LocalDate startDate, Integer firefighterId);

    List<Hours> getHoursByFirefighterId(Integer firefighterId);

}
