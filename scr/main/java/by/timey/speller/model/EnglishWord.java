package by.timey.speller.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "english_words")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "translation")
@ToString(exclude = "translation")
public class EnglishWord {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "english_word_id_seq")
  @SequenceGenerator(name = "english_word_id_seq", allocationSize = 1)
  private long id;

  private String word;

  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
  @JoinTable(
      name = "dictionary",
      joinColumns = { @JoinColumn(name = "english_word_id") },
      inverseJoinColumns = { @JoinColumn(name = "russian_word_id")}
  )
  private Set<String> translation = new HashSet<>();
}
