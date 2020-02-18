package de.schmidtdennis.popupchinese.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.schmidtdennis.popupchinese.data.dto.Vocabulary;

/**
 * VocabularyRepository
 */
@Repository
public interface VocabularyRepository extends CrudRepository<Vocabulary, Long> {

    List<Vocabulary> findByLessonIdOrderByVocabularyIdAsc(Integer lessonId);

}