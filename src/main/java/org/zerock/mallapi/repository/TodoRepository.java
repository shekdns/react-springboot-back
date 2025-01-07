package org.zerock.mallapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.mallapi.domain.Todo;

//별도의 메소드 등을 작성하지 않아도 CRUD와 페이징 처리 등의 기능이 제공
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
