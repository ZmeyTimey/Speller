package by.timey.speller.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"user\"")
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq_gen")
  @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_id_seq")
  private int id;

  @Column
  private String login;

  @Column
  private String password;

  @ManyToMany
  @JoinTable(name = "user_words",
  joinColumns = { @JoinColumn(name = "user_id")},
  inverseJoinColumns = { @JoinColumn(name = "word_id")})
  private Set<WordTranslation> userWords = new HashSet<>();
}
