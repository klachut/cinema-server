package howtoexitvim.cinemaserverproject.show;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import howtoexitvim.cinemaserverproject.seat.Seat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "seats"})
public class Show {

    @Id
    @SequenceGenerator(
            name = "show_sequence",
            sequenceName = "show_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "show_sequence")
    @Column(name = "show_id", nullable = false)
    private Long showId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "show_start", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime showStart;

    @Column(name = "description", nullable = false)
    private String description;
    //Dodatkowe
    @Column(name = "director", nullable = false)
    private String director;

    @Column(name = "scenario", nullable = false)
    private String scenario;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "production", nullable = false)
    private String production;

    @Column(name = "premiere", nullable = false)
    private String premiere ;

    @Column(name = "ratingFromFilmweb", nullable = false)
    private Float ratingFromFilmweb ;

    @Column(name = "criticsRating", nullable = false)
    private Float criticsRating ;

    @Column(name = "pictureName", nullable = false)
    private String pictureName ;

    @Column(name = "trailerLink", nullable = false)
    private String trailerLink ;



    @OneToMany(
            targetEntity=Seat.class,
            cascade=CascadeType.ALL
//            cascade = CascadeType.PERSIST
//            mappedBy = "show",
//            cascade = CascadeType.PERSIST,
//            fetch = FetchType.LAZY
    )
    private List<Seat> seats = new ArrayList<>();

    public Show(String title, Integer duration, LocalDateTime showStart, String description /*Dodatkowe*/, String director, String scenario, String type, String production, String premiere, Float ratingFromFilmweb, Float criticsRating, String pictureName, String trailerLink) {
        this.title = title;
        this.duration = duration;
        this.showStart = showStart;
        this.description = description;
        //Dodatkowe
        this.director = director;
        this.scenario = scenario;
        this.type = type;
        this.production = production;
        this.premiere = premiere;
        this.ratingFromFilmweb = ratingFromFilmweb;
        this.criticsRating = criticsRating;
        this.pictureName = pictureName;
        this.trailerLink = trailerLink;

    }
/*
    public Show(String title, int duration, LocalDateTime parse, String description, String joss_whedon, String joss_whedon1, String type, String usa, String premiere, double v, double v1, String picture_avengers_czas_ultrona_13_kwietnia_2015, String trailerLink) {
    }

 */
}
