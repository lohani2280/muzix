package com.stackroute.muzix.SeedData;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerDemo implements CommandLineRunner {
   @Autowired
   private TrackRepository trackRepository;
   @Override
   public void run(String... args) throws Exception {
       trackRepository.save(new Track(2, "Sanorita", "favorite music"));
   }
}