package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); //저장 기능
    Optional<Member> findById(Long id); //optional - null을 처리하는 법
    Optional<Member> findByName(String name);
    List<Member> findAll();


}
