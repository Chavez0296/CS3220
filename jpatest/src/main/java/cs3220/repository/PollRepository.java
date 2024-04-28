package cs3220.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import cs3220.model.Poll;

@Repository
public interface PollRepository extends CrudRepository<Poll, Integer> {
	List<Poll> findByQuestion(String question);
}
