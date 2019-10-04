package is.hi.hbv503.FitnessTracker.FitnessTracker.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    private Double duration;
    private Double durationSum;

    public Exercise(){
    }

    public Exercise(String title, String description, Double duration,Double durationSum) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.durationSum = durationSum;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }


    public Double getDurationSum() {
        return durationSum;
    }

    public void setDurationSum(Double durationSum) {
        this.durationSum += this.getDuration();
    }
}

