package by.timey.speller.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;


@Entity
@Table(name = "dictionary")
@Data
public class WordTranslation {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictionary_id_seq")
  @SequenceGenerator(name = "dictionary_id_seq", allocationSize = 1)
  private long id;

  @Column(name = "english_word")
  private String englishWord;

  @Column(name = "russian_word")
  private String russianWord;
}
