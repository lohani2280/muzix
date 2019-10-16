package com.stackroute.muzix.SeedData;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerDemo implements ApplicationListener<ContextRefreshedEvent> {
   @Autowired
   private TrackRepository trackRepository;
   @Override
   public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
       trackRepository.save(new Track(1, "Memories", "New Released"));
   }
}
