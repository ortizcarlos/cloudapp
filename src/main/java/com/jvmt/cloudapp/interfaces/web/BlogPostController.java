package com.jvmt.cloudapp.interfaces.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jvmt.cloudapp.domain.BlogEntry;
import com.jvmt.cloudapp.persistence.InMemoryStore;

@Controller
public class BlogPostController {
	private static final Logger LOG = LoggerFactory
			.getLogger(BlogPostController.class);

	private InMemoryStore store;

	public BlogPostController(InMemoryStore store) {
		this.store = store;
	}

	@RequestMapping("/writePost")
	public String home() {
		return "write";
	}

	@RequestMapping(value = "/sendPost", method = RequestMethod.POST)
	public String dashboard(
			@RequestBody MultiValueMap<String, String> formData,
			RedirectAttributes redirectAttributes) {
		String title = (String) formData.get("title").get(0);
		String content = (String) formData.get("content").get(0);

		LOG.debug("Title {}", title);
		LOG.debug("Content {}", content);
		store.saveBlogEntry(new BlogEntry(title, content));
		String message = "Your Post was saved!";
		//redirectAttributes.addFlashAttribute("message", message);
		//redirectAttributes.addFlashAttribute("result", store.listAll());
		return "result";
	}

	@RequestMapping("/result")
	public String dashboard() {
		return "result";
	}
}
