package edu.alexandrov.labs.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "time_table")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_table_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time_table_manager_id")
    private TimeTableManager timeTableManager;

    @OneToMany(mappedBy = "timeTable", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lesson> lessons;

    @Column
    private String dayOfWeek;

    @Column
    private String dayOfWeekRus;
}
