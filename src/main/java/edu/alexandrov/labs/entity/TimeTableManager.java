package edu.alexandrov.labs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "time_table_manager")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeTableManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_table_manager_id")
    private int id;

    @OneToMany(mappedBy = "timeTableManager", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TimeTable> timeTables;

    @Column
    private boolean isWeekEven;
}
