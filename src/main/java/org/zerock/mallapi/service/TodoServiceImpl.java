package org.zerock.mallapi.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.mallapi.domain.Todo;
import org.zerock.mallapi.dto.TodoDTO;
import org.zerock.mallapi.repository.TodoRepository;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor // 생성자 자동 주입
public class TodoServiceImpl implements TodoService {

  private final ModelMapper modelMapper;

  private final TodoRepository todoRepository;

  @Override
  public Long register(TodoDTO todoDTO) {

    log.info( "......" );

    Todo todo = modelMapper.map( todoDTO, Todo.class );

    Todo savedTodo = todoRepository.save( todo );

    return savedTodo.getTno();
  }
}
