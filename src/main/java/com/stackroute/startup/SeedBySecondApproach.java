package com.stackroute.startup;

import com.stackroute.domain.Track;
import org.springframework.boot.CommandLineRunner;

public class SeedBySecondApproach implements CommandLineRunner {
    Track track=null;
    @Override
    public void run(String... args) throws Exception {

        track.setId(001);
        track.setTrackName("MyFirstSong");
        track.setComments("MyFavoriteVoice");
    }
}
