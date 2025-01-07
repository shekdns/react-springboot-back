package org.zerock.mallapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/*
* MySQL의 스토리지 엔진으로 가장 많이 사용하는 엔진으로는 InnoDB와 MyISAM이 있다.

InnoDB 엔진은 트랜잭션 처리가 필요하고 대용량의 데이터를 다루는 부분에서 효율적이고,
MyISAM 엔진은 트랜잭션 처리가 필요 없고, Read only 기능이 많은 서비스일수록 효율적이다.

한줄로 정리하면, InnoDB는 데이터의 변화가 많은 서비스에, MyISAM은 SELECT가 많은 서비스에 적합하다 할 수 있다.

용도에 따라 InnoDB나 MyISAM 스토리지 엔진을 결정하는데, InnoDB와 MyISAM 테이블을 같이 사용할 경우, 조인시 주의해야한다
*
* */

@Entity
@Table( name = "tbl_todo" )
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY )
  private Long tno;

  private String title;

  private String writer;

  private boolean complete;

  private LocalDate dueDate;

  public void changeTitle( String title ) {
    this.title = title;
  }

  public void changeComplete( boolean complete ) {
    this.complete = complete;
  }

  public void changeDueDate( LocalDate dueDate ) {
    this.dueDate = dueDate;
  }
}
