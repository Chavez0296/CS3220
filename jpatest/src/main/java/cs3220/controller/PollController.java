package cs3220.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import cs3220.model.Poll;
import cs3220.repository.PollRepository;

@Controller
public class PollController {

	private final PollRepository repo;
	

	public PollController(PollRepository repo) {
		this.repo = repo;
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("polls", repo.findAll());
		return "index";
	}

	@GetMapping("/view/{id}")
	public String view(@PathVariable int id, Model model) {
		model.addAttribute("poll", repo.findById(id).orElse(null));
		return "view";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("poll", new Poll("",false));
		return "add";
	}

	@PostMapping("/add")
	public String add( @ModelAttribute("poll") Poll poll) {
		repo.save(poll);
		return "redirect:/";
	}

	@GetMapping("/answers/{id}")
	public String answers(@PathVariable int id, Model model) {
		model.addAttribute("poll", repo.findById(id).orElse(null));
		return "answers";
	}

	@PostMapping("/answers/{id}")
	public String answers(@PathVariable int id, String answer) {
		
		Poll poll = repo.findById(id).orElse(null);
		poll.getAnswers().add(answer);
		repo.save(poll);
		return "redirect:/";
	}
}

