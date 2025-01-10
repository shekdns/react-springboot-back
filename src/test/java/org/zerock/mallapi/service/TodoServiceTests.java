package org.zerock.mallapi.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.mallapi.domain.Todo;
import org.zerock.mallapi.dto.PageRequestDTO;
import org.zerock.mallapi.dto.PageResponseDTO;
import org.zerock.mallapi.dto.TodoDTO;
import org.zerock.mallapi.repository.TodoRepository;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class TodoServiceTests {

  @Autowired
  private TodoService todoService;
  @Autowired
  private TodoRepository todoRepository;

//  @Test
//  public void testRegister() {
//
//    TodoDTO todoDTO = TodoDTO.builder()
//            .title( "서비스 테스트" )
//            .writer( "tester" )
//            .dueDate(LocalDate.of( 2025, 1,8 ) )
//            .build();
//
//    Long tno = todoService.register( todoDTO );
//
//    log.info( "TNO : " + tno );
//  }

//  @Test
//  public void testGet() {
//    Long tno = 201L;
//
//    TodoDTO todoDto = todoService.get(tno);
//
//    log.info( "TNO = " + todoDto.getTno() );
//  }

//  @Test
//  public void testSave() {
//    Long tno = 201L;
//
//    TodoDTO todoDTO = todoService.get( tno );
//    todoDTO.setComplete( true );
//    todoDTO.setTitle( "서비스 테스트2" );
//    todoDTO.setDueDate( LocalDate.of( 2025, 1,10 ) );
//
//    todoService.modify( todoDTO );
//
//    log.info( "MODIFY SUCCESS" );
//  }

//  @Test
//  public void testDelete() {
//    Long tno = 201L;
//
//    todoService.remove( tno );
//
//    log.info( "REMOVE SUCCESS" );
//  }

  @Test
  public void testList() {
    PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
            .page( 2 )
            .size( 10 )
            .build();

    PageResponseDTO<TodoDTO> responseDTO = todoService.list( pageRequestDTO );

    log.info( responseDTO );
  }
}
