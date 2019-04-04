package by.timey.speller.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"user\"")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "userWords")
@ToString(exclude = "userWords")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
  @SequenceGenerator(name = "user_id_seq", allocationSize = 1)
  private int id;

  @Column
  private String login;

  @Column
  private String password;

  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(name = "user_dictionary",
  joinColumns = { @JoinColumn(name = "user_id")},
  inverseJoinColumns = { @JoinColumn(name = "pair_id")})
  private Set<WordTranslation> userWords = new HashSet<>();
}
