package com.stackroute.startup;

import com.stackroute.domain.Track;
import lombok.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class SeedByFirstApproach implements ApplicationListener<ContextStartedEvent> {
    Track track;
    @Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
       track.setId(00);
        track.setTrackName("MyTrack");
        track.setComments("MyAlbum");


       /* @Value("${trackId:00}")
        private int trackId;

        @Value("#{'${trackName:}'}")
        private String trackName;

        @Value("#{config['mongodb.url']?:'127.0.0.1'}")
        private String mongodbUrl;*/
    }
}
