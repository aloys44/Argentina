package fr.MelodyApp.services;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import fr.MelodyApp.model.Notice;

@Validated
public interface NoticeService {

	@NotNull Iterable<Notice> getAllNotices();
	
	Notice getNotice(@Min (value= 1L, message="Invalid Notice ID.") long id);
	
	Notice save(Notice notice);
}
