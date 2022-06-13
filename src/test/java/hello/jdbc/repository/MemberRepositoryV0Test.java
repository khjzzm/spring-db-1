package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
public class MemberRepositoryV0Test {

    MemberRepositoryV0 repositoryV0 = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        Member member = new Member("memberVO", 100000);
        repositoryV0.save(member);

        Member findMember = repositoryV0.findById(member.getMemberId());
        log.info("findMember={}", findMember);
        assertThat(findMember).isEqualTo(member);

        repositoryV0.update(member.getMemberId(), 20000);
        Member updatedMember = repositoryV0.findById(member.getMemberId());
        assertThat(updatedMember.getMoney()).isEqualTo(20000);

        repositoryV0.delete(member.getMemberId());
        assertThatThrownBy(() -> repositoryV0.findById(member.getMemberId())).isInstanceOf(NoSuchElementException.class);

    }
}