package com.example.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lookify.models.Song;
import com.example.lookify.services.SongService;

import jakarta.validation.Valid;

@Controller
public class SongController {
	
	@Autowired
	SongService songService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}

	@GetMapping("/dashboard")
	public String dashboard(@ModelAttribute("song") Song song, Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@PostMapping("/dashboard")
	public String dashboard(@ModelAttribute("artist") String artist, Model model) {
		model.addAttribute("artist", artist);
		return"redirect:/search/"+artist;	
	}
	
	@GetMapping("/search/{artist}")
	public String search(@PathVariable("artist") String artist, Model model) {
		model.addAttribute("song", songService.findByArtist(artist));
		return "searchResult.jsp";
	}

	@GetMapping("/songs/new")
	public String addSong(@ModelAttribute("song") Song song) {
		return "add.jsp";
	}

	@PostMapping("/songs/add")
	public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		}else {
			songService.addSong(song);
			return "redirect:/dashboard";
		}
	}
	
	
	
	@GetMapping("/songs/{id}")
	public String details(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "details.jsp";
	}

	@GetMapping("/top-ten")
	public String top(Model model) {
		List<Song> songs = songService.topTen();
		model.addAttribute("songs", songs);
		return "top.jsp";
	}
	/*
	@RequestMapping("/songs/{id}/delete")
	public String deleteSong(@PathVariable("id") Long id) {
		songService.deleteSong(songService.findSong(id));
		return "redirect:/dashboard";
	}
	*/
}
