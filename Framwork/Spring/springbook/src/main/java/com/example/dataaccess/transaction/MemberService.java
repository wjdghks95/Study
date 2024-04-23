package com.example.dataaccess.transaction;

import com.example.dataaccess.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class MemberService {
    @Autowired private MemberDao memberDao;
    private TransactionTemplate transactionTemplate;

    @Autowired
    public void init(PlatformTransactionManager transactionManager) {
        // PlatformTransactionManager: 구체적인 트랜잭션 매니저의 종류에 상관없이 동일한 트랜잭션 경계설정 기능을 이용할 수 있다.
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    public void addMembers(final List<Member> members) {
        this.transactionTemplate.execute(new TransactionCallback<Object>() {
            // 트랜잭션 안에서 동작하는 코드. 트랜잭션 매니저와 연결되어 있는 모든 DAO는 같은 트랜잭션에 참여한다.
            @Override
            public Object doInTransaction(TransactionStatus status) {
                for (Member member : members) {
                    memberDao.add(member);
                }
                // 정상적으로 작업을 마치고 리턴되면 트랜잭션은 커밋된다.
                // 만약 이전에 시작한 트랜잭션에 참여했다면 해당 트랜잭션의 작업을 모두 마칠 때까지 커밋은 보류된다.
                // 리턴되기 이전에 예외가 발생하면 트랜잭션은 롤백된다.
                return null;
            }
        });
    }
}
