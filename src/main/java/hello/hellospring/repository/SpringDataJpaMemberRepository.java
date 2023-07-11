package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//SpringDataJpaRepository가 자동으로 구현체를 만들어 줌. 스프링 빈에 등록해놓음.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository { //interface가 interface를 받을 때는 extends 사용
    @Override
    Optional<Member> findByName(String name);

}
