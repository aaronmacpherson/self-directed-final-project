package com.example.game_shelf.models;

import com.example.game_shelf.annotations.AchievementsValid;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@AchievementsValid
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @Size(max = 200, message = "Notes must not exceed 200 characters")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "status_id")
    @NotNull(message = "Status is mandatory")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    @NotNull(message = "Priority is mandatory")
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "platform_id")
    @NotNull(message = "Platform is mandatory")
    private Platform platform;

    @PositiveOrZero (message = "Earned achievements must not be negative")
    private int achievementsEarned;

    @PositiveOrZero (message = "Total achievements must not be negative")
    private int achievementsTotal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public int getAchievementsEarned() {
        return achievementsEarned;
    }

    public void setAchievementsEarned(int achievementsEarned) {
        this.achievementsEarned = achievementsEarned;
    }

    public int getAchievementsTotal() {
        return achievementsTotal;
    }

    public void setAchievementsTotal(int achievementsTotal) {
        this.achievementsTotal = achievementsTotal;
    }

    public double calculateAchievementPercent() {
        return (double) this.achievementsEarned / this.achievementsTotal * 100;
    }
}
