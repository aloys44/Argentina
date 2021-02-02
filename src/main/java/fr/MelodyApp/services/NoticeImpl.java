package fr.MelodyApp.services;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.MelodyApp.model.Notice;
import fr.MelodyApp.repository.NoticeRepository;
import fr.exception.ResourceNotFoundException;

@Service
@Transactional
public class NoticeImpl implements NoticeService{

	private NoticeRepository noticeRepository;
	
	
	public NoticeImpl(NoticeRepository noticeRepository) {
		this.noticeRepository = noticeRepository;
	}

	@Override
	public Iterable<Notice> getAllNotices() {
		return noticeRepository.findAll();
	}

	@Override
	public Notice getNotice(@Min(value = 1, message = "Invalid Notice ID.") long id) {
		return noticeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notice not found"));
	}

	@Override
	public Notice save(Notice notice) {
		return noticeRepository.save(notice);
	}

}
