package fr.MelodyApp.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.MelodyApp.model.Notice;
import fr.MelodyApp.model.User;
import fr.MelodyApp.repository.NoticeRepository;
import fr.MelodyApp.services.NoticeService;
import fr.MelodyApp.services.OrderService;

@RestController
@RequestMapping("/api/auth/notices")
@CrossOrigin()
public class NoticeController {
	
	private NoticeService noticeService;
	private NoticeRepository noticeRepository;

	
	public NoticeController(NoticeService noticeService,
				NoticeRepository noticeRepository ) {
		this.noticeService = noticeService;
		this.noticeRepository = noticeRepository;

	}

	@GetMapping(value = { "", "/" })
	public @NotNull Iterable<Notice> getAllNotices(){
		return noticeService.getAllNotices();
		
	}
	
	@GetMapping("/getListBestNotice")
    public Iterable<Notice> getBestNotice() {
    	return noticeRepository.getBestNotice();
    }
	

	
    @PostMapping("/add")
    void addNotice(@RequestBody Notice notice, Long id) {
    	noticeService.save(notice);
    	
    }

}
