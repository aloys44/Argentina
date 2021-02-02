package fr.MelodyApp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.MelodyApp.model.Notice;
import fr.MelodyApp.model.Product;

public interface NoticeRepository extends CrudRepository<Notice,Long> {
	
	@Query("SELECT o FROM Notice o WHERE o.note<=4")
	public Iterable<Notice> getBestNotice();

}
