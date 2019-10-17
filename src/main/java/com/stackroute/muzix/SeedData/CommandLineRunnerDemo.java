package com.stackroute.muzix.SeedData;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.propertyconfig.MyConfigurationProperty;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@EnableConfigurationProperties(MyConfigurationProperty.class)
@Component
public class CommandLineRunnerDemo implements CommandLineRunner {
   @Autowired
   private TrackRepository trackRepository;

   @Value("${id1}")
   private int id;
   @Value("${name1}")
   private String trackName;
   @Value("${comment1}")
   private String comment;

   @Autowired
   private MyConfigurationProperty configurationProperty;

   @Override
   public void run(String... args) throws Exception {
       trackRepository.save(new Track(id, trackName, comment));
       trackRepository.save(new Track(configurationProperty.getId(), configurationProperty.getName(), configurationProperty.getComment()));
   }
}