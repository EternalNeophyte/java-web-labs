package edu.alexandrov.labs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "lesson")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time_table_id")
    private TimeTable timeTable;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String lector;

    @Column
    private String audienceNumber;

    @Column
    private LocalTime startTime;

    @Column
    private LocalTime endTime;

    @Column
    private boolean isRemote;

}
