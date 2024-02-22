package com.diary.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate date;
    private String icon;
    private String weather;
    private double temp;

    public void seatDateInfo(Weather weather) {
        this.weather = weather.getWeather();
        this.icon = weather.getIcon();
        this.temp = weather.getTemp();
        this.date = weather.getDate();
    }

}
