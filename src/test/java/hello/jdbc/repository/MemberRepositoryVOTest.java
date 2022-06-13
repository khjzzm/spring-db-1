package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class MemberRepositoryVOTest {

    MemberRepositoryV0 repositoryV0 = new MemberRepositoryV0();

    @Test
    void crud () throws SQLException {
        Member member = new Member("memberVO", 100000);
        repositoryV0.save(member);

        Member findMember = repositoryV0.findById(member.getMemberId());
        log.info("findMember={}", findMember);
        assertThat(findMember).isEqualTo(member);
    }
}