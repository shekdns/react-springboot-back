package org.zerock.mallapi.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.mallapi.domain.Todo;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

  @Autowired
  private TodoRepository todoRepository;

//  @Test
//  public void testInsert() {  // 등록
//    log.info( "-----------------" );
//    for( int i = 1; i <= 100; i++ ) {
//      Todo todo = Todo.builder()
//              .title( "Title..." + i )
//              .dueDate( LocalDate.of( 2025,01,07 ) )
//              .writer( "user00" )
//              .build();
//
//      todoRepository.save( todo );
//    }
//  }

//  @Test
//  public void testRead() { //조회 또는 수정
//    Long tno = 33L;
//
//    Optional<Todo> result = todoRepository.findById( tno );
//
//    Todo todo = result.orElseThrow();
//    todo.changeTitle( "Modified 33..." );
//    todo.changeComplete( true );
//    todo.changeDueDate( LocalDate.of( 2025,01,30 ) );
//
//    todoRepository.save(  todo );
//  }

//  @Test
//  public void testDelete() { //삭제
//    Long tno = 1L;
//
//    todoRepository.deleteById( tno );
//  }
  @Test
  public void testPaging() {
    Pageable pageable = PageRequest.of( 0, 10, Sort.by( "tno" ).descending() );

    Page<Todo> result = todoRepository.findAll( pageable );
    log.info( result.getTotalElements() );

    result.getContent().stream().forEach( todo -> log.info( todo ) );
  }
}