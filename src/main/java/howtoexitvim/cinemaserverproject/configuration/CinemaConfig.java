package howtoexitvim.cinemaserverproject.configuration;

import howtoexitvim.cinemaserverproject.seat.SeatRepository;
import howtoexitvim.cinemaserverproject.show.Show;
import howtoexitvim.cinemaserverproject.show.ShowRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Configuration
public class CinemaConfig {

    @Bean
    CommandLineRunner commandLineRunner(ShowRepository showRepository, SeatRepository seatRepository) {

        return args -> {

            Show show1 = new Show("AVENGERS: CZAS ULTRONA", 142,  LocalDateTime.of(2021, 04, 17 ,12, 00) , "Najpotężniejsi bohaterowie na Ziemi łączą swoje siły, aby zniszczyć Ultrona.", "Joss Whedon", "Joss Whedon", "Akcja / Sci-Fi", "USA", "13 kwietnia 2015(świat)", 7.2f, 6.4f, "picture_avengers_czas_ultrona_13_kwietnia_2015","https://www.youtube.com/embed/tmeOjFno6Do");
            Show show2 = new Show("LIGA SPRAWIEDLIWOŚCI ZACKA SNYDERA", 242,  LocalDateTime.of(2021, 04, 17 ,12, 00) , "Bruce Wayne, chcąc mieć pewność, że poświęcenie Supermana nie poszło na marne, łączy siły z Dianą Prince, by zwerbować zespół superbohaterów, którzy ochronią świat przed zbliżającym się niebezpieczeństwem.", "Zack Snyder", "Chris Terrio", "Akcja / Sci-Fi", "USA", "18 marca 2021 (świat)", 7.1f, 4.8f, "picture_liga_sprawiedliwosci_zacka_snydera_18_marca_2021","https://www.youtube.com/embed/vM-Bja2Gy04");
            Show show3 = new Show("SALA SAMOBÓJCÓW. HEJTER", 142,  LocalDateTime.of(2021, 04, 20 ,14, 50) , "Wydalony z Uniwersytetu Warszawskiego student prawa, zostaje przyłapany na plagiacie. Postanawia jednak ukrywać ten fakt przed światem i nadal pobiera pomoc finansową od państwa Krasuckich.", "Jan Komasa", "Mateusz Pacewicz", "Thriller", "Polska", "5 marca 2020 (świat)", 7.0f, 6.9f, "picture_sala_samobojcow_hejter_5_marca_2020","https://www.youtube.com/embed/1J-90nGlzBE");

            List lista = new ArrayList();
            lista.add(show1);
            lista.add(show2);
            lista.add(show3);
            showRepository.saveAll(lista);


        };

    }

}


