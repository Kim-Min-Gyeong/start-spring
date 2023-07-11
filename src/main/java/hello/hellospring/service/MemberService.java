package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional //jpa를 사용하기 위해
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    /**
     * 회원 가입
     */
    public Long join(Member member){
        //같은 이름을 가진 중복 회원 x
        /* ctrl + alt + m으로 method로 만듦.
        memberRepository.findByName(member.getName()).ifPresent(m -> { //null이 아닌 값이 존재하면(optional로 반환해서 가능)
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        */
        long start = System.currentTimeMillis();
        try {
            validateDuplicateMember(member); //중복 회원 검증
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");
        }

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    //null이 아닌 값이 존재하면(optional로 반환해서 가능)
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        long start = System.currentTimeMillis();
        try{
            return memberRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("fineMembers = " + timeMs + "ms");
        }

    }

    public Optional<Member> findOne(Long memberID){
        return memberRepository.findById(memberID);
    }


}