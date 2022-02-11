package com.example.demo.domain.title;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "titles")
public class Title {
    @Id
    private Long empNo;

    private String title;

    private LocalDate fromDate;

    private LocalDate toDate;
}
