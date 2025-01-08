package org.zerock.mallapi.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.mallapi.dto.TodoDTO;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class TodoServiceTests {

  @Autowired
  private TodoService todoService;

  @Test
  public void testRegister() {

    TodoDTO todoDTO = TodoDTO.builder()
            .title( "서비스 테스트" )
            .writer( "tester" )
            .dueDate(LocalDate.of( 2025, 1,8 ) )
            .build();

    Long tno = todoService.register( todoDTO );

    log.info( "TNO : " + tno );
  }
}
