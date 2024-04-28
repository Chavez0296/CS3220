package cs3220;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cs3220.model.Event;

@Configuration
public class DataConfig {
	@Bean
	List<Event> events(){
		List<Event> events = new ArrayList<Event>();
		events.add(new Event("Event1", LocalDate.now(),"Him from @Bean"));
		events.add(new Event("Event2", LocalDate.now().plusDays(5),"Her"));
		return events;
	}
}
