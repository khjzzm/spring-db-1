package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class MemberRepositoryVOTest {

    MemberRepositoryV0 repositoryV0 = new MemberRepositoryV0();

    @Test
    void crud () throws SQLException {
        Member member = new Member("memberVO", 100000);
        repositoryV0.save(member);
    }
}
