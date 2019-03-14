package by.timey.speller.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;

import java.util.Set;

@Entity
@Table(name = "words")
@Data
public class WordTranslation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "words_seq_gen")
  @SequenceGenerator(name = "words_seq_gen", sequenceName = "words_id_seq")
  private long id;

  @Column(name = "english_word")
  private String word;

  @Column(name = "russian_translation")
  private Set<String> translation;
}
